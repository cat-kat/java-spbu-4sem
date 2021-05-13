package HelloWorld.fractals;

import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public interface Picture {
    ImageView image();

    Color color(int x, int y);
}
