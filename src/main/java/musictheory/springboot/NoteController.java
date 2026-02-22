package musictheory.springboot;

import musictheory.notes.Note;
import musictheory.notes.NoteFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoteController {

    @GetMapping("/note")
    public Note getNote(@RequestParam String name, @RequestParam Integer octave) {
        NoteFactory noteFactory = new NoteFactory();
        return noteFactory.createNote(name);
    }
}