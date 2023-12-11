package it.unibo.javafx.fxml;

import java.util.List;

public interface TodoApp {
    Todo addNewTodo(String content);

    void completeTodo(Todo todo);

    List<Todo> getTodos();

    List<Todo> getCompletedTodos();
}
