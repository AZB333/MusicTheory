package musictheory.scales;

import musictheory.notes.Note;

import java.util.List;

abstract public class Scale {
    private final String root;
    private final ScaleType scaleType;
    private final List<Note> notes;

    public Scale(String root, ScaleType scaleType){
        this.root = root;
        this.scaleType = scaleType;
        this.notes = buildScale();
    }

    public abstract List<Note> buildScale();
    public List<Note> getNotes() {return notes;}
    //something somewhere needs to build the scale
    //with root string make a note, with scale string make the scale
    /*
        Questions:
        how to build a scale off intervals
        what stores the intervals
        ScaleFactory scaleFactory = new ScaleFactory();
        builtScale = scaleFactory.createScale(root, scaleType); //returns a list of notes
        return builtScale.toString();
     */
}
