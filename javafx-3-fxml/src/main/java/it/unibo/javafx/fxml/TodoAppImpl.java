package it.unibo.javafx.fxml;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;

import java.util.List;

public class TodoAppImpl implements TodoAppObservable  {
    private final ListProperty<Todo> todos; // ho una lista di todos, ma osservabile
    private final ListProperty<Todo> completedTodos;

    public TodoAppImpl() {
        // creo una lista osservabile di todos e di completedTodos
        this.todos = new SimpleListProperty<>(FXCollections.observableArrayList());
        this.completedTodos = new SimpleListProperty<>(FXCollections.observableArrayList());
    }

    @Override
    public ListProperty<Todo> todosProperty() {
        return todos;
    }

    @Override
    public ListProperty<Todo> completedTodosProperty() {
        return completedTodos;
    }

    @Override
    public Todo addNewTodo(String content) {
        var todo = new Todo(content);
        todos.add(todo); // add provoca un evento di aggiornamento
        return todo;
    }

    @Override
    public void completeTodo(Todo todo) {
        todos.remove(todo); // remove provoca un evento di aggiornamento
        completedTodos.add(todo);
    }

    @Override
    public List<Todo> getTodos() {
        return todos.get();
    }

    @Override
    public List<Todo> getCompletedTodos() {
        return completedTodos.get();
    }
}
