package it.unibo.javafx.volume;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(final Stage primaryStage) {
        final Volume volume = new Volume();
        final VBox mainPane = new VBox();
        // TODO completare la GUI e il collegamento al modello come richiesto nel README.
        primaryStage.setTitle("Volume osservabile");
        primaryStage.setScene(new Scene(mainPane));
        primaryStage.show();
    }

    public static class Main {
        public static void main(final String... args) {
            Application.launch(App.class, args);
        }
    }
}
