package cgg.practice.fileupload.fileuploadyt.Repos;

import cgg.practice.fileupload.fileuploadyt.entities.File;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepo extends JpaRepository<File, Long> {
  Optional<File> findByName(String name);
}
