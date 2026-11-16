# Esercizio sui layout di JavaFX: la TODO list

In questo esercizio si costruisce gradualmente l'interfaccia grafica di una TODO list,
procedendo in due sottoesercizi.
L'obiettivo è prendere dimestichezza con la composizione dei controlli e
l'organizzazione dei contenitori,
riprendendo le sezioni dedicate ai layout e
al dimensionamento nelle [slide del corso](https://unibo-lptsi-pss.github.io/22-gui/#/).

In questa fase i dati mostrati sono puramente statici:
i pulsanti **Add** e **X** devono comparire nell'interfaccia,
ma non devono ancora eseguire alcuna azione,
poiché la logica applicativa verrà introdotta nell'esercizio successivo.

## 2A — Il form

Nel primo sottoesercizio occorre completare il metodo `createInputPane()` inserendo un titolo "Todo List",
un campo di testo e un pulsante "Add", disposti in verticale.
Il form occupa l'area sinistra della finestra, mentre l'area centrale rimane per il momento vuota.

Si chiede allo studente di focalizzarsi prima sull'ordine degli elementi
e poi di considerare anche spacing, padding e allineamento:

- **Spacing:** distanza fra i componenti figli di un contenitore.
- **Padding:** spazio interno fra il bordo del contenitore e i suoi componenti.
- **Alignment:** posizione dei componenti all'interno dello spazio disponibile.

In JavaFX queste proprietà si impostano rispettivamente tramite `setSpacing(...)`, `setPadding(new Insets(...))` e `setAlignment(...)`
sui contenitori che le supportano.

![Confronto fra padding, spacing e allineamento TOP_CENTER in un VBox](layout-properties.svg)

Per il form si utilizzi l'allineamento `Pos.TOP_CENTER`.

![Sottoesercizio 2A: form nella parte sinistra e area centrale vuota](checkpoint-form.png)

**Verifica intermedia:** il titolo, il campo di testo e il pulsante devono apparire in verticale,
ben distanziati sia tra loro sia rispetto ai bordi della finestra.
Nel campo è possibile scrivere del testo,
mentre la pressione di "Add" non produce ancora alcun effetto.

## 2B — Le colonne dei task

Mantenendo il form realizzato nella prima parte,
si completi ora il metodo `createTasksPane()` per popolare l'area centrale della finestra.
Questo pannello deve presentare un'intestazione "Tasks" seguita,
più in basso,
da due colonne affiancate:

- **Todo:** contiene la relativa intestazione e due attività di esempio, "Task 1" e "Task 2", ciascuna formata dal testo e da un pulsante "X" sulla stessa riga. A tal fine si completi e si riutilizzi il metodo `createTaskSection(String content)`.
- **Done:** contiene l'intestazione e un'unica attività completata, "Task 3", mostrata come testo disabilitato e priva di pulsante.

I tre task vanno inseriti direttamente nel codice, lasciando allo studente la scelta di come combinare i contenitori per ottenere la disposizione illustrata in figura.

![Sottoesercizio 2B: form e due colonne con task statici](schema.png)

**Verifica finale:** le due colonne devono risultare affiancate, con i rispettivi task disposti in verticale e il testo dell'attività completata visualizzato come disabilitato. Anche in questo caso, la pressione dei pulsanti "X" non deve modificare i task.

Ai fini dell'esercizio è importante la corretta struttura dei contenitori, mentre non è richiesta una riproduzione identica delle dimensioni o delle spaziature mostrate nell'immagine.

## Avvio

Per avviare l'applicazione dalla cartella principale del progetto, eseguire `./gradlew :javafx-2-layouts:run` (oppure `.\gradlew.bat :javafx-2-layouts:run` su Windows).
