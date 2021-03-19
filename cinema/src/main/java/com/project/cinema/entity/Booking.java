package com.project.cinema.entity;


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
@Table(name="booking")
public class Booking {
    @Id
    private int booking_id;
    private String booking_date;
    private String booking_time;
    private int ticket_number;
    private int seance_id;
    private int customer_id;

}
