package ajincodew.studentapplication.service;

import ajincodew.studentapplication.dto.PostMajorResource;
import ajincodew.studentapplication.entity.MajorEntity;

public interface MajorService {
    void saveMajor(PostMajorResource postMajorResource);
}
