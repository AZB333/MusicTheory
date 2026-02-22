package musictheory.scales;

import musictheory.notes.Note;

import java.util.List;
import java.util.Objects;

public class ScaleFactory {

    public ScaleFactory(){}

    public Scale createScale(String root, String scaleType){
        if(Objects.equals(scaleType, "Major")){
            return new MajorScale(root);
        }
        return new MajorScale(root);
    }
}
