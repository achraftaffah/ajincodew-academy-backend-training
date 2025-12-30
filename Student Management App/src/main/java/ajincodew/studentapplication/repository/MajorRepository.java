package ajincodew.studentapplication.repository;

import ajincodew.studentapplication.entity.MajorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MajorRepository extends JpaRepository<MajorEntity, String> {
}
