package musictheory.springboot;

import musictheory.scales.Scale;
import musictheory.scales.ScaleFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScaleController {

    @GetMapping("/scale")
    public Scale getScale(@RequestParam String root, @RequestParam String scaleType) {
        return ScaleFactory.createScale(root, scaleType);
    }
}