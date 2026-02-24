package musictheory.scales;

import musictheory.notes.Note;

import java.util.ArrayList;
import java.util.List;

public class Scale {
    private final String root;
    private final ScaleType scaleType;
    private final List<Note> notes;
    public static final int CHROMATIC_SCALE_SIZE = 12;

    public Scale(String root, String scaleType) {
        this.root = root;
        this.scaleType = ScaleType.valueOf(scaleType.toUpperCase());
        this.notes = buildScale();
    }

    private List<Note> buildScale() {
        List<Note> builtScale = new ArrayList<>();
        int currentIndex = ChromaticScale.valueOf(root).ordinal();

        for (int interval : scaleType.getIntervals()) {
            ChromaticScale chromNote = ChromaticScale.values()[currentIndex % CHROMATIC_SCALE_SIZE];
            builtScale.add(new Note(chromNote.name()));
            currentIndex += interval;
        }
        return builtScale;
    }

    public List<Note> getNotes() { return notes; }
    public String getRoot() { return root; }
}