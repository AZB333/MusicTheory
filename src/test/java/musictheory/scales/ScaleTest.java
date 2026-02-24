package musictheory.scales;

import musictheory.notes.Note;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;

public class ScaleTest {

    @Test
    public void testMajorScaleConstructor(){
        MajorScale majorScale = new MajorScale("C");
        List<Note> notes = majorScale.getNotes();
        System.out.println(notes);
        for(Note note : notes){
            System.out.println(note.getName() + "\n");
        }
        assert(Objects.equals(majorScale.getRoot(), "C"));
    }
}
