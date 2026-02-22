package musictheory.notes;

abstract public class Note {
    private final String name;
    private final String audioFilePath;
    private final Integer octave;
    private final Integer midiValue;

    public Note(String name, Integer octave){
        this.name = name;
        this.octave = octave;
        this.audioFilePath = findAudioFile(name, octave);
        this.midiValue = midiValueOf(name, octave);
    }

    public String findAudioFile(String noteName, Integer octave){
        return "$e${d}";
    }

    public Integer midiValueOf(String name, Integer Octave){
        return 12;
    }

    public String getName() {return name;}
    public Integer getOctave() {return octave;}
}
