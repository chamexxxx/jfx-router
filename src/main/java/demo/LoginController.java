package demo;

import com.chamexxxx.Router;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private void onLoginButtonClick() {
        if (!username.getText().isEmpty() && !password.getText().isEmpty()) {
            Router.switchScene("home");
        }
    }
}
