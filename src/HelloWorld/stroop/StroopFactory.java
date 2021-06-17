package HelloWorld.stroop;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import java.util.Random;

import static javafx.scene.paint.Color.web;

public class StroopFactory {

    private String[] colors;
    private String[] colorsName;
    private Random rand;

    public StroopFactory(String[] colors, String[] colorsName) {
        this.colors = colors;
        this.colorsName = colorsName;
        this.rand = new Random();
    }

    public Node randElem() {
        int colorInt = rand.nextInt(8);
        int colorNameInt = rand.nextInt(8);
        int typeInt = rand.nextInt(2);

        if (typeInt == 0) {
            Rectangle r = new Rectangle(50, 20);
            r.setFill(web(colors[colorInt]));
            return r;
        } else {
            Label l = new Label(colorsName[colorNameInt]);
            l.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 30));
            l.setTextFill(web(colors[colorInt]));
            return l;
        }
    }
}
