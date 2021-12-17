module jfx.router {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;

    opens demo to javafx.fxml;

    exports com.chamexxxx;
    exports demo;
}