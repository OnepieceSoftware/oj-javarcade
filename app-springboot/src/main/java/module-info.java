// @MainClass("software.onepiece.javarcade.springboot.Application")
// @AnnotationProcessor("dagger.compiler") // TODO
open module software.onepiece.javarcade.app.springboot {
    requires software.onepiece.javarcade.model;

    requires spring.boot.autoconfigure;
    requires spring.boot;
    requires spring.context;
    requires spring.web;

    requires /*runtime*/ spring.boot.starter.web;
}