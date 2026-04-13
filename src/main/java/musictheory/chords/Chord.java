package musictheory.chords;

import musictheory.notes.Note;
import musictheory.scales.ChromaticScale;
import musictheory.scales.ScaleDegree;

import java.util.ArrayList;
import java.util.List;

public class Chord {
    private final String root;
    private final ChordType chordType;
    private final List<Note> notes;
    public static final int CHROMATIC_CHORD_SIZE = 12;

    public Chord(String root, String chordType) {
        this.root = root;
        this.chordType = ChordType.valueOf(chordType.toUpperCase());
        this.notes = buildChord();
    }

    public String getDisplayName() {
        return root.toUpperCase() + chordType;
    }

    public List<Note> getNotes(){ return notes;}

    @Override
    public String toString(){
        return root.toUpperCase() + " " + this.chordType;
    }

    private List<Note> buildChord() {
        List<Note> builtChord = new ArrayList<>();
        int currentIndex = ChromaticScale.valueOf(root).ordinal();
        for (int interval : chordType.getIntervals()) {
            ChromaticScale chromNote = ChromaticScale.values()[currentIndex % CHROMATIC_CHORD_SIZE];
            builtChord.add(new Note(chromNote.name()));
            currentIndex += interval;
        }
        return builtChord;
    }
    public String getRoot() { return root; }
    public String getType() {return chordType.name();}
    public ChordType getChordType() {return chordType;}
    public Chord bedazzle() {
        ChordType next = chordType.getNextExtension();
        if (next == null) return this; // already at max extension
        return new Chord(this.getRoot(), next.name());
    }
}