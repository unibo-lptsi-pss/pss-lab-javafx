# Esercizio sulle proprietà di JavaFX
Questo esercizio si focalizza sull'utilizzo delle `properties` in JavaFX, una delle caratteristiche fondamentali del framework. Per approfondimenti, si rimanda alla [documentazione ufficiale di JavaFX](https://openjfx.io/javadoc/25/javafx.base/javafx/beans/property/Property.html).

## Obiettivi dell'Esercizio

### 1. Implementare un Contatore Osservabile
L'obiettivo è completare l'implementazione della classe `Counter` fornita.

**Compiti:**
- Esaminare la classe `Counter` esistente.
- Implementare i metodi `increment()` e `decrement()`, utilizzando le API delle proprietà di JavaFX.

  **Nota importante:**
  - L'uso di `property.add(1)` non è corretto, poiché restituisce una nuova proprietà senza modificare quella originale. Per incrementare o decrementare il valore, è necessario utilizzare `property.set(property.get() + 1)` o una logica equivalente.

### 2. Sviluppare la GUI
L'obiettivo è sviluppare l'interfaccia grafica (GUI) all'interno della classe `App`.

**Compiti:**
- Esaminare la classe `App` esistente.
- Creare una GUI corrispondente all'immagine di esempio seguente:
- ![](./example.png)
- Implementare la logica per i pulsanti `+` e `-` in modo che possano, rispettivamente, incrementare e decrementare il valore del contatore.
  - Utilizzare il metodo `setOnAction` per associare un'azione al click di ciascun pulsante.
  - **Nota importante:** Impostare la larghezza minima dei pulsanti a 100 pixel tramite `setMinWidth(100)`.
- Assicurarsi che la label visualizzi sempre il valore corrente del contatore.
  - Utilizzare il metodo `bind` per collegare la proprietà di testo della label alla proprietà del contatore.
