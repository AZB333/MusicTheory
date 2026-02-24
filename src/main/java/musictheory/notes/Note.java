package musictheory.notes;

public class Note {
    private final String name;
    private final String audioFilePath;
    private final Integer midiValue;

    public Note(String name){
        switch(name) {
            case ("C"), ("Db"), ("D"), ("Eb"), ("E"), ("F"), ("Gb"), ("G"), ("Ab"), ("A"), ("Bb"), ("B") -> this.name = name;
            default -> throw new IllegalArgumentException("Not a valid note");
        };
        this.audioFilePath = findAudioFile(name);
        this.midiValue = midiValueOf(name);
    }

    public String findAudioFile(String noteName){
        return "$e${d}";
    }

    public Integer midiValueOf(String name){
        return 12;
    }

    public String getName() {return name;}
}
