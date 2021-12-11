package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application {

    public static int WIDTH = 640;
    public static int HEIGHT = 480;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");

        //Step 1 - Create a control
        Label helloLabel = new Label("Hello, World");
        Label goodbyeLabel = new Label("Good Bye!");
        Button clickMeButton = new Button("Click me");

        //Step 1.1 - Configure your controls
        Font font = Font.font("Consolas", FontWeight.BOLD,20);
        clickMeButton.setFont(font);

        //Step 1.2 - For button controls (or other event-type controls) - set the event
        clickMeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("ClickMe Button Clicked!");

                helloLabel.setText("Clicked!");
            }
        });

        //Step 2 - Create a container
        //HBox hbox = new HBox(helloLabel, clickMeBUtton);
        //VBox vbox = new VBox(helloLabel,clickMeBUtton);

        GridPane gridPane = new GridPane();

        gridPane.add(helloLabel, 1,0);
        gridPane.add(goodbyeLabel, 1,1);
        gridPane.add(clickMeButton,2,2);

        //Step 3 - add layout container to scence
        Scene scene = new Scene(gridPane, WIDTH, HEIGHT);

        //Step 4- add scence to stage
        primaryStage.setScene(scene);
        //Step 5 -SHow the stage
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
