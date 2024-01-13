module software.onepiece.javarcade.inhabitant.wall {
    requires transitive software.onepiece.javarcade.model;

    exports software.onepiece.javarcade.inhabitant.wall;

    provides software.onepiece.javarcade.model.Inhabitant
            with software.onepiece.javarcade.inhabitant.wall.Wall;
}