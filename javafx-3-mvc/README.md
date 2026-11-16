# Esercizio su modello, vista e controller (MVC) in JavaFX

In questo esercizio si sviluppa la logica applicativa della TODO list, procedendo gradualmente in tre passi.
L'obiettivo è collegare il modello all'interfaccia grafica sfruttando la gestione degli eventi e le liste osservabili,
riprendendo le sezioni dedicate a proprietà e listener nelle [slide del corso](https://unibo-lptsi-pss.github.io/22-gui/#/).

L'interfaccia grafica del secondo esercizio è già predisposta nella classe `App`, ma in questo caso le due colonne partono vuote, senza i task statici di esempio.
L'applicazione è organizzata secondo il pattern MVC: il modello risiede in `TodoAppImpl`, la vista è costruita in `App` e il ruolo di controller è svolto da `TodoAppHandler`.

## 3A — Il modello

Come primo passo si chiede allo studente di completare i metodi `addNewTodo(...)` e `completeTodo(...)` nella classe `TodoAppImpl`.
Ogni oggetto `Todo` racchiude semplicemente una descrizione testuale, mentre il modello mantiene due liste distinte, una per i task ancora da fare e una per quelli già completati.

Quando viene aggiunto un nuovo task, questo va inserito nella lista delle attività da fare, mentre quando viene completato occorre rimuoverlo da tale lista e spostarlo tra i completati. Qualora il task passato a `completeTodo(...)` non sia presente fra quelli da fare, l'operazione non deve modificare nessuna delle due liste.

Si noti che l'osservabilità riguarda le due collezioni, esposte tramite le `ListProperty` già predisposte nella classe, mentre i singoli oggetti `Todo` non contengono proprietà osservabili.

**Verifica:** nella classe `TodoAppImplTest` sono già predisposti dei test di unità strutturati secondo lo schema Arrange / Act / Assert che illustrano il comportamento atteso del modello, inclusa la gestione dei duplicati e delle notifiche sulle liste osservabili. È possibile eseguirli dalla cartella principale con `./gradlew :javafx-3-mvc:test` (oppure `.\gradlew.bat :javafx-3-mvc:test` su Windows) per controllare che passino tutti una volta completata l'implementazione.

## 3B — Aggiunta dei task dall'interfaccia

Nel metodo `App.start` occorre ora istanziare il modello e il controller `TodoAppHandler`, passando al suo costruttore il modello stesso, il campo di testo e i contenitori `todoItems` e `doneItems`, per poi associare la pressione del pulsante "Add" al metodo `addTodo(...)` del controller.

Si completino quindi i metodi `addTodo(...)` e `insertTodoGraphic(...)` in `TodoAppHandler`: quando l'utente preme "Add", il testo inserito deve essere aggiunto al modello e il campo di input va svuotato, avendo cura di ignorare l'operazione se il campo è vuoto. Ogni task da svolgere deve comparire nella colonna "Todo" con la propria descrizione affiancata da un pulsante "X", che verrà collegato nel passo successivo.

Nel costruttore del controller sono già registrati i listener sulle due liste osservabili ed è già presente il metodo `updateTodos(...)`: in questo modo gli eventi generati dall'interfaccia si limitano a modificare il modello, mentre sono i listener ad aggiornare di conseguenza la vista.

**Verifica:** digitando due descrizioni e aggiungendole una alla volta, entrambe devono comparire sotto "Todo" e il campo di testo deve svuotarsi dopo ciascun inserimento. Premendo "Add" con il campo vuoto, invece, la lista deve restare invariata.

## 3C — Completamento dei task dall'interfaccia

Nell'ultimo passo si chiede di collegare il pulsante "X" di ciascuna riga al completamento del task corrispondente nel modello, implementando inoltre i metodi `updateDone(...)` e `insertCompleted(...)` nel controller. Le attività completate devono comparire nella colonna "Done" come testo disabilitato e prive di pulsante.

Per semplicità, a ogni cambiamento di una lista si suggerisce di svuotare il relativo contenitore e ricostruire tutte le righe da capo, come già avviene in `updateTodos(...)`. Poiché i contenitori `todoItems` e `doneItems` ospitano soltanto le voci delle due liste, le intestazioni "Todo" e "Done" devono restare visibili anche quando le liste sono vuote.

**Verifica:** aggiungendo due task e premendo "X" sul primo, questo deve scomparire da "Todo" e comparire disabilitato in "Done". Completando anche il secondo task, la colonna "Todo" resterà vuota e "Done" conterrà entrambi i task completati; le rispettive intestazioni dovranno rimanere visibili.

## Avvio

Per avviare l'applicazione dalla cartella principale del progetto, eseguire `./gradlew :javafx-3-mvc:run` (oppure `.\gradlew.bat :javafx-3-mvc:run` su Windows).
