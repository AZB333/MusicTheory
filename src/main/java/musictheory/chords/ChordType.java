package musictheory.chords;

public enum ChordType {
    MAJOR(new int[]{4, 3, 5}),
    MINOR(new int[]{3, 4, 5}),
    DIMINISHED(new int[]{3, 3, 6}),// whole-half diminished
    AUGMENTED(new int[]{4, 4, 6});

    private final int[] intervals;
    ChordType(int[] intervals) { this.intervals = intervals; }
    public int[] getIntervals() { return intervals; }
}