package musictheory.chords;

import musictheory.notes.Note;
import musictheory.scales.Scale;
import musictheory.scales.ScaleDegree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ChordProgression {
    private final List<Chord> chordSequence;
    private final String root;
    private static final char DELIMITER = '_';
    public ChordProgression(String root, String progression){
        this.root = root;
        StringBuilder stringProgression = new StringBuilder(progression);
        this.chordSequence = generateChords(root, stringProgression);
    }

    public List<Chord> generateChords(String root, StringBuilder progression){
        List<String> chordDegrees = new ArrayList<>();
        List<Chord> chords = new ArrayList<>();
        for(int i = 0; i < progression.length(); i++){
            StringBuilder currChord = new StringBuilder();
            for(int j = i; j < progression.length(); j++){
                if(progression.charAt(j) == DELIMITER){
                    i = j;
                    break;
                }
                currChord.append(progression.charAt(j));
            }
            chordDegrees.add(String.valueOf(currChord));
        }
        for(String chordDegree : chordDegrees){
            String currentChordName = getChordNameFromRomanNumeral(root, chordDegree);
            String currentChordType = getChordTypeFromRomanNumeral(chordDegree);
            Chord chord = new Chord(currentChordName, currentChordType);
            chords.add(chord);
        }
        for(Chord chord : chords){
            System.out.println(chord.toString());
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


}
