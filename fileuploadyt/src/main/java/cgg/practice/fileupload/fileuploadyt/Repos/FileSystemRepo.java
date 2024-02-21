package cgg.practice.fileupload.fileuploadyt.Repos;

import cgg.practice.fileupload.fileuploadyt.entities.FileSystem;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileSystemRepo extends JpaRepository<FileSystem, Long> {
  Optional<FileSystem> findByName(String name);
}
