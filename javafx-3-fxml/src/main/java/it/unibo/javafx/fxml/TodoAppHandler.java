package it.unibo.javafx.fxml;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.List;
import java.util.Objects;

/**
 * Controller for the `JavaFXAppWithFXML` application.
 */
public class TodoAppHandler {
    private TodoAppObservable model;
    @FXML
    private TextField todoText;
    @FXML
    private VBox tasksTodo;
    @FXML
    private VBox tasksDone;
    public TodoAppHandler() {
        this.model = new TodoAppImpl();
        this.model.todosProperty().addListener((observable, oldValue, newValue) -> updateTodos(newValue));
        this.model.completedTodosProperty().addListener((observable, oldValue, newValue) -> updateDone(newValue));
    }

    @FXML
    public final void addTodo(final MouseEvent evt) {
        if(Objects.nonNull(todoText.getText()) && !todoText.getText().isEmpty()) {
            model.addNewTodo(todoText.getText());
        }
    }

    private void updateTodos(List<Todo> todos) {
        tasksTodo.getChildren().clear();
        todos.forEach(this::insertTodoGraphic);
    }

    private void updateDone(List<Todo> todos) {
        tasksDone.getChildren().clear();
        todos.forEach(this::insertCompleted);
    }

    private void insertTodoGraphic(Todo todo) {
        var todoGraphic = new HBox();
        todoGraphic.getStyleClass().add("task");
        var todoText = new TextField(todo.getContent());
        todoText.setEditable(false);
        var todoButton = new Button("X");
        todoButton.setOnMouseClicked(event -> model.completeTodo(todo));
        todoGraphic.getChildren().addAll(todoText, todoButton);
        tasksTodo.getChildren().add(todoGraphic);
    }

    private void insertCompleted(Todo todo) {
        var todoGraphic = new HBox();
        todoGraphic.getStyleClass().add("task");
        var todoText = new TextField(todo.getContent());
        todoText.setEditable(false);
        todoGraphic.getChildren().addAll(todoText);
        tasksDone.getChildren().add(todoGraphic);
    }
}
