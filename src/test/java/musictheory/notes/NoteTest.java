package musictheory.notes;

import org.junit.jupiter.api.Test;

import java.util.Objects;

public class NoteTest {

    @Test
    public void testNoteConstructor(){
        Note cNote = new Note("C");
        assert(Objects.equals(cNote.name(), "C"));

    }
}
