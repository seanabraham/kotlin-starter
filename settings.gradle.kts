/*
 * This file was generated by the Gradle 'init' task.
 *
 * The settings file is used to specify which projects to include in your build.
 *
 * Detailed information about configuring a multi-project build in Gradle can be found
 * in the user guide at https://docs.gradle.org/5.1/userguide/multi_project_builds.html
 */

rootProject.name = "kotlin-starter"

pluginManagement {
    resolutionStrategy {
        eachPlugin {
            // This won't be necessary when kotlinx-serialization is published in the gradle plugin portal
            if (requested.id.id == "kotlinx-serialization") {
                useModule("org.jetbrains.kotlin:kotlin-serialization:${requested.version}")
            }
        }
    }
}