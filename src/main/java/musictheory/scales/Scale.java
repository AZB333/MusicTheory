package musictheory.scales;

import musictheory.notes.Note;

import java.util.List;

abstract public class Scale {
    private final String root;
    private final List<Note> notes;
    public static final Integer CHROMATIC_SCALE_SIZE = 12;
    public List<Integer> scaleInterval;

    public Scale(String root, List<Integer> scaleInterval){
        this.root = root;
        this.scaleInterval = scaleInterval;
        this.notes = buildScale();
    }

    public abstract List<Note> buildScale();
    public List<Note> getNotes() {return notes;}
    public String getRoot() {return root;}
    protected ChromaticScale getNoteFromRoot(){
        return switch (root) {
            case ("C") -> ChromaticScale.C;
            case ("Db") -> ChromaticScale.Db;
            case ("D") -> ChromaticScale.D;
            case ("Eb") -> ChromaticScale.Eb;
            case ("E") -> ChromaticScale.E;
            case ("F") -> ChromaticScale.F;
            case ("Gb") -> ChromaticScale.Gb;
            case ("G") -> ChromaticScale.G;
            case ("Ab") -> ChromaticScale.Ab;
            case ("A") -> ChromaticScale.A;
            case ("Bb") -> ChromaticScale.Bb;
            case ("B") -> ChromaticScale.B;
            default -> throw new IllegalArgumentException("Not a valid note");
        };
    }
    /*
        Questions:
        how to build a scale off intervals
        what stores the intervals
        ScaleFactory scaleFactory = new ScaleFactory();
        builtScale = scaleFactory.createScale(root, scaleType); //returns a list of notes
        return builtScale.toString();
     */
}
