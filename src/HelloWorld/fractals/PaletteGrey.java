package HelloWorld.fractals;

import javafx.scene.paint.Color;

public class PaletteGrey implements Palette {
    @Override
    public Color color(double v) {
        return Color.gray((10 * v) % 1);
    }
}
