package cern.ais.datawarehouse.pentahopluginbuilder

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Created by Lukasz Janicki (lukasz.janicki@cern.ch) on 10/03/2016.
 */
class BuildPentahoPlugin implements Plugin<Project> {

    void apply(Project project) {

        project.configurations {
            plugin {
                description = "Dependencies added to lib folder for plugin"
            }
            compile {
                extendsFrom plugin
            }
        }

        project.tasks.create(name: 'buildPentahoPlugin', dependsOn: 'jar') << {

            def jarDir = new File(project.getBuildDir(), 'libs')
            def outputDir = new File(project.getBuildDir(), 'plugin')
            def pluginDir = new File(outputDir, project.name)

            println 'Copy config files'
            project.copy {
                from new File('plugin-config').absolutePath
                into pluginDir.absolutePath
            }

            println 'Copy jar'
            project.copy {
                from jarDir
                into new File(pluginDir, 'lib').absolutePath
            }

            println 'Copy of dependencies marked to be added to lib'
            project.copy {
                from project.configurations.plugin
                into new File(pluginDir, 'lib').absolutePath
            }

            println 'Copy all dependencies'
            project.copy {
                from project.configurations.compile
                into new File(outputDir, 'depedencies').absolutePath
            }
        }
    }
}