package musictheory.scales;

import musictheory.notes.*;

import java.util.ArrayList;
import java.util.List;

public class MajorScale extends Scale{
    public ChromaticScale rootNote;
    public MajorScale(String root){
        super(root, List.of(2,2,1,2,2,2,1));
        this.rootNote = getNoteFromRoot();
    }

    @Override
    public List<Note> buildScale() {
        List<Note> builtScale = new ArrayList<>();

        int currentIndex = getNoteFromRoot().ordinal();

        for (int interval : scaleInterval) {
            ChromaticScale chromNote = ChromaticScale.values()[currentIndex % CHROMATIC_SCALE_SIZE];
            builtScale.add(new Note(chromNote.name()));

            currentIndex += interval;
        }
        return builtScale;
    }
}
