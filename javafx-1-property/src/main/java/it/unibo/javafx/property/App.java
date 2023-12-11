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
        final Label label = new Label();
        label.textProperty().bind(counter.counterProperty().asString()); // Connetto la proprietà counterProperty() al testo della label.
        final HBox buttons = new HBox(); // HBox è un contenitore che allinea i figli in orizzontale. Qui contiene due bottoni.
        final Button increment = new Button("+");
        final Button decrement = new Button("-");
        // Imposto la larghezza minima dei bottoni.
        increment.setMinWidth(100);
        decrement.setMinWidth(100);
        // Metto in ascolto gli eventi di click dei bottoni, quando vengono premuti incremento/decremento il contatore.
        increment.setOnAction(e -> counter.increment());
        decrement.setOnAction(e -> counter.decrement());
        // Aggiungo i bottoni al contenitore.
        buttons.getChildren().addAll(increment, decrement);
        // Aggiungo i nodi al contenitore principale.
        mainPane.getChildren().addAll(label, buttons);
        primaryStage.setScene(new Scene(mainPane));
        primaryStage.show();
    }

    public static class Main {
        public static void main(final String... args) {
            Application.launch(App.class, args);
        }
    }
}
