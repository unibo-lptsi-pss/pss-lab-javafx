plugins {
    application
    // ./gradlew :javafx-3-mvc:shadowJar crea il JAR eseguibile in build/libs.
    id("com.gradleup.shadow") version "9.6.1"
}

application {
    mainClass.set("it.unibo.javafx.App\$Launcher")
}

tasks.jar {
    manifest {
        attributes("Enable-Native-Access" to "ALL-UNNAMED")
    }
}
