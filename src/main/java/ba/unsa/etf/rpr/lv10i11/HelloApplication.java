package ba.unsa.etf.rpr.lv10i11;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Parent root = loader.load();

        HelloController glavnaController = loader.getController();


        FXMLLoader drzavaLoader = new FXMLLoader(getClass().getResource("drzava.fxml"));
        Parent drzavaRoot = drzavaLoader.load();
        DrzavaController drzavaController = drzavaLoader.getController();
        glavnaController.setDrzavaController(drzavaController);


        FXMLLoader gradLoader = new FXMLLoader(getClass().getResource("grad.fxml"));
        Parent gradRoot = gradLoader.load();
        GradController gradController = new GradController();

        glavnaController.setGradController(gradController);

        Scene scene = new Scene(root);

        primaryStage.setTitle("Gradovi svijeta");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}



