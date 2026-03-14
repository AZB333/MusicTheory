package musictheory.chords;

import musictheory.notes.Note;
import musictheory.scales.Scale;
import musictheory.scales.ScaleDegree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ChordBuilder {
    private final List<Chord> chordSequence;
    private static final char DELIMITER = '_';
    public ChordBuilder(String root, String progression){
        this.chordSequence = generateChords(root, progression);
    }

    public List<Chord> getChords(){return chordSequence;}

    private List<Chord> generateChords(String root, String progression){
        String[] chordDegrees = progression.split(String.valueOf(DELIMITER));
        List<Chord> chords = new ArrayList<>();
        for(String chordDegree : chordDegrees){
            String currentChordName = getChordNameFromRomanNumeral(root, chordDegree);
            String currentChordType = getChordTypeFromRomanNumeral(chordDegree);
            Chord chord = new Chord(currentChordName, currentChordType);
            chords.add(chord);
        }
        return chords;
    }

    public static String getChordNameFromRomanNumeral(String root, String degree){
        ScaleDegree currentDegree = ScaleDegree.valueOf(degree);
        Scale rootScale = new Scale(root, "major");
        List<Note> scaleNotes = rootScale.getNotes();
        int scaleDegreeValue = currentDegree.getScaleDegree();
        Note targetNote = scaleNotes.get(scaleDegreeValue - 1);
        return targetNote.name();
    }
    public static String getChordTypeFromRomanNumeral(String interval){
        if(Objects.equals(interval, interval.toUpperCase())){ //if given interval is uppercase
            return "major";
        }
        return "minor";
    }

    @Override
    public String toString(){
        for(Chord chord : getChords()){
            System.out.println(chord);
        }
        return "";
    }


}
