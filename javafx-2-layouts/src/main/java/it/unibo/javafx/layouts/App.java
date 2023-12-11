package it.unibo.javafx.layouts;

import javafx.application.Application;
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
    public void start(Stage primaryStage) throws Exception {
        // Il root è un BorderPane, che divide la finestra in 5 aree: top, bottom, left, right, center.
        // Noi usiamo solo left e center.
        BorderPane root = new BorderPane();
        // Aggiungo i fogli di stile
        root.getStylesheets().add("dracula.css");
        root.getStylesheets().add("style.css");
        root.setId("root");
        // Left Pane, contiene il titolo e il form per aggiungere nuovi task.
        VBox leftPane = new VBox();
        leftPane.setId("left-pane");
        leftPane.setAlignment(Pos.TOP_CENTER); // allinea i figli in alto al centro.
        Label leftPaneTitle = new Label("Todo App");
        leftPaneTitle.getStyleClass().add("title-1"); // aggiungo la classe CSS "title-1" al titolo.
        leftPaneTitle.getStyleClass().add("accent"); // aggiungo la classe CSS "accent" al titolo.
        // field per aggiungere nuovi task
        TextField newTaskField = new TextField();
        Button addButton = new Button("Add");
        // Aggiungo i nodi al leftPane
        leftPane.getChildren().addAll(leftPaneTitle, newTaskField, addButton);
        // Center Pane, contiene la lista dei task.
        VBox rightPane = new VBox();
        rightPane.setId("right-pane");
        rightPane.setAlignment(Pos.TOP_CENTER);
        Label rightPaneTitle = new Label("Tasks");
        rightPaneTitle.getStyleClass().addAll("accent", "title-2");
        // Area dei task, contiene due liste: una per i task da fare e una per i task completati.
        HBox tasksArea = new HBox();
        // Occupa tutto lo spazio a disposizione.
        VBox.setVgrow(tasksArea, Priority.ALWAYS);
        tasksArea.setId("tasks-area");
        VBox todoList = new VBox();
        todoList.setAlignment(Pos.TOP_CENTER);
        VBox doneList = new VBox();
        doneList.setAlignment(Pos.TOP_CENTER);
        Label todoPart = new Label("Todo");
        todoPart.getStyleClass().add("title-3");
        // Set font size to 14 and bold
        Label donePart = new Label("Done");
        donePart.getStyleClass().add("title-3");
        todoList.getChildren().add(todoPart);
        doneList.getChildren().add(donePart);
        // Setta la larghezza minima delle liste
        HBox.setHgrow(todoList, Priority.ALWAYS);
        HBox.setHgrow(doneList, Priority.ALWAYS);
        tasksArea.getChildren().addAll(todoList, doneList);
        rightPane.getChildren().addAll(rightPaneTitle, tasksArea);
        // Aggiungo dei task di esempio
        var task1 = createTaskSection("Task1");
        var task2 = createTaskSection("Task2");
        todoList.getChildren().addAll(task1, task2);
        // Aggiungo dei task completati di esempio
        VBox doneTask = new VBox(new Label("Task 2"));
        doneTask.getStyleClass().add("task");
        doneList.getChildren().add(doneTask);
        // Imposto i pannelli sinistro e centrale come figli del root.
        root.setLeft(leftPane);
        root.setCenter(rightPane);

        // Set scene and stage
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("ToDo List App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static class Main {
        public static void main(String... args) {
            Application.launch(App.class, args);
        }
    }

    // Crea un todo composto da una label e un bottone per segnare il task come completato.
    public static Node createTaskSection(String content) {
        HBox task = new HBox();
        task.getStyleClass().add("task");
        Label taskLabel = new Label(content);
        VBox textBox = new VBox(taskLabel);
        Button doneButton = new Button("X");
        HBox.setHgrow(textBox, Priority.ALWAYS);
        task.getChildren().addAll(textBox, doneButton);
        return task;
    }
}
