package it.unibo.javafx.volume;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Volume {
    private final DoubleProperty volume = new SimpleDoubleProperty(50);

    public DoubleProperty volumeProperty() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void reset() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
