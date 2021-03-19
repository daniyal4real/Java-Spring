package kz.aitu.project.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="activity_journal")
public class ActivityJournal {
    @Id
    private long id;
    private String event_type;
    private String object_type;
    private long object_id;
    private long created_timestamp;
    private long created_by;
    private String message_level;
    private String message;

}
