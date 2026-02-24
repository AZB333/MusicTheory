package musictheory.scales;

import org.junit.jupiter.api.Test;

import java.util.Objects;

public class MajorScaleTest {

    @Test
    public void testMajorScaleConstructor(){
        MajorScale majorScale = new MajorScale("C");
        assert(Objects.equals(majorScale.getRoot(), "C"));
    }
}
