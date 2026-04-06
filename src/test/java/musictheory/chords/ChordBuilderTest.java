package musictheory.chords;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;

public class ChordBuilderTest {

    @Test
    public void testChordProgressionConstructor(){
        String root = "C";
        String progression = "I_vi_V_IV_iv";
        ChordBuilder chordBuilder = new ChordBuilder(root, progression);
        System.out.println(chordBuilder);
        List<Chord> chords = chordBuilder.getChords();
        assert(Objects.equals(chords.get(0).getRoot(), "C"));
        assert(Objects.equals(chords.get(chords.size() - 1).getRoot(), "F"));
        assert(Objects.equals(chords.get(chords.size() - 1).getType(), "MINOR"));
    }
}
