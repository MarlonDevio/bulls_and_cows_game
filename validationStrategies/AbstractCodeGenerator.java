package bullscows.validationStrategies;

import bullscows.interfaces.AsciiStrategy;


public abstract class AbstractCodeGenerator {

    // hier 1 strategy van maken en deze gewoon toepassen
    protected AsciiStrategy numbersOnlyStrategy;
    protected AsciiStrategy lettersStrategy;

    public AbstractCodeGenerator(AsciiStrategy strategy, AsciiStrategy lettersStrategy) {
       this.numbersOnlyStrategy = strategy;
       this.lettersStrategy = lettersStrategy;
    }

    public AbstractCodeGenerator() {
    }


}
