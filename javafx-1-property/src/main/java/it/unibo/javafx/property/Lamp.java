package it.unibo.javafx.property;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class Lamp {
    private final BooleanProperty on = new SimpleBooleanProperty(false);

    public void turnOn() {
        // TODO impostare lo stato della lampadina su acceso.
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void turnOff() {
        // TODO impostare lo stato della lampadina su spento.
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public BooleanProperty onProperty() {
        // TODO restituire la proprietà osservabile del modello.
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
