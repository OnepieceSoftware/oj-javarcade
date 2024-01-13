module software.onepiece.javarcade.character.wedge {
    requires transitive software.onepiece.javarcade.model;

    exports software.onepiece.javarcade.character.wedge;

    provides software.onepiece.javarcade.model.Inhabitant
            with software.onepiece.javarcade.character.wedge.Wedge;
}