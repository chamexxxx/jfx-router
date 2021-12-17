package demo;

import com.chamexxxx.Router;
import javafx.application.Application;
import javafx.stage.Stage;

public class DemoApplication extends Application {
    @Override
    public void start(Stage primaryStage) {
        configureStage(primaryStage);

        Router.bind(primaryStage);

        Router.setInitialSceneConfigurator(scene -> {
            scene.getStylesheets().add(getClass().getResource("app.css").toExternalForm());
        });

        Router.addScene("home", getClass().getResource("home-view.fxml"));
        Router.addScene("login", getClass().getResource("login-view.fxml"));

        Router.switchScene("login");

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    private void configureStage(Stage stage) {
        stage.setTitle("Demo application");
    }
}
