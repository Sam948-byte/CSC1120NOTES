package WeekTwo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Teenager extends Application implements EventHandler<ActionEvent> {
    private Label response;
    public static final int height = 300;
    public static final int width = 500;

    @Override
    public void start(Stage stage) throws Exception {
    response = new Label();
        TextField input = new TextField();
        Button clear = new Button("Clear");
        Pane pane = new FlowPane();
        pane.getChildren().addAll(new Label("Please enter your age: "), input, clear, response);
        input.setOnAction(this);
        clear.setOnAction(this::clearPressed);
        stage.setScene(new Scene(pane, width, height));
        stage.setTitle("Test");
        stage.show();
    }

    private void clearPressed(ActionEvent event) {
        response.setText("");
    }

    @Override
    public void handle(ActionEvent event) {
        String text = ((TextField) event.getSource()).getText();
        int age = Integer.parseInt(text);
        if (age < 13 || age > 19) {
            response.setText("You are not a teenager");
        } else {
            response.setText("You are a teenager");
        }
    }

}