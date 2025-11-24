package it.unibo.javafx.property;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(final Stage primaryStage) throws Exception {
        primaryStage.setTitle("Controls Exercise!");
        final VBox mainPane = new VBox();
        final Counter counter = new Counter();
        
        final Label lblCounter = new Label();
        lblCounter.textProperty().bind(counter.counterProperty().asString());

        final Button btnIncrement = new Button("+");
        btnIncrement.setMinWidth(100);
        btnIncrement.setOnAction(e -> counter.increment());

        final Button btnDecrement = new Button("-");
        btnDecrement.setMinWidth(100);
        btnDecrement.setOnAction(e -> counter.decrement());

        final HBox buttons = new HBox(btnIncrement, btnDecrement);
        mainPane.getChildren().addAll(lblCounter, buttons);
        
        primaryStage.setScene(new Scene(mainPane));
        primaryStage.show();
    }

    public static class Main {
        public static void main(final String... args) {
            Application.launch(App.class, args);
        }
    }
}
