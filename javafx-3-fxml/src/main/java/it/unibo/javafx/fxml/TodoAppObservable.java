package it.unibo.javafx.fxml;

import javafx.beans.property.ListProperty;

public interface TodoAppObservable extends TodoApp {
    ListProperty<Todo> todosProperty();
    ListProperty<Todo> completedTodosProperty();
}
