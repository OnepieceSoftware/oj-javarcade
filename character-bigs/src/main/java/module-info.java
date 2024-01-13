module software.onepiece.javarcade.character.bigs {
    requires transitive software.onepiece.javarcade.model;

    exports software.onepiece.javarcade.character.bigs;

    provides software.onepiece.javarcade.model.Inhabitant
            with software.onepiece.javarcade.character.bigs.Bigs;
}