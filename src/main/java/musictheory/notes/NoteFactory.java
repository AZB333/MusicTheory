package musictheory.notes;

import java.util.Objects;

public class NoteFactory {

    public NoteFactory() {};

    public Note createNote(String name, Integer octave){
        if(Objects.equals(name, "C")){
            return new CNote(name, octave);
        }
        return null;
    }
}
