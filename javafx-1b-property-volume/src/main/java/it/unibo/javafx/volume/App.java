package it.unibo.javafx.volume;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(final Stage primaryStage) {
        final Volume volume = new Volume();
        final Slider slider = new Slider(0, 100, 50);
        slider.valueProperty().bindBidirectional(volume.volumeProperty());

        final Label value = new Label();
        value.textProperty().bind(volume.volumeProperty().asString("Volume: %.0f"));

        final Button reset = new Button("Reset");
        reset.setOnAction(event -> volume.reset());

        final VBox mainPane = new VBox(slider, value, reset);
        primaryStage.setTitle("Volume osservabile");
        primaryStage.setScene(new Scene(mainPane));
        primaryStage.show();
    }

    public static class Main {
        public static void main(final String... args) {
            Application.launch(App.class, args);
        }
    }
}
