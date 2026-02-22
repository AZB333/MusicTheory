package musictheory.notes;

abstract public class Note {
    private final String name;
    private final String audioFilePath;
//    private final Integer octave;
    private final Integer midiValue;

    public Note(String name){
        this.name = name;
//        this.octave = octave;
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
//    public Integer getOctave() {return octave;}
}
