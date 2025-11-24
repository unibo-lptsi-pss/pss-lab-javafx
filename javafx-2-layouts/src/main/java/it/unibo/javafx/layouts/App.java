package it.unibo.javafx.layouts;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
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
    public void start(Stage primaryStage) throws Exception {
        // Il root è un BorderPane, che divide la finestra in 5 aree: top, bottom, left, right, center.
        // Noi usiamo solo left e center.
        BorderPane root = new BorderPane();
        // Left Pane, contiene il titolo e il form per aggiungere nuovi task.
        VBox leftPane = new VBox();
        leftPane.setAlignment(Pos.TOP_CENTER);
        leftPane.setSpacing(10);
        leftPane.setPadding(new Insets(10));

        Label title = new Label("Todo List");
        TextField newTaskField = new TextField();
        Button addButton = new Button("Add");

        leftPane.getChildren().addAll(title, newTaskField, addButton);

        // Right Pane, contiene il task da fare e i task fatti (vedi l'immagine)
        VBox rightPane = new VBox();
        rightPane.setSpacing(10);
        rightPane.setPadding(new Insets(10));

        Label tasksTitle = new Label("Tasks");

        HBox columns = new HBox();
        columns.setSpacing(20);

        VBox todoColumn = new VBox();
        todoColumn.setSpacing(10);
        Label todoLabel = new Label("Todo");
        todoColumn.getChildren().add(todoLabel);
        todoColumn.getChildren().add(createTaskSection("Task 1"));
        todoColumn.getChildren().add(createTaskSection("Task 2"));

        VBox doneColumn = new VBox();
        doneColumn.setSpacing(10);
        Label doneLabel = new Label("Done");
        doneColumn.getChildren().add(doneLabel);
        Node doneTask = new Label("Task 3");
        doneTask.setDisable(true);
        doneColumn.getChildren().add(doneTask);

        columns.getChildren().addAll(todoColumn, doneColumn);
        HBox.setHgrow(todoColumn, Priority.ALWAYS);
        HBox.setHgrow(doneColumn, Priority.ALWAYS);

        rightPane.getChildren().addAll(tasksTitle, columns);

        // Imposto i pannelli sinistro e centrale come figli del root.
        root.setLeft(leftPane);
        root.setCenter(rightPane);

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("ToDo List App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static class Main {
        static void main(String... args) {
            Application.launch(App.class, args);
        }
    }

    // Crea un todo composto da una label e un bottone per segnare il task come completato.
    private static Node createTaskSection(String content) {
        final HBox box = new HBox();
        final Label label = new Label(content);
        final Button button = new Button("X");
        box.getChildren().addAll(label, button);
        box.setSpacing(10);
        return box;
    }
}
