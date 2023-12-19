/*package ba.unsa.etf.rpr.lv7i8;

import static org.junit.jupiter.api.Assertions.*;

import com.sun.tools.javac.Main;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
@ExtendWith(ApplicationExtension.class)
class KorisniciControllerTest {

        @Start
        public void start (Stage stage) throws Exception {
            KorisniciModel model=new KorisniciModel();
            model.napuni();
            FXMLLoader fxmlLoader = new FXMLLoader(KorisniciApplication.class.getResource("hello-view.fxml"));
            fxmlLoader.setController(new KorisniciController(model));
            Scene scene = new Scene(fxmlLoader.load(), 450, 280);
            stage.setTitle("Korisnici");
            stage.setScene(scene);
            stage.show();
            stage.toFront();
            Button krajButton=new Button("Kraj");
            krajButton.setOnAction(event->{new KorisniciController().handleKrajButton(null);});
        }
        @Test
        public void testHandleKrajButton(FxRobot robot)
        {

         /*   Button kraj=robot.lookup("#kraj").queryAs();
            robot.clickOn("kraj");
            assertEquals(Platform.exit(),kraj.getOnAction());
            Platform.exit()
        };

    }
            */