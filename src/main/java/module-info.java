module org.example.reto2diad {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires java.sql;
    requires java.naming;
    requires mysql.connector.j;

    opens org.example.reto2diad.model to org.hibernate.orm.core;
    opens org.example.reto2diad.controller to javafx.fxml;
    opens org.example.reto2diad to javafx.fxml;
    exports org.example.reto2diad;
    exports org.example.reto2diad.dao;
    opens org.example.reto2diad.dao to javafx.fxml;
    exports org.example.reto2diad.model;
    exports org.example.reto2diad.util;
    opens org.example.reto2diad.util to javafx.fxml;

}