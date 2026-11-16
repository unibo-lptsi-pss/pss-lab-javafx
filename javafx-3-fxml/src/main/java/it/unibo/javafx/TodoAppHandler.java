package it.unibo.javafx;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.List;

/**
 * Controller for the TODO list application.
 */
public class TodoAppHandler {
    private final TodoAppObservable model;
    private final TextField todoText;
    private final VBox tasksTodo;
    private final VBox tasksDone;
    public TodoAppHandler(
        TodoAppObservable model,
        TextField todoText,
        VBox tasksTodo,
        VBox tasksDone
    ) {
        this.model = model;
        this.todoText = todoText;
        this.tasksTodo = tasksTodo;
        this.tasksDone = tasksDone;
        // aggiungo un listener sulla lista dei todos
        this.model.todosProperty().addListener((observable, oldValue, newValue) -> updateTodos(newValue));
        // aggiungo un listener sulla lista dei completedTodos
        this.model.completedTodosProperty().addListener((observable, oldValue, newValue) -> updateDone(newValue));
    }

    // Step 3B: aggiungere il task al modello e svuotare il campo, se non è vuoto.
    public final void addTodo(final ActionEvent evt) {
        // TODO
    }

    // Ricostruisce le righe dei task da fare quando cambia la lista osservabile.
    private void updateTodos(List<Todo> todos) {
        tasksTodo.getChildren().clear();
        todos.forEach(this::insertTodoGraphic);
    }

    // Step 3C: ricostruire le righe dei task completati.
    private void updateDone(List<Todo> todos) {
        // TODO
    }

    // Step 3B: creare e inserire una riga con il testo e il pulsante X.
    // Step 3C: collegare X al completamento del task nel modello.
    private void insertTodoGraphic(Todo todo) {
        var todoGraphic = new HBox();
        // TODO
    }

    // Step 3C: inserire il testo disabilitato del task completato, senza pulsante.
    private void insertCompleted(Todo todo) {
        var todoGraphic = new HBox();
        // TODO
    }
}
