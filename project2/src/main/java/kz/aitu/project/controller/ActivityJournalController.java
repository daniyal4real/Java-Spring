package kz.aitu.project.controller;


import kz.aitu.project.entity.ActivityJournal;
import kz.aitu.project.service.ActivityJournalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ActivityJournalController {
    private final ActivityJournalService activityJournalService;

    public ActivityJournalController(ActivityJournalService activityJournalService) {
        this.activityJournalService = activityJournalService;
    }


    @GetMapping("/api/activity_journals")
    public ResponseEntity<?> getActivityJournals(){
        return ResponseEntity.ok(activityJournalService.getAll());
    }

    @GetMapping("/api/activity_journals/{id}")
    public List<ActivityJournal> getActivityJournalById(@PathVariable long id){
        return activityJournalService.getActivityById(id);
    }

    @PostMapping("/api/activity_journals")
    public ResponseEntity<?> createActivityJournal( @RequestBody ActivityJournal activityJournal){
        return ResponseEntity.ok(activityJournalService.createActivityJournal(activityJournal));
    }
}
