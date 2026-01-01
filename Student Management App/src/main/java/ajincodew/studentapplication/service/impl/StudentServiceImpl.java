package ajincodew.studentapplication.service.impl;

import ajincodew.studentapplication.dto.GetStudentResource;
import ajincodew.studentapplication.dto.PostStudentResource;
import ajincodew.studentapplication.entity.MajorEntity;
import ajincodew.studentapplication.entity.StudentEntity;
import ajincodew.studentapplication.exception.CannotRetrieveStudentsException;
import ajincodew.studentapplication.mapper.StudentMapper;
import ajincodew.studentapplication.repository.MajorRepository;
import ajincodew.studentapplication.repository.StudentRepository;
import ajincodew.studentapplication.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
@Slf4j
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;
    private StudentMapper studentMapper;
    private MajorRepository majorRepository;

    @Override
    public void saveStudent(PostStudentResource postStudentResource) {
        try {
            StudentEntity studentEntity = studentMapper.postStudentToStudentEntity(postStudentResource);
            MajorEntity majorEntity = majorRepository.findById(postStudentResource.getMajorId()).orElse(null);
            if(majorEntity != null) {
                studentEntity.setId(UUID.randomUUID().toString());
                studentEntity.setMajor(majorEntity);
                studentRepository.save(studentEntity);
                log.info("Student saved successfully");
            } else {
                log.error("Major is not found");
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public GetStudentResource retrieveStudentById(String id) {
        try {
            StudentEntity studentEntity = studentRepository.findById(id).orElse(null);
            log.info("Retrieving student by id {}", id);
            return studentMapper.studentEntityToGetStudentResource(
                    studentEntity
            );
        } catch (CannotRetrieveStudentsException e) {
            log.error("Cannot retrieve student by id {}", id);
            throw new CannotRetrieveStudentsException(e.getMessage());
        }
    }

    public Page<GetStudentResource> retrieveAllStudents(Pageable pageable) {
        try {
            log.info("Retrieving all students");
            Page<StudentEntity> students = studentRepository.findAll(pageable);

            // Map all StudentEntity objects to GetStudentResource
            return studentMapper.toStudentPage(students);

        } catch (Exception e) {
            log.error("Error retrieving students", e);
            return new PageImpl<>(Collections.emptyList(), pageable, 0);
        }
    }

    @Override
    public void deleteStudent(String id) {
        log.info("Deleting student by id {}", id);
        studentRepository.deleteById(id);
    }
}
