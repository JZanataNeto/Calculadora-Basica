module com.joaozanata.calculadorabasica {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.joaozanata.calculadorabasica to javafx.fxml;
    exports com.joaozanata.calculadorabasica;
}