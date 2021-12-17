package demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DemoApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        var fxmlLoader = new FXMLLoader(DemoApplication.class.getResource("hello-view.fxml"));
        var scene = new Scene(fxmlLoader.load(), 320, 240);

        primaryStage.setTitle("Demo application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
