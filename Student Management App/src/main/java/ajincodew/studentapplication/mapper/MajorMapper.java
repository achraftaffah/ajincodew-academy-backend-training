package ajincodew.studentapplication.mapper;

import ajincodew.studentapplication.dto.GetMajorResource;
import ajincodew.studentapplication.dto.PostMajorResource;
import ajincodew.studentapplication.entity.MajorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MajorMapper {
    GetMajorResource majorEntityToGetMajorResource(MajorEntity majorEntity);
    @Mapping(target = "name", source = "name")
    MajorEntity postMajorResourceToMajorEntity(PostMajorResource postMajorResource);
}