package forSIBSUTI;

import java.awt.*;
import java.io.IOException;
import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller
{

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField simpleG_text;
    @FXML
    private TextField alicePrivateKey_text;
    @FXML
    private TextField simpleP_text;
    @FXML
    private TextField bobPrivateKey_text;
    @FXML
    private Button generate_button;
    @FXML
    private TextField aliceGenPrivateKey_text;
    @FXML
    private TextField bobGenPrivateKey_text;
    @FXML
    private TextField aliceGenSecretKey_text;
    @FXML
    private TextField bobGenSecretKey_text;
    @FXML
    private Button simple_num_button;


    int simpleP;
    int simpleG;
    int alicePrivateKey;
    int bobPrivateKey;
    int aliceGenKey;
    int bobGenKey;
    int aliceGenSecretKey;
    int bobGenSecretKey;

    @FXML
    void initialize()
    {
        generate_button.setOnMouseClicked(mouseEvent ->
        {
            simpleP = Integer.parseInt(simpleP_text.getText());
            alicePrivateKey = Integer.parseInt(alicePrivateKey_text.getText());
            simpleG = Integer.parseInt(simpleG_text.getText());
            bobPrivateKey = Integer.parseInt(bobPrivateKey_text.getText());

            aliceGenKey = powerFunc(simpleG, alicePrivateKey, simpleP);
            bobGenKey = powerFunc(simpleG, bobPrivateKey, simpleP);
            aliceGenSecretKey = powerFunc(bobGenKey, alicePrivateKey, simpleP);
            bobGenSecretKey = powerFunc(aliceGenKey, bobPrivateKey, simpleP);

            aliceGenPrivateKey_text.setText(String.valueOf(aliceGenKey));
            bobGenPrivateKey_text.setText(String.valueOf(bobGenKey));
            aliceGenSecretKey_text.setText(String.valueOf(aliceGenSecretKey));
            bobGenSecretKey_text.setText(String.valueOf(bobGenSecretKey));
        });

        simple_num_button.setOnMouseClicked(mouseEvent ->
        {
            /*Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Простые числа");
            alert.setHeaderText(null);
            alert.setContentText("2 \t3 \t5 \t7 \t11 \t13 \t17 \t19 \t23 \t29 \t31 \t37 \t41 \t43 \t47 \t53 \t59 \t61 \t67 \t71" +
                    "\t73 \t79 \t83 \t89 \t97 \t101 \t103 \t107 \t109 \t113");
            alert.show();*/
            try
            {
                Desktop.getDesktop().browse(new URI("https://ru.wikipedia.org/wiki/%D0%9F%D1%80%D0%BE%D1%82%D0%BE%D0%BA%D0%BE%D0%BB_%D0%94%D0%B8%D1%84%D1%84%D0%B8_%E2%80%94_%D0%A5%D0%B5%D0%BB%D0%BB%D0%BC%D0%B0%D0%BD%D0%B0"));
            } catch (IOException | URISyntaxException e) { e.printStackTrace(); }
        });
    }

    public static int powerFunc(int num_a, int num_b, int num_p)
    {
        BigInteger a = new BigInteger(String.valueOf(BigInteger.valueOf(num_a)));
        BigInteger p = new BigInteger(String.valueOf(BigInteger.valueOf(num_p)));
        return Integer.parseInt(String.valueOf(a.pow(num_b).mod(p)));
    }

}
