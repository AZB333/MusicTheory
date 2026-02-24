package musictheory.springboot;

import musictheory.scales.Scale;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScaleController {

    @GetMapping("/scale")
    public Scale getScale(@RequestParam String root, @RequestParam String scaleType) {
        return new Scale(root, scaleType);
    }
}