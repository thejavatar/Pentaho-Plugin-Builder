package cern.ais.datawarehouse.pentahopluginbuilder

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test

import static org.junit.Assert.assertTrue

/**
 * Created by Lukasz Janicki (lukasz.janicki@cern.ch) on 11/03/2016.
 */
class BuildPentahoPluginTest {

    @Test
    public void taskIsAddedToGradle() {
        Project project = ProjectBuilder.builder().build()
        project.plugins.apply BuildPentahoPlugin

        assertTrue(project.tasks.buildPentahoPlugin != null)
    }

}
