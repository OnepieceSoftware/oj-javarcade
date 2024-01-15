// @Publish(false)
module software.onepiece.javarcade.lib {

    requires transitive com.fasterxml.jackson.databind;
    requires transitive com.fasterxml.jackson.jakarta.rs.json;

    requires com.google.common;
    requires jakarta.activation;
    requires java.logging; // JDK module
    requires org.apache.commons.lang3;

    requires /*runtime*/ io.netty.transport.epoll.linux.aarch_64;
    requires /*runtime*/ io.netty.transport.epoll.linux.x86_64;

    exports org.example.lib;
}