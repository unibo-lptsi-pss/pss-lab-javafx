package it.unibo.javafx.property;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(final Stage primaryStage) {
        final Lamp lamp = new Lamp();
        final Rectangle light = new Rectangle(180, 120);
        light.fillProperty().bind(Bindings.when(lamp.onProperty())
            .then(Color.GOLD).otherwise(Color.DIMGRAY));

        final Label status = new Label();
        status.textProperty().bind(Bindings.when(lamp.onProperty())
            .then("Accesa").otherwise("Spenta"));

        final Button turnOn = new Button("Accendi");
        turnOn.setMinWidth(100);
        turnOn.setOnAction(event -> lamp.turnOn());
        final Button turnOff = new Button("Spegni");
        turnOff.setMinWidth(100);
        turnOff.setOnAction(event -> lamp.turnOff());

        final HBox buttons = new HBox(turnOn, turnOff);
        final VBox mainPane = new VBox(light, status, buttons);
        primaryStage.setTitle("Lampadina osservabile");
        primaryStage.setScene(new Scene(mainPane));
        primaryStage.show();
    }

    public static class Main {
        public static void main(final String... args) {
            Application.launch(App.class, args);
        }
    }
}
