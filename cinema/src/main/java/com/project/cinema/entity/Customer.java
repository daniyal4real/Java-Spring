package com.project.cinema.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="customer")
public class Customer {
    @Id
    @Column(name="customer_id")
    private int id;
    private String customer_first_name;
    private String customer_last_name;
    private String customer_phone_number;
    private String customer_email;
}
