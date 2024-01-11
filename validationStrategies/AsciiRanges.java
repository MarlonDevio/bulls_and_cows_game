package bullscows.validationStrategies;


public enum AsciiRanges {
    ASCII_NUMBERS(48, 57),
    ASCII_LETTERS(97, 122);

    private final int start;
    private final int end;


    AsciiRanges(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getEnd() {
        return this.end;
    }

    public int getStart() {
        return this.start;
    }

}
