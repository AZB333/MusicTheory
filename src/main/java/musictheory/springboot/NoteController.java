package musictheory.springboot;

import musictheory.notes.Note;
import musictheory.notes.NoteFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NoteController {

    @GetMapping("/notefetch")
    public String getNote(String name, Integer octave, Model model) {
        NoteFactory noteFactory = new NoteFactory();
        Note cNote = noteFactory.createNote("C", 4);
        model.addAttribute("name", cNote.getName());
        model.addAttribute("octave", cNote.getOctave());
        return "notefetch";
    }

}