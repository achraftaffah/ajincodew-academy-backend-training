package ajincodew.studentapplication.mapper;

import ajincodew.studentapplication.dto.GetStudentResource;
import ajincodew.studentapplication.dto.PostStudentResource;
import ajincodew.studentapplication.entity.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    // PostStudentResourceToStudentEntity
    // PostStudentResource -> StudentEntity
    StudentEntity postStudentToStudentEntity(PostStudentResource postStudentResource);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "age", target = "age")
    @Mapping(source = "major.name", target = "major.name")
    GetStudentResource studentEntityToGetStudentResource(StudentEntity studentEntity);

    List<GetStudentResource> studentEntityToGetStudentResource(List<StudentEntity> students);
}