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
        final Parent root = new Pane(); // todo, qui va messa la logica per creare il lo schema mostrato in figura
        final Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("App FXML");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void run(final String[] args) {
        launch(args);
    }

}
