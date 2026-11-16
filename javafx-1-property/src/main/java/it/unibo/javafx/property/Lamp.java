package it.unibo.javafx.property;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class Lamp {
    private final BooleanProperty on = new SimpleBooleanProperty(false);

    public void turnOn() {
        this.on.set(true);
    }

    public void turnOff() {
        this.on.set(false);
    }

    public BooleanProperty onProperty() {
        return this.on;
    }
}
