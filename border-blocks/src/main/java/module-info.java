module software.onepiece.javarcade.border.blocks {
    requires transitive software.onepiece.javarcade.model;

    exports software.onepiece.javarcade.border.blocks;

    provides software.onepiece.javarcade.model.Inhabitant with
            software.onepiece.javarcade.border.blocks.WallLeft,
            software.onepiece.javarcade.border.blocks.WallRight;
}