# PSS - Laboratorio JavaFX

Esercizi su proprietà osservabili e binding, layout, eventi e separazione tra modello, vista e controller, in riferimento alle [slide del corso](https://unibo-lptsi-pss.github.io/22-gui/#/).

## Requisiti

- **JDK 25**, sia per Gradle sia per compilare ed eseguire gli esercizi.
- **Gradle 9.9.1**, fornito dal wrapper: non occorre installarlo separatamente.
- **JavaFX 25**, scaricato automaticamente da Maven Central.
- Una sessione grafica per eseguire le applicazioni.

Impostare `JAVA_HOME` sulla directory del JDK 25 e, nell'IDE, selezionare lo stesso JDK come JVM di Gradle. Verificare la configurazione con `./gradlew --version` (Windows: `.\gradlew.bat --version`). Il primo avvio richiede una connessione a Internet per scaricare Gradle e le dipendenze.

## Struttura del progetto

Il progetto usa un solo wrapper Gradle nella root e quattro sotto-progetti, dichiarati in `settings.gradle.kts`:

- [`javafx-1-property`](javafx-1-property/README.md): lampadina osservabile e binding con la GUI.
- [`javafx-1b-property-volume`](javafx-1b-property-volume/README.md): regolatore del volume e sincronizzazione tra modello e GUI.
- [`javafx-2-layouts`](javafx-2-layouts/README.md): costruzione della GUI di una TODO list in due checkpoint, form e colonne dei task.
- [`javafx-3-fxml`](javafx-3-fxml/README.md): modello osservabile e controller della TODO list. Il nome della cartella è storico: l'esercizio usa la GUI costruita in Java, senza richiedere FXML.

Il `build.gradle.kts` nella root contiene la configurazione comune: toolchain Java 25, moduli JavaFX, JUnit e repository. I file nei sotto-progetti specificano le rispettive classi di avvio. Queste sono separate dalla sottoclasse di `Application`, come indicato nelle slide.

Le dipendenze native JavaFX sono selezionate in base all'architettura della JVM: Windows, Linux e macOS per x86-64; Linux e macOS per ARM64 (inclusi i Mac Apple Silicon). Usare un JDK adatto alla propria piattaforma. Le distribuzioni e i JAR prodotti includono le librerie per l'architettura della JVM usata per la build.

## Compilazione e avvio

Dalla root, per compilare e creare le distribuzioni di tutti gli esercizi:

```shell
./gradlew build
```

Per avviare un esercizio su Linux o macOS:

```shell
./gradlew :javafx-1-property:run
./gradlew :javafx-1b-property-volume:run
./gradlew :javafx-2-layouts:run
./gradlew :javafx-3-fxml:run
```

Su Windows, da PowerShell:

```powershell
.\gradlew.bat :javafx-1-property:run
.\gradlew.bat :javafx-1b-property-volume:run
.\gradlew.bat :javafx-2-layouts:run
.\gradlew.bat :javafx-3-fxml:run
```

Gli esercizi contengono intenzionalmente metodi da completare e GUI parziali: una build riuscita verifica la compilazione, ma non implica che gli esercizi siano già risolti. JUnit è configurato per i test che si vorranno aggiungere; inizialmente non sono presenti test.

Per creare il JAR eseguibile del terzo esercizio:

```shell
./gradlew :javafx-3-fxml:shadowJar
java -jar javafx-3-fxml/build/libs/javafx-3-fxml-all.jar
```

I task `run`, gli script delle distribuzioni e il manifest del JAR eseguibile abilitano l'accesso nativo necessario a JavaFX su JDK 25.

La CI compila tutti gli esercizi su Windows, macOS e Linux con JDK 25 e verifica il wrapper Gradle.

Per chiarimenti o domande, non esitate a chiamare i docenti.
