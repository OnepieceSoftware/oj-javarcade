// @MainClass("software.onepiece.javarcade.bomb.Main")
// @AnnotationProcessor("dagger.compiler") // TODO
module software.onepiece.javarcade.app {
    requires software.onepiece.javarcade.lib;
    requires software.onepiece.javarcade.model;

    requires com.fasterxml.jackson.jakarta.rs.json;
    requires jakarta.activation;
    requires javafx.base;
    requires javafx.controls;
    requires javafx.graphics;
    requires org.apache.commons.configuration2;
    requires org.slf4j;

    requires /*runtime*/ software.onepiece.javarcade.character.bigs;
    requires /*runtime*/ software.onepiece.javarcade.character.wedge;
    requires /*runtime*/ software.onepiece.javarcade.inhabitant.floor;
    requires /*runtime*/ software.onepiece.javarcade.inhabitant.wall;
    requires /*runtime*/ software.onepiece.javarcade.level.classic;

    requires /*runtime*/ io.netty.transport.epoll.linux.aarch_64;
    requires /*runtime*/ io.netty.transport.epoll.linux.x86_64;
    requires /*runtime*/ org.slf4j.simple;

    uses software.onepiece.javarcade.model.Inhabitant;
    uses software.onepiece.javarcade.model.Level;

    exports software.onepiece.javarcade.bomb to
            javafx.base,
            javafx.graphics,
            javafx.controls,

            software.onepiece.javarcade.app.test.functional;
}