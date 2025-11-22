package it.unibo.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public final void start(final Stage primaryStage) throws Exception {
        final Parent root = new Pane(); // todo, qui va messo il pannello (o varie classi per fare il pannello) fatte nell'esercizio precedente
        final Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("App With Logic");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static class Launcher {
        void main(String[] args) {
            Application.launch(App.class, args);
        }
    }
}
