package ba.unsa.etf.rpr.lv7i8;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class KorisniciApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        KorisniciModel model=new KorisniciModel();
        model.napuni();
        FXMLLoader fxmlLoader = new FXMLLoader(KorisniciApplication.class.getResource("hello-view.fxml"));
        fxmlLoader.setController(new KorisniciController(model));
        Scene scene = new Scene(fxmlLoader.load(), 450, 280);
        stage.setTitle("Korisnici");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}