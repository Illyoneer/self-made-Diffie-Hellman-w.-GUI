package forSIBSUTI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.InputStream;

public class Main extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        /*InputStream iconStream = getClass().getResourceAsStream("\\icon.png.png");
        Image image = new Image(iconStream);*/
        //Иконка была взята из открытого источника
        Parent root = FXMLLoader.load(getClass().getResource("mainWindowLast.fxml"));
        primaryStage.setTitle("Diffie–Hellman by Illyoneer");
        primaryStage.setScene(new Scene(root, 630, 600));
        primaryStage.setMaximized(false);
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        /*primaryStage.getIcons().add(image);*/
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

