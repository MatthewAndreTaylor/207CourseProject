module src.courseproject207 {
    requires javafx.controls;
    requires javafx.fxml;


    opens src.courseproject207 to javafx.fxml;
    exports src.courseproject207;
}