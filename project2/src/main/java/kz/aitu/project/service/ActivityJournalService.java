package kz.aitu.project.service;

import kz.aitu.project.entity.ActivityJournal;
import kz.aitu.project.repository.ActivityJournalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityJournalService {

    private final ActivityJournalRepository activityJournalRepository;

    public ActivityJournalService(ActivityJournalRepository activityJournalRepository) {
        this.activityJournalRepository = activityJournalRepository;
    }

    public List<ActivityJournal> getAll(){
        return activityJournalRepository.findAll();
    }

    public List<ActivityJournal> getActivityById(long id) {
        return activityJournalRepository.getActivityById(id);
    }

    public ActivityJournal createActivityJournal(ActivityJournal activityJournal) {
        return activityJournalRepository.save(activityJournal);
    }
}
