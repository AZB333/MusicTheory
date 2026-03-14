package musictheory.scales;

import musictheory.notes.Note;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;

public class ScaleTest {

    @Test
    public void testMajorScaleConstructor(){
        Scale majorScale = new Scale("C", "Major");
        List<Note> notes = majorScale.getNotes();
        System.out.println(notes);
        for(Note note : notes){
            System.out.println(note.name() + "\n");
        }
        assert(Objects.equals(majorScale.getRoot(), "C"));
    }

    @Test
    public void testNaturalMinorScaleConstructor(){
        Scale majorScale = new Scale("C", "natural_minor");
        List<Note> notes = majorScale.getNotes();
        System.out.println(notes);
        for(Note note : notes){
            System.out.println(note.name() + "\n");
        }
        assert(Objects.equals(majorScale.getRoot(), "C"));
    }
}
