package bullscows.strategies;

import bullscows.interfaces.AsciiStrategy;

import java.util.List;
import java.util.stream.IntStream;

public class NumbersAndLettersStrategy implements AsciiStrategy {
    private final AsciiRanges range;

    public NumbersAndLettersStrategy(AsciiRanges range) {
        this.range = range;
    }

    @Override
    public List<Character> generateAsciiValues() {
        return IntStream.rangeClosed(range.getStart, range.getEnd)
                .mapToObj(c -> (char) c)
                .toList();
    }
}
