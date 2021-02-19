## How to apply this plugin

- Add local Maven repository to `settings.gradle`
```groovy
pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
    }
}
```

- Import the plugin
```groovy
plugins {
    id 'greeting' version '0.0.1-SNAPSHOT'
}
```

## Plugin configuration

- `greeting` task
```groovy
greeting {
    message = "Hi"
    greeter = "Yg0R2"
}
```
- `sayGreeting` task
```groovy
ext["greetingFile"] = "$buildDir/hello.txt"
```
