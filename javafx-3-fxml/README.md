# Esercizio su modello osservabile e controller in JavaFX

Questo esercizio sviluppa la parte logica di quello precedente, applicando proprietà osservabili, eventi e separazione delle responsabilità descritti nelle [slide del corso](https://unibo-lptsi-pss.github.io/22-gui/#/).
Il nome della cartella `javafx-3-fxml` è mantenuto per compatibilità; non è necessario usare FXML. La GUI viene costruita in Java, come nel secondo esercizio.
Il layout deve seguire quello fatto nell'esercizio precedente.
L'applicazione è una semplice TODO list, che permette di aggiungere task e segnarli come completati.
Un todo è composto solo da una descrizione. 
L'applicazione (definita in `TodoApp.java`) permette l'inserimento e il completamento di task, e la visualizzazione di quelli da fare e di quelli completati.
In particolare, i todo sono *osservabili* attraverso le Property di una `ObservableList`.

## Passi per la realizzazione dell'applicazione

- Costruisci in `App.start` la GUI del secondo esercizio e collegala al `TodoAppHandler`, passando il modello, il campo di testo e i contenitori delle due liste.
- Collega il pulsante "Add" al metodo `addTodo` con `setOnAction`.
- Sviluppa la classe `TodoAppImpl` che implementa l'interfaccia `TodoAppObservable`
- Implementa i metodi in `TodoAppHandler`
    - nota: per semplicità, ad ogni cambiamento delle liste, rimuovere tutti gli elementi presenti e aggiungerli nuovamente

