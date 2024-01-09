package bullscows.strategies;

import bullscows.interfaces.AsciiStrategy;

import java.util.List;

public abstract class AbstractCodeGenerator {
    protected AsciiRanges range;
    protected AsciiStrategy asciiStrategy;

    public AbstractCodeGenerator(AsciiStrategy asciiStrategy, AsciiRanges range){
        this.range = range;
        this.asciiStrategy = asciiStrategy;
    }

    public List<Character> performStrategy(){
        return asciiStrategy.generateAsciiValues();
    }

}
