package bullscows.refactored.codegeneration.codegenerationstrategies;

import java.util.List;

public interface CodeGenerationStrategy <R> {
   R generate(int symbolLength, int codeLength);
}
