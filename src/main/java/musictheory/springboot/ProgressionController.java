package musictheory.springboot;

import musictheory.chords.ChordBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProgressionController {

    @GetMapping("/progression")
    public ChordBuilder getChord(@RequestParam String root, @RequestParam String progressionType) {
        return new ChordBuilder(root, progressionType);
    }
}