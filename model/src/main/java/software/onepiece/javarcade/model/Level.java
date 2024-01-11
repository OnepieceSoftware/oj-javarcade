package software.onepiece.javarcade.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class Level {

    protected abstract String define();

    public List<Spot> render() {
        List<Integer> symbols = Arrays.stream(define().split("\n")).flatMap(line -> line.chars().boxed()).toList();

        return IntStream.range(0, Spot.MATRIX_WIDTH * Spot.MATRIX_HEIGHT).mapToObj(p -> new Spot(
                p < symbols.size() ? (char) symbols.get(p).intValue() : ' ', p)
        ).collect(Collectors.toList());
    }

}
