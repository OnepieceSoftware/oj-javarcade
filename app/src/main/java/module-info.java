// @MainClass("software.onepiece.javarcade.bomb.Main")
// @AnnotationProcessor("dagger.compiler") // TODO
module org.example.app {
    requires org.example.lib;

    requires com.fasterxml.jackson.jakarta.rs.json;
    requires jakarta.activation;
    // requires javafx.base;
    requires javafx.controls;
    requires javafx.graphics;
    // requires javafx.media;
    requires org.apache.commons.configuration2;
    requires org.slf4j;

    requires /*runtime*/ io.netty.transport.epoll.linux.aarch_64;
    requires /*runtime*/ io.netty.transport.epoll.linux.x86_64;
    requires /*runtime*/ org.slf4j.simple;

    exports software.onepiece.javarcade.bomb to
            javafx.base,
            javafx.graphics,
            javafx.controls,
            javafx.media,

            org.example.app.test.functional;
}