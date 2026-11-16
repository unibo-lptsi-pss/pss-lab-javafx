package it.unibo.javafx.layouts;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
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
        final VBox pane = new VBox(10);
        pane.setPadding(new Insets(10));
        pane.setAlignment(Pos.TOP_CENTER);
        pane.getChildren().addAll(new Label("Todo List"), new TextField(), new Button("Add"));
        return pane;
    }

    // Checkpoint 2B: costruire l'area Tasks con le due colonne e i dati statici.
    private static VBox createTasksPane() {
        final VBox todo = new VBox(10, new Label("Todo"),
            createTaskSection("Task 1"), createTaskSection("Task 2"));
        final Label completed = new Label("Task 3");
        completed.setDisable(true);
        final VBox done = new VBox(10, new Label("Done"), completed);
        final HBox columns = new HBox(20, todo, done);

        // Estensione: distribuire lo spazio orizzontale disponibile fra le colonne.
        HBox.setHgrow(todo, Priority.ALWAYS);
        HBox.setHgrow(done, Priority.ALWAYS);

        final VBox pane = new VBox(10, new Label("Tasks"), columns);
        pane.setPadding(new Insets(10));
        return pane;
    }

    // Checkpoint 2B: costruire una riga dei task da fare.
    private static Node createTaskSection(final String content) {
        return new HBox(10, new Label(content), new Button("X"));
    }

    public static class Main {
        public static void main(final String... args) {
            Application.launch(App.class, args);
        }
    }
}
