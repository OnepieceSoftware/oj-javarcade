package software.onepiece.javarcade.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static software.onepiece.javarcade.model.Spot.MATRIX_HEIGHT;
import static software.onepiece.javarcade.model.Spot.MATRIX_WIDTH;

public abstract class Level {

    protected abstract String define();

    public Stream<Spot> render() {
        List<Integer> symbols = Arrays.stream(define().split("\n")).flatMap(line -> line.chars().boxed()).toList();

        return IntStream.range(0, MATRIX_WIDTH * MATRIX_HEIGHT).mapToObj(p -> new Spot(
                p < symbols.size() ? (char) symbols.get(p).intValue() : ']', p)
        );
    }
}
