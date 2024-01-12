package bullscows.validationStrategies;

/**
 * The AsciiRanges enum represents the ASCII ranges used for validation
 * purposes.
 * It provides the start and end values for each range.
 */
public enum AsciiRanges {
    ASCII_NUMBERS(48, 57),
    ASCII_LETTERS(97, 122);

    private final int start;
    private final int end;

    /**
     * Constructs an AsciiRanges enum with the specified start and end values.
     *
     * @param start the start value of the ASCII range
     * @param end   the end value of the ASCII range
     */
    AsciiRanges(int start, int end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Returns the end value of the ASCII range.
     *
     * @return the end value of the ASCII range
     */
    public int getEnd() {
        return this.end;
    }

    /**
     * Returns the start value of the ASCII range.
     *
     * @return the start value of the ASCII range
     */
    public int getStart() {
        return this.start;
    }
}
