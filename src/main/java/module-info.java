module src.courseproject207 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.testng;


    opens src.courseproject207 to javafx.fxml;
    exports src.courseproject207;
    exports src.courseproject207.helpers;
    exports src.courseproject207.components;
    exports src.courseproject207.tree;
}