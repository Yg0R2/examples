package yg0r2.examples.extensions

import org.gradle.api.artifacts.ModuleDependency
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.addToConfiguration(configurationName: String, dependencyNotation: Any): ModuleDependency =
    add(configurationName, dependencyNotation) as ModuleDependency
