package musictheory.notes;

import org.junit.jupiter.api.Test;

import java.util.Objects;

public class NoteTest {

    @Test
    public void testNoteConstructor(){
        NoteFactory noteFactory = new NoteFactory();
        Note cNote = noteFactory.createNote("C");
        assert(Objects.equals(cNote.getName(), "C"));
//        assert(cNote.getOctave() == 4);
    }
}
