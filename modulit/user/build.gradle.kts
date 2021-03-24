buildscript {
    repositories {
        mavenLocal()
        mavenCentral()
        gradlePluginPortal()
        maven {
            name = "github"
            url = uri("https://maven.pkg.github.com/Yg0R2/examples/")
            credentials(PasswordCredentials::class)
        }
    }
    dependencies {
        classpath("yg0r2.examples:gradle-plugin:+")
    }
}

apply(plugin = "dependency")
