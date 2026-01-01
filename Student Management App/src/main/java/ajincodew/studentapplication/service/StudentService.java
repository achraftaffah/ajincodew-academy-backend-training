package ajincodew.studentapplication.service;

import ajincodew.studentapplication.dto.GetStudentResource;
import ajincodew.studentapplication.dto.PostStudentResource;
import ajincodew.studentapplication.entity.StudentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    void saveStudent(PostStudentResource postStudentResource);

    GetStudentResource retrieveStudentById(String id);

    Page<GetStudentResource> retrieveAllStudents(Pageable pageable);

    void deleteStudent(String id);
}