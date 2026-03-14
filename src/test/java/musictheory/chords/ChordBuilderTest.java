package musictheory.chords;

import org.junit.jupiter.api.Test;

public class ChordBuilderTest {

    @Test
    public void testChordProgressionConstructor(){
        String root = "C";
        String progression = "I_vi_V_IV_iv";
        ChordBuilder chords = new ChordBuilder(root, progression);
        System.out.println(chords);

    }
}
