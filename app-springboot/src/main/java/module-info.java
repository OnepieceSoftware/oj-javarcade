// @MainClass("software.onepiece.javarcade.springboot.Application")
// @AnnotationProcessor("dagger.compiler") // TODO
open module software.onepiece.javarcade.app.springboot {
    requires software.onepiece.javarcade.model;

    requires spring.boot.autoconfigure;
    requires spring.boot;
    requires spring.context;
    requires spring.messaging;
    requires spring.web;
    requires spring.websocket;

    requires /*runtime*/ software.onepiece.javarcade.border.blocks;
    requires /*runtime*/ software.onepiece.javarcade.character.bigs;
    requires /*runtime*/ software.onepiece.javarcade.character.wedge;
    requires /*runtime*/ software.onepiece.javarcade.inhabitant.floor;
    requires /*runtime*/ software.onepiece.javarcade.inhabitant.wall;
    requires /*runtime*/ software.onepiece.javarcade.level.classic;

    requires /*runtime*/ spring.boot.starter.web;
}