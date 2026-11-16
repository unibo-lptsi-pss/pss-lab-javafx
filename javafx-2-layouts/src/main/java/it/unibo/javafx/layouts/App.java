package it.unibo.javafx.layouts;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(final Stage primaryStage) {
        final BorderPane root = new BorderPane();
        root.setLeft(createInputPane());
        root.setCenter(createTasksPane());

        primaryStage.setTitle("ToDo List App");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    // Checkpoint 2A: costruire il form.
    private static VBox createInputPane() {
        final VBox pane = new VBox();
        // TODO completare come richiesto nel README.
        return pane;
    }

    // Checkpoint 2B: costruire l'area Tasks con le due colonne e i dati statici.
    private static VBox createTasksPane() {
        final VBox pane = new VBox();
        // TODO completare come richiesto nel README.
        return pane;
    }

    // Checkpoint 2B: costruire una riga dei task da fare.
    private static Node createTaskSection(final String content) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public static class Main {
        public static void main(final String... args) {
            Application.launch(App.class, args);
        }
    }
}
