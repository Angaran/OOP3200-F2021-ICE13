package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class Main extends Application {

    public static int WIDTH = 640;
    public static int HEIGHT = 480;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Hello World");

        //Step 1 - Create a control
        Label imageLabel = new Label("PS5");
        Label goodbyeLabel = new Label("Good Bye!");

        Label anotherLabel = new Label("Another Label");
        Label yetAnotherLabel = new Label("Yet Another Label");

        Button clickMeButton = new Button("Click me");
        clickMeButton.setStyle("-fx-font-family: Arial");

        FileInputStream imagePath = new FileInputStream("src/sample/PS5-Logo.jpg");
        //Step 1 for images - is load the image
        Image ps5 = new Image(imagePath);
        //Step 2 for images - is setup imageview to contain it
        ImageView consoleImageView = new ImageView(ps5);
        consoleImageView.setFitWidth(400);
        consoleImageView.setPreserveRatio(true);

        FileInputStream xboxPath = new FileInputStream("src/sample/xbox.png");
        Image xbox = new Image(xboxPath);
        ImageView xboxImageview = new ImageView(xbox);
        //Step 1.1 - Configure your controls
        //Font font = Font.font("Consolas", FontWeight.BOLD,20);
        //clickMeButton.setFont(font);

        class ButtonClickHandler implements EventHandler<ActionEvent>
        {
            @Override
            public void handle(ActionEvent event)
            {
                imageLabel.setText("Xbox");
                consoleImageView.setImage(xbox);
            }
        }

        clickMeButton.setOnAction( new ButtonClickHandler());
        //Step 1.2 - For button controls (or other event-type controls) - set the event

//        clickMeButton.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                imageLabel.setText("Xbox Series X");
//                consoleImageView.setImage(xbox);
//            }
//        });

        //Step 2 - Create a container
        HBox hbox = new HBox(10, imageLabel);
        hbox.setStyle("-fx-alignment: center;");

        HBox hbox2 = new HBox(10, consoleImageView);


        GridPane gridPane = new GridPane();
        gridPane.setMinSize(6,8);
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(10));

        gridPane.add(hbox, 0,0);
        gridPane.add(hbox2, 0,1);
        gridPane.add(consoleImageView, 0,2);
        gridPane.add(clickMeButton,2,2);



        gridPane.setStyle("-fx-border-color: black; -fx-font-size: 20; -fx-font-family: Consolas;");

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
