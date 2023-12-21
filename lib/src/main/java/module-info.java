module org.example.lib {
    requires transitive com.fasterxml.jackson.databind;
    requires com.google.common;
    requires java.logging; // JDK module
    requires org.apache.commons.lang3;

    exports org.example.lib;
}