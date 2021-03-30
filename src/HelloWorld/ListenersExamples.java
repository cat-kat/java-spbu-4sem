package HelloWorld;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ListenersExamples extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Домашка про кнопку");
        Parent ui = createInterface();
        primaryStage.setScene(new Scene(ui, 640, 480));
        primaryStage.show();
    }

    private Parent createInterface() {
        Button b = new Button("Кнопка");
        Label label = new Label("Не трогай, пожалуйста, кнопку");
        VBox hb = new VBox();
        hb.getChildren()
                .addAll(label, b);
        b.setStyle("-fx-background-color: red; -fx-max-width:200; -fx-max-height: 80 ");
        label.setTextFill(Color.web("#0076a3"));
        hb.setAlignment(Pos.CENTER);

        // я хотела сделать обработчик именно с помощью addEventHandler, но он упрямо не хотел взаимодействовать с обычной переменной count
        // тогда я приняла предложение идее сделать анонимный объект. Подскажите, пожалуйста, как это можно сделать красивее?
        var counter = new Object() {
            int count = 0;
        };

        b.addEventHandler(ActionEvent.ACTION, actionEvent -> {
            counter.count++;
            String[] phrases = {"Не нажимай больше на эту кнопку", "Я просилa, не нажимай больше на эту кнопку", "Хватит? Пожалуйста?", "Остановись пока не поздно :("};

            if (counter.count == 4) {
                ImageView a = new ImageView(new Image("file:res/cat1.jpg"));
                hb.getChildren().clear();
                hb.getChildren().add(a);
            } else label.setText(phrases[counter.count]);
        });
        return hb;
    }
}
