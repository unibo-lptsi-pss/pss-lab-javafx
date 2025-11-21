package it.unibo.javafx;

public class Todo {
    private final String content;

    public Todo(final String content) {
        this.content = content;
    }


    public String getContent() {
        return this.content;
    }

    @Override
    public int hashCode() {
        return content.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Todo todo = (Todo) o;

        return content.equals(todo.content);
    }

}
