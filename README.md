# jfx-router

Simple JavaFX router to switch between scenes for Java 11+

## How to install to your project

### Gradle

```groovy
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.chamexxxx:jfx-router:1.0'
}
```


### Maven

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependency>
    <groupId>com.github.chamexxxx</groupId>
    <artifactId>jfx-router</artifactId>
    <version>-SNAPSHOT</version>
</dependency>
```

## Usage

### Bind router

```java
Router.bind(primaryStage);
```

### Define routes

```java
Router.addScene("home", getClass().getResource("home-view.fxml"));
Router.addScene("login", getClass().getResource("login-view.fxml"));
Router.addScene("register", getClass().getResource("register-view.fxml"));
```

### Switch view

```java
Router.switchScene("login");
```

## Example

```java
import com.chamexxxx.Router;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        configureStage(primaryStage);

        Router.bind(primaryStage);

        Router.setInitialSceneConfigurator(scene -> {
            scene.getStylesheets().add(getClass().getResource("app.css").toExternalForm());
        });

        Router.addScene("home", getClass().getResource("home-view.fxml"));
        Router.addScene("login", getClass().getResource("login-view.fxml"));
        Router.addScene("register", getClass().getResource("register-view.fxml"));
        
        Router.switchScene("login");

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    private void configureStage(Stage stage) {
        stage.setTitle("App title");
    }
}
```