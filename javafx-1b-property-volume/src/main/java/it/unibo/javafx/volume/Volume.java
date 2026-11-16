package it.unibo.javafx.volume;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Volume {
    private final DoubleProperty volume = new SimpleDoubleProperty(50);

    public DoubleProperty volumeProperty() {
        return this.volume;
    }

    public void reset() {
        this.volume.set(50);
    }
}
