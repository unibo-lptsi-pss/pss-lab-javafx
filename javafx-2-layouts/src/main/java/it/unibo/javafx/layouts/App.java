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
        /** Create a todo list application with a list of tasks and a form to add new tasks.
         * the pane has two part.
         * On the left there is a pane to add new todo items. They are only composed of a text field and a button to add it
         * The pane should has a title and a border (on the right)
         * In the right part, there is another pane with a title.
         * Inside the pane, on the left there are the todo items to do and on the right the todo items done.
         * The todo items are composed of a label with the text and a button to mark it as done.
         * The pane should has a title and a border (on the right)
         * */

        BorderPane root = new BorderPane();
        root.getStylesheets().add("dracula.css");
        root.getStylesheets().add("style.css");
        root.setId("root");
        // Left Pane
        VBox leftPane = new VBox();
        leftPane.setId("left-pane");
        // add border with style

        leftPane.setAlignment(Pos.TOP_CENTER);
        Label leftPaneTitle = new Label("Todo App");
        leftPaneTitle.getStyleClass().add("title-1");
        leftPaneTitle.getStyleClass().add("accent");

        leftPaneTitle.setAlignment(Pos.CENTER);
        leftPane.getChildren().add(leftPaneTitle);

        TextField newTaskField = new TextField();
        Button addButton = new Button("Add");
        leftPane.getChildren().addAll(newTaskField, addButton);

        // Right Pane
        VBox rightPane = new VBox();
        rightPane.setId("right-pane");
        rightPane.setAlignment(Pos.TOP_CENTER);
        Label rightPaneTitle = new Label("Tasks");
        rightPaneTitle.getStyleClass().addAll("accent", "title-2");
        rightPane.getChildren().add(rightPaneTitle);

        HBox tasksArea = new HBox();
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
        HBox.setHgrow(todoList, Priority.ALWAYS);
        HBox.setHgrow(doneList, Priority.ALWAYS);
        tasksArea.getChildren().addAll(todoList, doneList);
        rightPane.getChildren().add(tasksArea);

        // Add panes to root
        root.setLeft(leftPane);
        root.setCenter(rightPane);

        var task1 = createTaskSection("Task1");
        var task2 = createTaskSection("Task2");
        todoList.getChildren().addAll(task1, task2);

        // Example of one task done
        VBox doneTask = new VBox(new Label("Task 2"));
        doneTask.getStyleClass().add("task");
        doneList.getChildren().add(doneTask);
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
