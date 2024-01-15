package software.onepiece.javarcade.logic;

import static software.onepiece.javarcade.model.Spot.MATRIX_HEIGHT;
import static software.onepiece.javarcade.model.Spot.MATRIX_WIDTH;

public interface GameParameters {

   int CELL_WIDTH = 16;
   int CELL_HEIGHT = 16;
   int GAME_WIDTH = MATRIX_WIDTH * CELL_WIDTH;
   int GAME_HEIGHT = MATRIX_HEIGHT * CELL_HEIGHT;

   int SCALE = 4;

   int CELL_WIDTH_IN_PIXEL = SCALE * CELL_WIDTH;
   int CELL_HEIGHT_IN_PIXEL = SCALE * CELL_HEIGHT;
   int WIDTH_IN_PIXEL = SCALE * GAME_WIDTH;
   int HEIGHT_IN_PIXEL = SCALE * GAME_HEIGHT;

}
