package it.unibo.javafx.fxml;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;

import java.util.List;

public class TodoAppImpl implements TodoAppObservable  {
    private final ListProperty<Todo> todos;
    private final ListProperty<Todo> completedTodos;

    private int idCounter = 0;

    public TodoAppImpl() {
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
        var todo = new Todo(idCounter++, content);
        todos.add(todo);
        return todo;
    }

    @Override
    public void completeTodo(Todo todo) {
        todos.remove(todo);
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
