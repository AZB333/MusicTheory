package musictheory.notes;

import musictheory.scales.ChromaticScale;

import java.util.Objects;

public class NoteFactory {

    public NoteFactory() {};

    public static Note createNote(String name) {
        return switch (name) {
            case ("C") -> new CNote();
            case ("Db") -> new DbNote();
            case ("D") -> new DNote();
            case ("Eb") -> new EbNote();
            case ("E") -> new ENote();
            case ("F") -> new FNote();
            case ("Gb") -> new GbNote();
            case ("G") -> new GNote();
            case ("Ab") -> new AbNote();
            case ("A") -> new ANote();
            case ("Bb") -> new BbNote();
            case ("B") -> new BNote();
            default -> throw new IllegalArgumentException("Not a valid note");
        };
    }
}
