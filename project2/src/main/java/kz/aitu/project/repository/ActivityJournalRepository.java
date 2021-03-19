package kz.aitu.project.repository;


import kz.aitu.project.entity.ActivityJournal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityJournalRepository extends CrudRepository<ActivityJournal, Long> {

    List<ActivityJournal> findAll();

    List<ActivityJournal> getActivityById(long id);

}
