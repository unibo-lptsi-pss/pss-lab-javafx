# PSS - Laboratorio JavaFX

Questo repository raccoglie gli esercizi di laboratorio su JavaFX dedicati a proprietà osservabili e binding, layout, gestione degli eventi e separazione tra modello, vista e controller (MVC), in riferimento alle [slide del corso](https://unibo-lptsi-pss.github.io/22-gui/#/).

## Struttura del progetto

Il progetto utilizza un unico wrapper Gradle nella cartella principale ed è articolato in quattro sottoprogetti, dichiarati in `settings.gradle.kts`:

- [`javafx-1-property`](javafx-1-property/README.md): lampadina osservabile e collegamento con l'interfaccia tramite binding.
- [`javafx-1b-property-volume`](javafx-1b-property-volume/README.md): regolatore del volume e sincronizzazione tra modello e interfaccia.
- [`javafx-2-layouts`](javafx-2-layouts/README.md): costruzione dell'interfaccia di una TODO list in due sottoesercizi (form di inserimento e colonne dei task).
- [`javafx-3-mvc`](javafx-3-mvc/README.md): sviluppo di modello, vista e controller della TODO list secondo il pattern MVC.

Il file `build.gradle.kts` principale raccoglie la configurazione comune a tutti i moduli (toolchain Java 25, moduli JavaFX, JUnit e repository), mentre i file di build dei singoli sottoprogetti specificano soltanto la rispettiva classe di avvio, mantenuta separata dalla sottoclasse di `Application` come indicato nelle slide.

Le librerie native di JavaFX vengono selezionate automaticamente in base al sistema operativo e all'architettura della JVM (Windows, Linux e macOS su x86-64, oppure Linux e macOS su ARM64, inclusi i Mac con Apple Silicon). Si raccomanda pertanto di utilizzare un JDK nativo per la propria piattaforma, tenendo presente che le distribuzioni e i JAR generati includono le librerie relative alla JVM impiegata in fase di compilazione.

## Compilazione e avvio

Dalla cartella principale del progetto, per compilare tutti gli esercizi e generare le relative distribuzioni è sufficiente eseguire:

```shell
./gradlew build
```

Per avviare un singolo esercizio su Linux o macOS:

```shell
./gradlew :javafx-1-property:run
./gradlew :javafx-1b-property-volume:run
./gradlew :javafx-2-layouts:run
./gradlew :javafx-3-mvc:run
```

Su Windows, da PowerShell:

```powershell
.\gradlew.bat :javafx-1-property:run
.\gradlew.bat :javafx-1b-property-volume:run
.\gradlew.bat :javafx-2-layouts:run
.\gradlew.bat :javafx-3-mvc:run
```

Poiché gli esercizi contengono intenzionalmente metodi da completare e interfacce parziali, la sola compilazione (eseguibile senza i test tramite `./gradlew assemble`) non implica che gli esercizi siano già risolti. Nel progetto è inoltre configurato JUnit e il modulo `javafx-3-mvc` include una suite di test di unità per il modello, destinata a fallire finché i relativi metodi non vengono implementati.

I task `run`, gli script di avvio delle distribuzioni e il manifest del JAR eseguibile sono già predisposti per abilitare l'accesso nativo richiesto da JavaFX su JDK 25.

Per chiarimenti o domande, non esitate a chiamare i docenti.
Nel branch `solution` trovate gli esercizi completati (vi chiediamo di guardarci dopo la lezione).
