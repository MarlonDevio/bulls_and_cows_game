package bullscows;

import java.util.Random;

public class GameCodeGenerator {
    private static Random random = new Random();
    private int codeLength;
    private int symbolLength;
    // range ascii for numbers = 48 t.e.m. 57 (in principe dus 58 om 57 inclusief te hebben)

    // range ascii for a-z = 97 t.e.m. 122 ( principe 123 zie boven )

    public GameCodeGenerator() {
    }





    private int generateRandomNumber(int bound) {
        return random.nextInt(bound);
    }

    public String getAsteriskFromCode() {
        return "*".repeat(Math.max(0, codeLength));
    }

    public void setSymbolLength(int symbolLength) {
        this.symbolLength = symbolLength;
    }

    public void setCodeLength(int codeLength) {
        this.codeLength = codeLength;
    }

}
