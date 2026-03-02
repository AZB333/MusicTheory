package musictheory.springboot;

import musictheory.chords.Chord;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChordController {

    @GetMapping("/chord")
    public Chord getChord(@RequestParam String root, @RequestParam String chordType) {
        return new Chord(root, chordType);
    }
}