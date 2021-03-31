package HelloWorld;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MessengerBox extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Домашка про мессенджер");
        Parent ui = createInterface();
        primaryStage.setScene(new Scene(ui, 640, 240));
        primaryStage.show();
    }

    private Parent createInterface() {
        TextArea message = new TextArea();
        TextField newMessage = new TextField();
        Button b = new Button("Отправить");
        ObservableList<String> listContacts = FXCollections.observableArrayList (
                "Обойщикова", "Алина", "Больница", "SOS");
        ListView<String> contacts = new ListView<String>(listContacts);
        Label l = new Label("Контакты");

        b.setStyle("-fx-background-color: red");

        HBox hb0 = new HBox(newMessage, b);
        VBox vb1 = new VBox(message, hb0);
        VBox vb2 = new VBox(l, contacts);
        HBox app = new HBox(vb1, vb2);

        vb2.setAlignment(Pos.CENTER);

        hb0.setPrefHeight(100);
        l.setPrefHeight(40);
        b.setPrefWidth(100);
        vb2.setPrefWidth(240);

        b.setMaxHeight(Double.MAX_VALUE);
        newMessage.setMaxHeight(Double.MAX_VALUE);
        contacts.setMaxHeight(Double.MAX_VALUE);

        HBox.setHgrow(newMessage, Priority.ALWAYS);
        VBox.setVgrow(message, Priority.ALWAYS);
        HBox.setHgrow(message, Priority.ALWAYS);
        VBox.setVgrow(contacts, Priority.ALWAYS);
        HBox.setHgrow(vb1, Priority.ALWAYS);

        b.addEventHandler(ActionEvent.ACTION, actionEvent -> {
            message.setText(message.getText() + newMessage.getText() + "\n");
            newMessage.clear();
        });

        return app;
    }
}