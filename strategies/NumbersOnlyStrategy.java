package bullscows.strategies;

import bullscows.interfaces.AsciiStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumbersOnlyStrategy implements AsciiStrategy {
    @Override
    public List<Character> generateAsciiValues() {
        return IntStream.rangeClosed(48,57)
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
    }
}
