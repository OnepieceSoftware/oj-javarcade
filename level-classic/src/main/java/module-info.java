module software.onepiece.javarcade.level.classic {
    requires transitive software.onepiece.javarcade.model;

    exports software.onepiece.javarcade.level.classic;

    provides software.onepiece.javarcade.model.Level
            with software.onepiece.javarcade.level.classic.ClassicLevel;
}