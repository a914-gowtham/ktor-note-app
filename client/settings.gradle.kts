dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        jcenter() // Warning: this repository is going to shut down soon
        maven { url = java.net.URI("https://jitpack.io") }
    }
}
rootProject.name = "Noteapp-Client"
include(":app")
include(":core")
include(":note")
include(":note:ui-register")
include(":note:ui-login")
include(":components")
include(":note:note-domain")
include(":note:ui-home")
include(":note:note-interactors")
