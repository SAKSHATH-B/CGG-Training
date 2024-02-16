package cgg.smartcontactmanager.smartcontactmanager.dao;

import cgg.smartcontactmanager.smartcontactmanager.entities.Contact;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
  @Query("from Contact as c where c.user.id=:userId")
  Page<Contact> findContactByUser(
    @Param("userId") int userId,
    Pageable pageable
  );
}
