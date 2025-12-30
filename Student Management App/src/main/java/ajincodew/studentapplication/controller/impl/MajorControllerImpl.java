package ajincodew.studentapplication.controller.impl;

import ajincodew.studentapplication.controller.MajorController;
import ajincodew.studentapplication.dto.PostMajorResource;
import ajincodew.studentapplication.service.MajorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/majors")
@AllArgsConstructor
public class MajorControllerImpl implements MajorController {
    private MajorService majorService;

    @Override
    public void saveMajor(@Valid @RequestBody PostMajorResource postMajorResource) {
        this.majorService.saveMajor(postMajorResource);
    }
}
