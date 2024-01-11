module software.onepiece.javarcade.inhabitant.floor {
    requires transitive software.onepiece.javarcade.model;

    exports software.onepiece.javarcade.inhabitant.floor;

    provides software.onepiece.javarcade.model.Inhabitant
            with software.onepiece.javarcade.inhabitant.floor.Floor;
}