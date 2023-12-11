# Esercizio sull'uso di FXML (e dei controller) in JavaFX

Questo esercizio sviluppa la parte logica di quello precedente.
Il layout è già stato definito usando CSS e FXML, generato automaticamente da Scene Builder.
L'applicazione è una semplice TODO list, che permette di aggiungere e rimuovere task.
Un todo è composto solo da una descrizione. 
L'applicazione (definita in `TodoApp.java`) permette l'inserimento e la rimozione di task, e la visualizzazione di quelli presenti.
In particolare, i todo sono osservabili attraverso le Property di una ObservableList.

## Passi per la realizzazione dell'applicazione
- Sviluppa la class TodoAppImpl che implementa l'interfaccia TodoAppObservable
- Implementa i metodi in TodoAppHandler (caricato come controller in todo.fxml)
    - nota: per semplicità, ad ogni cambiamento delle liste, rimuovere tutti gli elementi presenti e aggiungerli nuovamente

