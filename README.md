# Pentaho-Plugin-Builder
The main objective of this plugin is to create a folder that you can simply copy to pentaho-solutions directory inside Pentaho Installation folder to deploy your plugin. 

Following things will happen to achieve this:
- a plugin folder will be created in the build folder of your project
- inside this folder two folders will be created:
  - one called dependencies - with all dependencies of your plugin
  - one called the same way as your gradle project - all files related to your plugin will be stored here (let's call this folder: PLUGIN_FOLDER)
- all files from folder: plugin-config inside your project will be moved PLUGIN_FOLDER
- the jar archive will be created with the code of your plugin
- this jar will be copied to PLUGIN_FOLDER/lib
- all dependencies marked as plugin in your build.gradle will be copied to PLUGIN_FOLDER/lib.

## How do I start?

### Import plugin

Pentaho-Plugin-Builder is part of https://plugins.gradle.org/ , that means that you can use it:

- either by adding following to your build.gradle (**for Gradle >= 2.1**):

```
plugins {
  id "cern.ais.datawarehouse.pentahopluginbuilder" version "1.5"
}
```

- or by adding:

```
buildscript {
  repositories {
    maven {
      url "https://plugins.gradle.org/m2/"
    }
  }
  dependencies {
    classpath "gradle.plugin.cern-ais:cern-build-pentaho-plugin:1.5"
  }
}

apply plugin: "cern.ais.datawarehouse.pentahopluginbuilder"
```

### Using the plugin

**In order for the plugin to work, you need to create a plugin-config directory inside the root folder of your project.**

![alt tag](http://thejavatar.com/wp-content/uploads/2016/03/plugin_01.jpg)

To build plugin run buildPentahoPlugin task:

![alt tag](http://thejavatar.com/wp-content/uploads/2016/03/plugin_03.jpg)

As a result inside build/plugin directory a folder with the same name as your project's name will be created. Copy this folder into pentaho-solutions directory inside your Pentaho Platform installation. Restart Pentaho Platform and enjoy your new plugin!

## Where do I put plugin.xml and plugin.spring.xml files?

Put these files inside plugin-config folder. All files from this directory will be copied to your plugin's root directory.

![alt tag](http://thejavatar.com/wp-content/uploads/2016/03/plugin_01.jpg)

## How to copy a project's dependency to plugin's lib folder?

Mark this dependency as plugin. The plugin dependency will be handled by gradle the same way as a compile one. Additionally it will be added to plugin's lib folder.

![alt tag](http://thejavatar.com/wp-content/uploads/2016/03/plugin_02.jpg)

