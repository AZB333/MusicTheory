package musictheory.chords;

public enum ChordType {
    MAJOR(new int[]{4, 3, 5}),
    MINOR(new int[]{3, 4, 5}),
    DIMINISHED(new int[]{3, 3, 6}),// whole-half diminished
    AUGMENTED(new int[]{4, 4, 6}),
    MAJOR_SEVENTH(new int[]{4, 3, 4, 1}),
    MINOR_SEVENTH(new int[]{3, 4, 3, 2}),
    DOMINANT_SEVENTH(new int[]{4, 3, 3, 2}),
    DIMINISHED_SEVENTH(new int[]{3, 3, 3, 3}),
    HALF_DIMINISHED_SEVENTH(new int[]{}),
    MINOR_MAJOR_SEVENTH(new int[]{3, 4, 4, 1}),
    SUS_TWO(new int[]{2, 5, 5}),
    SUS_FOUR(new int[]{5, 1, 5});

    static {
        MAJOR.nextExtension = MAJOR_SEVENTH;
        MINOR.nextExtension= MINOR_SEVENTH;
        DOMINANT_SEVENTH.nextExtension = HALF_DIMINISHED_SEVENTH;
        //all the rest
    }


    private final int[] intervals;
    private ChordType nextExtension;
    ChordType(int[] intervals) {
        this.intervals = intervals;
    }
    public int[] getIntervals() { return intervals; }
    public ChordType getNextExtension() {return nextExtension;}
}