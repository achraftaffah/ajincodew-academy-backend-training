package ajincodew.studentapplication.service.impl;

import ajincodew.studentapplication.dto.PostMajorResource;
import ajincodew.studentapplication.entity.MajorEntity;
import ajincodew.studentapplication.entity.StudentEntity;
import ajincodew.studentapplication.mapper.MajorMapper;
import ajincodew.studentapplication.mapper.StudentMapper;
import ajincodew.studentapplication.repository.MajorRepository;
import ajincodew.studentapplication.service.MajorService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@AllArgsConstructor
@Service
@Slf4j
public class MajorServiceImpl implements MajorService {
    private MajorRepository majorRepository;
    private MajorMapper majorMapper;

    @Override
    public void saveMajor(PostMajorResource postMajorResource) {
        try {
            MajorEntity majorEntity = this.majorMapper.postMajorResourceToMajorEntity(postMajorResource);
            majorEntity.setId(UUID.randomUUID().toString());
            this.majorRepository.save(majorEntity);
            log.info("saved major {}", majorEntity.getId());
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }
}
