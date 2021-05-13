package HelloWorld.fractals;

import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class PictureColorRGB implements Picture {

    @Override
    public Color color(int x, int y) {
        return Color.rgb(x, y, 100);
    }

    @Override
    public ImageView image() {
        WritableImage image = new WritableImage(256, 256);
        PixelWriter pw = image.getPixelWriter();
        ImageView iv = new ImageView(image);


        for (int x = 0; x < 256; x++) {
            for (int y = 0; y < 256; y++) {
                pw.setColor(x, y, color(x, y));
            }
        }
        return iv;
    }
}

