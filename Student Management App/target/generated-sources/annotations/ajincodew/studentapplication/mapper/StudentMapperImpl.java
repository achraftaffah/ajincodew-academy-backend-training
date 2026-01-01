package ajincodew.studentapplication.mapper;

import ajincodew.studentapplication.dto.GetMajorResource;
import ajincodew.studentapplication.dto.GetStudentResource;
import ajincodew.studentapplication.dto.PostStudentResource;
import ajincodew.studentapplication.entity.MajorEntity;
import ajincodew.studentapplication.entity.StudentEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-01T01:11:16+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.14 (Amazon.com Inc.)"
)
@Component
public class StudentMapperImpl implements StudentMapper {

    @Override
    public StudentEntity postStudentToStudentEntity(PostStudentResource postStudentResource) {
        if ( postStudentResource == null ) {
            return null;
        }

        StudentEntity studentEntity = new StudentEntity();

        studentEntity.setFirstName( postStudentResource.getFirstName() );
        studentEntity.setLastName( postStudentResource.getLastName() );
        studentEntity.setEmail( postStudentResource.getEmail() );
        studentEntity.setAge( postStudentResource.getAge() );

        return studentEntity;
    }

    @Override
    public GetStudentResource studentEntityToGetStudentResource(StudentEntity studentEntity) {
        if ( studentEntity == null ) {
            return null;
        }

        GetStudentResource getStudentResource = new GetStudentResource();

        getStudentResource.setMajor( majorEntityToGetMajorResource( studentEntity.getMajor() ) );
        getStudentResource.setId( studentEntity.getId() );
        getStudentResource.setFirstName( studentEntity.getFirstName() );
        getStudentResource.setLastName( studentEntity.getLastName() );
        getStudentResource.setEmail( studentEntity.getEmail() );
        getStudentResource.setAge( studentEntity.getAge() );

        return getStudentResource;
    }

    protected GetMajorResource majorEntityToGetMajorResource(MajorEntity majorEntity) {
        if ( majorEntity == null ) {
            return null;
        }

        GetMajorResource getMajorResource = new GetMajorResource();

        getMajorResource.setName( majorEntity.getName() );
        getMajorResource.setId( majorEntity.getId() );

        return getMajorResource;
    }
}
