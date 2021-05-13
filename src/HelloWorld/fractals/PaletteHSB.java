package HelloWorld.fractals;

import javafx.scene.paint.Color;

public class PaletteHSB implements Palette {
    @Override
    public Color color(double v) {
        return Color.hsb(360 * v, 1, 1);
    }
}
