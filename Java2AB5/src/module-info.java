module Java2AB5 {
    exports ch.makery.sortfilter;
    exports de.fhswf.fbin.java2fx.util;
    exports de.fhswf.fbin.java2fx.trees;
    exports de.fhswf.fbin.java2fx.entities;
    exports de.fhswf.fbin.java2fx.tables;
    exports application;

    requires transitive javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    opens ch.makery.sortfilter;
}
