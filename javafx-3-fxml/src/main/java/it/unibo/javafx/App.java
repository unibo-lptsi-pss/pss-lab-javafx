package it.unibo.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class App extends Application {

    @Override
    public final void start(final Stage primaryStage) throws Exception {
        // Layout from Exercise 2
        BorderPane root = new BorderPane();

        VBox leftPane = new VBox();
        leftPane.setAlignment(Pos.TOP_CENTER);
        leftPane.setSpacing(10);
        leftPane.setPadding(new Insets(10));

        Label title = new Label("Todo List");
        TextField newTaskField = new TextField();
        Button addButton = new Button("Add");

        leftPane.getChildren().addAll(title, newTaskField, addButton);

        VBox rightPane = new VBox();
        rightPane.setSpacing(10);
        rightPane.setPadding(new Insets(10));

        Label tasksTitle = new Label("Tasks");

        HBox columns = new HBox();
        columns.setSpacing(20);

        VBox todoColumn = new VBox();
        todoColumn.setSpacing(10);
        Label todoLabel = new Label("Todo");
        VBox todoItems = new VBox();
        todoItems.setSpacing(10);
        todoColumn.getChildren().addAll(todoLabel, todoItems);

        VBox doneColumn = new VBox();
        doneColumn.setSpacing(10);
        Label doneLabel = new Label("Done");
        VBox doneItems = new VBox();
        doneItems.setSpacing(10);
        doneColumn.getChildren().addAll(doneLabel, doneItems);

        columns.getChildren().addAll(todoColumn, doneColumn);
        HBox.setHgrow(todoColumn, Priority.ALWAYS);
        HBox.setHgrow(doneColumn, Priority.ALWAYS);

        rightPane.getChildren().addAll(tasksTitle, columns);

        root.setLeft(leftPane);
        root.setCenter(rightPane);

        // Logic wiring
        TodoAppObservable model = new TodoAppImpl();
        TodoAppHandler handler = new TodoAppHandler(model, newTaskField, todoItems, doneItems);

        addButton.setOnMouseClicked(handler::addTodo);

        final Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("App With Logic");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static class Launcher {
        void main(String[] args) {
            Application.launch(App.class, args);
        }
    }
}
