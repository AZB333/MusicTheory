package musictheory.notes;

import java.util.Objects;

public class NoteFactory {

    public NoteFactory() {};

    public static Note createNote(String name){
        if(Objects.equals(name, "C")){
            return new CNote();
        }
        return new CNote();
    }
}
