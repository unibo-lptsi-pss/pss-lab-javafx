plugins {
    base
}

// Configurazione comune agli esercizi, coerente con le slide del corso.
subprojects {
    apply(plugin = "application")

    repositories {
        mavenCentral()
    }

    extensions.configure<JavaPluginExtension> {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(25))
        }
    }

    val javaFXModules = listOf("base", "controls", "fxml", "swing", "graphics")
    val javaFxVersion = "25"
    // Le librerie native devono avere la stessa architettura della JVM.
    val supportedPlatforms = when (System.getProperty("os.arch")) {
        "aarch64", "arm64" -> listOf("linux-aarch64", "mac-aarch64")
        else -> listOf("linux", "mac", "win")
    }

    dependencies {
        for (platform in supportedPlatforms) {
            for (module in javaFXModules) {
                add("implementation", "org.openjfx:javafx-$module:$javaFxVersion:$platform")
            }
        }
        add("compileOnly", "com.github.spotbugs:spotbugs-annotations:4.10.5")
        add("testImplementation", platform("org.junit:junit-bom:6.1.3"))
        add("testImplementation", "org.junit.jupiter:junit-jupiter")
        add("testRuntimeOnly", "org.junit.platform:junit-platform-launcher")
    }

    tasks.withType<JavaCompile>().configureEach {
        options.encoding = "UTF-8"
    }

    tasks.withType<Test>().configureEach {
        useJUnitPlatform()
    }

    extensions.configure<JavaApplication> {
        applicationDefaultJvmArgs = listOf("--enable-native-access=ALL-UNNAMED")
    }
}

tasks.named("build") {
    dependsOn(subprojects.map { "${it.path}:build" })
}

tasks.named("check") {
    dependsOn(subprojects.map { "${it.path}:check" })
}

tasks.named("clean") {
    dependsOn(subprojects.map { "${it.path}:clean" })
}
