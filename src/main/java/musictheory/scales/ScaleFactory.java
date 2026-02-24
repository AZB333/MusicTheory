package musictheory.scales;

import musictheory.notes.Note;

import java.util.List;
import java.util.Objects;

public class ScaleFactory {

    public ScaleFactory(){}

    public static Scale createScale(String root, String scaleType){
        scaleType = scaleType.toLowerCase();
        if(Objects.equals(scaleType, "major")){
            return new MajorScale(root);
        }
        throw new IllegalArgumentException("Not a valid scale");
    }
}
