package HelloWorld.fractals;

import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class PictureColorHSB implements Picture {

    @Override
    public Color color(int x, int y) {
        return Color.hsb(x, y * 1. / 99, 1);
    }

    @Override
    public ImageView image() {

        WritableImage image = new WritableImage(300, 100);
        PixelWriter pw = image.getPixelWriter();
        ImageView iv = new ImageView(image);


        for (int x = 0; x < 300; x++) {
            for (int y = 0; y < 100; y++) {
                pw.setColor(x, y, color(x, y));
            }
        }
        return iv;
    }
}
