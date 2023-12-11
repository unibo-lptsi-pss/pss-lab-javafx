package it.unibo.javafx.fxml;

public class Todo {
    private final int id;
    private final String content;

    public Todo(final int id, final String content) {
        this.id = id;
        this.content = content;
    }

    public int getId() {
        return this.id;
    }

    public String getContent() {
        return this.content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Todo todo = (Todo) o;

        if (id != todo.id) return false;
        return content.equals(todo.content);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + content.hashCode();
        return result;
    }
}
