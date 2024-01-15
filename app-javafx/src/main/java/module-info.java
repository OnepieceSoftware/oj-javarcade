// @MainClass("software.onepiece.javarcade.javafx.Main")
open module software.onepiece.javarcade.app.javafx {
    requires software.onepiece.javarcade.logic;
    requires software.onepiece.javarcade.model;

    requires javafx.base;
    requires javafx.graphics;
    requires org.slf4j;

    requires /*runtime*/ software.onepiece.javarcade.border.blocks;
    requires /*runtime*/ software.onepiece.javarcade.character.bigs;
    requires /*runtime*/ software.onepiece.javarcade.character.wedge;
    requires /*runtime*/ software.onepiece.javarcade.inhabitant.floor;
    requires /*runtime*/ software.onepiece.javarcade.inhabitant.wall;
    requires /*runtime*/ software.onepiece.javarcade.level.classic;

    requires /*runtime*/ org.slf4j.simple;

    exports software.onepiece.javarcade.javafx to
            javafx.base,
            javafx.graphics,
            javafx.controls,

            software.onepiece.javarcade.app.javafx.test.functional;
}