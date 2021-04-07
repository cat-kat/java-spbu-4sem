package HelloWorld;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import static javafx.beans.binding.Bindings.min;

public class ColorCircle extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Домашка про кружочек");
        Parent ui = createInterface();
        primaryStage.setScene(new Scene(ui, 640, 240));
        primaryStage.show();
    }

    private Parent createInterface() {
        Circle circle = new Circle();
        ColorPicker choiceCircle = new ColorPicker();
        ColorPicker choiceBack = new ColorPicker();
        Slider sizeCircle = new Slider();
        Pane main = new Pane(circle);

        VBox vb = new VBox(sizeCircle, choiceCircle, choiceBack);
        HBox app = new HBox(vb, main);


        choiceBack.setStyle("-fx-padding: 5; ");
        choiceCircle.setStyle("-fx-padding: 5");
        sizeCircle.setStyle("-fx-padding: 5;");
        main.setStyle("-fx-background-color: #d4dbfa");
        vb.setStyle("-fx-background-color: #edeff5");


        vb.setAlignment(Pos.CENTER);
        app.setHgrow(main, Priority.ALWAYS);
        vb.setPrefWidth(200);
        vb.setMaxHeight(Double.MAX_VALUE);
        main.setMaxHeight(Double.MAX_VALUE);
        main.setMaxWidth(Double.MAX_VALUE);

        circle.radiusProperty().bind(sizeCircle.valueProperty());
        circle.centerYProperty().bind(main.heightProperty().divide(2));
        circle.centerXProperty().bind(main.widthProperty().divide(2));
        circle.fillProperty().bind(choiceCircle.valueProperty());
        circle.fillProperty().bind(choiceCircle.valueProperty());
        sizeCircle.maxProperty().bind(min(main.heightProperty(), main.widthProperty()).divide(2));

        return app;

    }
}
