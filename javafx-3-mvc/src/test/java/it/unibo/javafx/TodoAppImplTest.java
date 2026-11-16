package it.unibo.javafx;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test di unità per verificare il comportamento del modello {@link TodoAppImpl}.
 * Ogni test segue la struttura Arrange / Act / Assert.
 */
class TodoAppImplTest {

    @Test
    void initialModelHasEmptyLists() {
        final TodoApp app = new TodoAppImpl();
        final List<Todo> todos = app.getTodos();
        final List<Todo> completed = app.getCompletedTodos();
        assertTrue(todos.isEmpty());
        assertTrue(completed.isEmpty());
    }

    @Test
    void addNewTodoInsertsTaskInTodosList() {
        final TodoApp app = new TodoAppImpl();
        final Todo added = app.addNewTodo("Studiare JavaFX");
        assertEquals(new Todo("Studiare JavaFX"), added);
        assertEquals(List.of(added), app.getTodos());
        assertTrue(app.getCompletedTodos().isEmpty());
    }

    @Test
    void addMultipleTodosPreservesOrder() {
        final TodoApp app = new TodoAppImpl();
        final Todo first = app.addNewTodo("Task 1");
        final Todo second = app.addNewTodo("Task 2");
        assertEquals(List.of(first, second), app.getTodos());
        assertTrue(app.getCompletedTodos().isEmpty());
    }

    @Test
    void completeTodoMovesTaskFromTodosToCompleted() {
        final TodoApp app = new TodoAppImpl();
        final Todo first = app.addNewTodo("Task 1");
        final Todo second = app.addNewTodo("Task 2");
        app.completeTodo(first);
        assertEquals(List.of(second), app.getTodos());
        assertEquals(List.of(first), app.getCompletedTodos());
    }

    @Test
    void completeTodoIgnoresTaskNotInTodos() {
        final TodoApp app = new TodoAppImpl();
        final Todo existing = app.addNewTodo("Task 1");
        final Todo unknown = new Todo("Task mai aggiunto");
        app.completeTodo(unknown);
        assertEquals(List.of(existing), app.getTodos());
        assertTrue(app.getCompletedTodos().isEmpty());
    }

    @Test
    void completingSameTodoTwiceDoesNotAddDuplicates() {
        final TodoApp app = new TodoAppImpl();
        final Todo task = app.addNewTodo("Task 1");
        app.completeTodo(task);
        app.completeTodo(task);
        assertTrue(app.getTodos().isEmpty());
        assertEquals(List.of(task), app.getCompletedTodos());
    }

    @Test
    void observableListsNotifyListenersOnChanges() {
        final TodoAppObservable app = new TodoAppImpl();
        final List<List<Todo>> todoSnapshots = new ArrayList<>();
        final List<List<Todo>> completedSnapshots = new ArrayList<>();
        app.todosProperty().addListener((obs, oldValue, newValue) ->
            todoSnapshots.add(List.copyOf(newValue))
        );
        app.completedTodosProperty().addListener((obs, oldValue, newValue) ->
            completedSnapshots.add(List.copyOf(newValue))
        );
        final Todo task = app.addNewTodo("Task osservabile");
        app.completeTodo(task);
        assertEquals(List.of(List.of(task), List.of()), todoSnapshots);
        assertEquals(List.of(List.of(task)), completedSnapshots);
    }
}
