package bullscows.strategies;

import bullscows.interfaces.AsciiStrategy;


public abstract class AbstractCodeGenerator {

    protected AsciiStrategy numbersOnlyStrategy;
    protected AsciiStrategy lettersStrategy;

    public AbstractCodeGenerator(AsciiStrategy strategy, AsciiStrategy lettersStrategy) {
       this.numbersOnlyStrategy = strategy;
       this.lettersStrategy = lettersStrategy;
    }

    public AbstractCodeGenerator() {
    }


}
