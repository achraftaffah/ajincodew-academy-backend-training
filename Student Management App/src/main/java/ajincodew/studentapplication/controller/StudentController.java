package ajincodew.studentapplication.controller;

import ajincodew.studentapplication.dto.GetStudentResource;
import ajincodew.studentapplication.dto.PostStudentResource;
import ajincodew.studentapplication.entity.StudentEntity;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface StudentController {
    @PostMapping
    void saveStudent(@Valid @RequestBody PostStudentResource postStudentResource);

    @GetMapping
    Page<GetStudentResource> retrieveAllStudents(Pageable pageable);

    @GetMapping("/{id}")
    GetStudentResource retrieveStudentById(@PathVariable String id);

    @DeleteMapping("/{id}")
    void deleteStudentById(@PathVariable String id);
}
