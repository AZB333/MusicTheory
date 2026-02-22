package musictheory.scales;

import musictheory.notes.*;

import java.util.List;

public class MajorScale extends Scale{

    public MajorScale(String root){
        super(root, ScaleType.Major);
    }

    @Override
    public List<Note> buildScale(){
        return List.of(new CNote(), new CNote(), new CNote());
    }
}
