package demo;

import com.chamexxxx.Router;
import javafx.fxml.FXML;

public class HomeController {
    @FXML
    protected void onLogoutButtonClick() {
        Router.switchScene("login");
    }
}
