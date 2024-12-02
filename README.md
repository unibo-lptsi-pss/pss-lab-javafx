# PSS - Laboratorio Java FX

### Appunto su Gradle

In questo repository vi viene fornito un progetto Gradle con una struttura di base per un progetto JavaFX.

Notate la struttura di questo progetto, diversa da quella die repository che avete visto fino ad ora:

- Esiste un solo gradle wrapper, nella root del progetto;
- Esistono dei sotto-progetti, rispettivamente `java-fx-1-property`, `java-fx-2-layouts`, e `javafx-3-xml`.
In gradlew è possibile specificare i sotto-progetti attraverso il file `settings.gradle.kts`.


Ai fini del laboratorio, rispetto agli scorsi repository non cambia quasi nulla.
Dato che però avete a disposizione un solo wrapper,
dovete selezionare il sotto-progetto su cui lanciare il task di `run`.

Per esempio, per lanciare il task `run` del sotto-progetto `java-fx-1-property`, potete usare i seguenti comandi:

Windows:
```shell
./gradlew.bat :java-fx-1-property:run
```

Linux o Mac:
```shell
./gradlew :java-fx-1-property:run
```

Per chiarimenti o domande, non esitate a chiedere ai docenti.