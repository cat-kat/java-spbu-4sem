package HelloWorld.fractals;

import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class PictureCircle implements Picture {

    @Override
    public Color color(int x, int y) {
        double rsq = Math.pow((x - 100), 2) + Math.pow((y - 100), 2);
        if (rsq <= Math.pow(80, 2)) return Color.gray(rsq / Math.pow(80, 2) * 1.0);
        else return Color.gray(1);
    }

    @Override
    public ImageView image() {
        WritableImage image = new WritableImage(200, 200);
        PixelWriter pw = image.getPixelWriter();
        ImageView iv = new ImageView(image);


        for (int x = 0; x < 200; x++) {
            for (int y = 0; y < 200; y++) {
                pw.setColor(x, y, color(x, y));
            }
        }
        return iv;
    }
}
