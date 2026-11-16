package it.unibo.javafx.property;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(final Stage primaryStage) {
        final Lamp lamp = new Lamp();
        final VBox mainPane = new VBox();
        // TODO creare il riquadro, la label e i due pulsanti come nel README.
        // TODO collegare gli eventi dei pulsanti ai metodi di lamp.
        // TODO usare binding condizionali per il colore e il testo dello stato.
        primaryStage.setTitle("Lampadina osservabile");
        primaryStage.setScene(new Scene(mainPane));
        primaryStage.show();
    }

    public static class Main {
        static void main(final String... args) {
            Application.launch(App.class, args);
        }
    }
}
