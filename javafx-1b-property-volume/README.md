# Esercizio sulle proprietà di JavaFX: il volume

Realizzare un regolatore del volume con uno slider da 0 a 100, una label con il valore corrente e un pulsante **Reset**.

Il volume iniziale è **50**. Spostando lo slider, il valore nel modello e il testo della label devono aggiornarsi. Premendo Reset, il volume torna a 50 e anche lo slider deve tornare nella posizione corrispondente.

| Stato iniziale e dopo Reset | Dopo aver spostato lo slider |
| --- | --- |
| ![Volume iniziale a 50](example.png) | ![Volume impostato a 80](example-volume.png) |

Completare le classi `Volume` e `App`, usando le proprietà di JavaFX per mantenere sincronizzati modello e interfaccia. Gli eventi devono modificare il modello; gli aggiornamenti della vista devono avvenire tramite binding.

Verificare anche più spostamenti consecutivi dello slider e più pressioni del pulsante Reset.

Avviare dalla root con `./gradlew :javafx-1b-property-volume:run` (Windows: `.\gradlew.bat :javafx-1b-property-volume:run`).
