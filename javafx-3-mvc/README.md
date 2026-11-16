# Esercizio su modello, vista e controller (MVC) in JavaFX

Sviluppare la parte logica della TODO list in tre step.
L'obiettivo è collegare modello e GUI usando eventi e liste osservabili,
riprendendo le sezioni su proprietà e listener delle [slide del corso](https://unibo-lptsi-pss.github.io/22-gui/#/).

La GUI del secondo esercizio è già predisposta in `App`.
Le due liste partono vuote: i task statici dell'esercizio precedente non sono presenti.
Il modello è in `TodoAppImpl`, la vista è costruita in `App` e il controller è `TodoAppHandler`.

## Step 3A — Il modello

Completare `addNewTodo(...)` e `completeTodo(...)` in `TodoAppImpl`.
Ogni `Todo` contiene una descrizione; il modello mantiene una lista dei task da fare e una dei task completati.

Aggiungere un task deve inserirlo nella lista dei task da fare.
Completarlo deve spostarlo nella lista dei completati.
Se il task non è fra quelli da fare, completarlo non deve modificare le liste.

Le due liste sono osservabili attraverso le `ListProperty` già predisposte.
I singoli `Todo` non contengono proprietà osservabili.

**Verifica:** aggiungere due task e completarne uno.
Il modello deve contenere un task da fare e uno completato.
Ripetere il completamento dello stesso task non deve aggiungere duplicati.

## Step 3B — Aggiungere dalla GUI

In `App.start`, creare il modello e il `TodoAppHandler`,
passando il campo di testo e i contenitori `todoItems` e `doneItems`.
Collegare il pulsante Add al metodo `addTodo(...)` del controller.

Completare `addTodo(...)` e `insertTodoGraphic(...)` in `TodoAppHandler`.
Add deve aggiungere il testo al modello e poi svuotare il campo.
Se il campo è vuoto, non deve aggiungere task.
Ogni task da fare deve comparire con il testo e un pulsante X, che sarà collegato nello step successivo.

Il controller contiene già i listener delle due liste e il metodo `updateTodos(...)`.
Gli eventi modificano il modello; i listener aggiornano la vista.

**Verifica:** scrivere due descrizioni e aggiungerle una alla volta.
Entrambe devono comparire in Todo e il campo deve svuotarsi dopo ogni inserimento.
Premere Add con il campo vuoto non deve modificare la lista.

## Step 3C — Completare dalla GUI

Collegare il pulsante X di ogni riga al completamento del task corrispondente nel modello.
Completare `updateDone(...)` e `insertCompleted(...)` nel controller.
I task completati devono comparire in Done come testo disabilitato, senza pulsante.

Per semplicità, a ogni cambiamento di una lista, ricostruire tutte le sue righe.
I contenitori `todoItems` e `doneItems` contengono solo i task:
le intestazioni Todo e Done devono restare visibili anche quando le liste sono vuote.

**Verifica:** aggiungere due task e completarne uno premendo X.
Il task deve scomparire da Todo e comparire in Done.
Completare anche l'altro task e verificare che entrambe le intestazioni restino visibili.

## Avvio

Dalla root: `./gradlew :javafx-3-mvc:run` (Windows: `.\gradlew.bat :javafx-3-mvc:run`).
