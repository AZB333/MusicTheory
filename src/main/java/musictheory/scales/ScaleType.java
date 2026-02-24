package musictheory.scales;

public enum ScaleType {
    MAJOR(new int[]{2,2,1,2,2,2,1}),
    NATURAL_MINOR(new int[]{2,1,2,2,1,2,2}),
    HARMONIC_MINOR(new int[]{2,1,2,2,1,3,1}),
    DIMINISHED(new int[]{2,1,2,1,2,1,2,1}),// whole-half diminished
    AUGMENTED(new int[]{3,1,3,1,3,1}),
    HALF_WHOLE(new int[]{1,2,1,2,1,2,1,2}),
    MAJOR_PENTATONIC(new int[]{2,2,3,2,3}),
    MINOR_PENTATONIC(new int[]{3,2,2,3,2}),
    CHROMATIC(new int[]{1,1,1,1,1,1,1,1,1,1,1,1}),
    MAJOR_BLUES(new int[]{2,1,1,3,2,3}),
    MINOR_BLUES(new int[]{3,2,1,1,3,2}),
    IONIAN(new int[]{2,2,1,2,2,2,1}),
    DORIAN(new int[]{2,1,2,2,2,1,2}),
    PHRYGIAN(new int[]{1,2,2,2,1,2,2}),
    LYDIAN(new int[]{2,2,2,1,2,2,1}),
    MIXOLYDIAN(new int[]{2,2,1,2,2,1,2}),
    AEOLIAN(new int[]{2,1,2,2,1,2,2}),
    LOCRIAN(new int[]{1,2,2,1,2,2,2});

    private final int[] intervals;
    ScaleType(int[] intervals) { this.intervals = intervals; }
    public int[] getIntervals() { return intervals; }
}