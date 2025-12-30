package ajincodew.studentapplication.mapper;

import ajincodew.studentapplication.dto.GetMajorResource;
import ajincodew.studentapplication.dto.PostMajorResource;
import ajincodew.studentapplication.entity.MajorEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-14T21:12:46+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.14 (Amazon.com Inc.)"
)
@Component
public class MajorMapperImpl implements MajorMapper {

    @Override
    public GetMajorResource majorEntityToGetMajorResource(MajorEntity majorEntity) {
        if ( majorEntity == null ) {
            return null;
        }

        GetMajorResource getMajorResource = new GetMajorResource();

        getMajorResource.setId( majorEntity.getId() );
        getMajorResource.setName( majorEntity.getName() );

        return getMajorResource;
    }

    @Override
    public MajorEntity postMajorResourceToMajorEntity(PostMajorResource postMajorResource) {
        if ( postMajorResource == null ) {
            return null;
        }

        MajorEntity majorEntity = new MajorEntity();

        majorEntity.setName( postMajorResource.getName() );

        return majorEntity;
    }
}
