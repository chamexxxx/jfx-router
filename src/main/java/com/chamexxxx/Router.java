package com.chamexxxx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.function.Consumer;

public class Router {
    private static Object ref;
    private static Stage stage = null;
    private static StageOptions defaultStageOptions;
    private static Scene initialScene = null;
    private static Consumer<Scene> initialSceneCallback;
    private final static HashMap<String, Route> routes = new HashMap<>();

    public static void setInitialSceneConfigurator(Consumer<Scene> initialSceneCallback) {
        Router.initialSceneCallback = initialSceneCallback;
    }

    public static void bind(Object ref, Stage primaryStage) {
        Router.stage = primaryStage;
        Router.defaultStageOptions = new StageOptions(stage.getWidth(), stage.getHeight(), stage.isMaximized());
        Router.ref = ref;
    }

    public static void addScene(String sceneName, String resourceName) {
        addScene(sceneName, resourceName, null);
    }

    public static void addScene(String sceneName, String resourceName, StageOptions stageOptions) {
        routes.put(sceneName, new Route(resourceName, stageOptions));
    }

    public static void switchScene(String sceneName) {
        try {
            var route = routes.get(sceneName);
            var root = loadScene(route.resourceName);

            if (initialScene == null) {
                initialScene = new Scene(root);

                if (initialSceneCallback != null) {
                    initialSceneCallback.accept(initialScene);
                }

                stage.setScene(initialScene);
            } else {
                initialScene.setRoot(root);
            }

            if (route.stageOptions != null) {
                stage.setWidth(route.stageOptions.getWidth());
                stage.setHeight(route.stageOptions.getHeight());
                stage.setMaximized(route.stageOptions.isMaximized());
            } else {
                stage.setWidth(defaultStageOptions.getWidth());
                stage.setHeight(defaultStageOptions.getHeight());
                stage.setMaximized(defaultStageOptions.isMaximized());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Parent loadScene(String resourceName) throws IOException {
        var scenePath = ref.getClass().getResource(resourceName);
        var fxmlLoader = new FXMLLoader(scenePath);

        return fxmlLoader.load();
    }
}
