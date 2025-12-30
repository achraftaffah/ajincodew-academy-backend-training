package ajincodew.studentapplication.controller;

import ajincodew.studentapplication.dto.PostMajorResource;
import ajincodew.studentapplication.entity.MajorEntity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface MajorController {
    @PostMapping
    void saveMajor(@Valid @RequestBody PostMajorResource postMajorResource);
}
