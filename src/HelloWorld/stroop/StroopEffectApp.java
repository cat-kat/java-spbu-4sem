package HelloWorld.stroop;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.Random;

import static javafx.scene.paint.Color.*;

public class StroopEffectApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Stroop Effect");
        Parent ui = createInterface();
        primaryStage.setScene(new Scene(ui, 400, 300));
        primaryStage.show();
    }


    private Parent createInterface() {
       /* Label l1 = new Label("Красный");
        Label l2 = new Label("Cиний");
        Label l3 = new Label("Фиолетовый");
        Label l4 = new Label("Жёлтый");
        Rectangle r1 = new Rectangle(50, 20);
        Rectangle r2 = new Rectangle(50, 20);

        r1.setFill(web("#8b07f7"));
        r2.setFill(web("#0512ff"));
        l1.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR , 30));
        l1.setTextFill(web("#00ffee"));
        l2.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR , 30));
        l2.setTextFill(web("#ff00ee"));
        l3.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR , 30));
        l3.setTextFill(web("#ffcc00"));
        l4.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR , 30));
        l4.setTextFill(web("#11ff00")); */

        String[] colors = {"#FE2712", "#FB9902", "#FEFE33", "#66B032", "#347C98", "#0247FE", "#4424D6", "#000000"};
        String[] colorsName = {"Красный", "Оранжевый", "Желтый", "Зелёный", "Голубой", "Синий", "Фиолетовый", "Черный"};
        StroopFactory a = new StroopFactory(colors, colorsName);

        Button b = new Button("Добавить");
        // VBox vb1 = new VBox(20, l1, r1, l2, l3, r2, l4);
        VBox vb1 = new VBox(20);
        //Button b1 = new Button("Добавить");
        //VBox vb1 = new VBox(20, l1, r1, l2, l3, r2, l4, b1);
        for (int i = 0; i < 6; i++) {
            vb1.getChildren().add(a.randElem());
        }
        //vb1.getChildren().add(b1);
        //VBox vb2 = new VBox(b1);

        vb1.setAlignment(Pos.BASELINE_CENTER);
        HBox app = new HBox(vb1, b);

        b.setMinWidth(100);
        HBox.setHgrow(vb1, Priority.ALWAYS);

        //  Random rand = new Random();

        b.setOnAction(actionEvent -> {
            if (vb1.getChildren().size() == 10) {
                vb1.getChildren().remove(0);
            }
            vb1.getChildren().add(a.randElem());

        /*    int colorInt = rand.nextInt(8);
            int colorNameInt = rand.nextInt(8);
            int typeInt = rand.nextInt(2);
            if (vb1.getChildren().size() == 10) {
                vb1.getChildren().remove(0);
            }
            if (typeInt == 0) {
                Rectangle r = new Rectangle(50, 20);
                r.setFill(web(colors[colorInt]));
                vb1.getChildren().addAll(r);
            } else {
                Label l = new Label(colorsName[colorNameInt]);
                l.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 30));
                l.setTextFill(web(colors[colorInt]));
                vb1.getChildren().addAll(l);
            } */
        });
        return app;
    }
}

