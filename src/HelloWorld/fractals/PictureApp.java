package HelloWorld.fractals;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class PictureApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Четыре вида рисунков");
        Parent ui = createInterface();
        primaryStage.setScene(new Scene(ui, 300, 300));
        primaryStage.show();
    }

    private Parent createInterface() {
       // PictureCircle iv = new PictureCircle();
        // PictureBWCircle iv = new PictureBWCircle();
       // PictureColorRGB iv = new PictureColorRGB();
        PictureColorHSB iv = new PictureColorHSB();
        HBox hb = new HBox(iv.image());

        return hb;
    }
}
