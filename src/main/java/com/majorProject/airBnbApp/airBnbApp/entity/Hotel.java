package com.majorProject.airBnbApp.airBnbApp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cache.annotation.EnableCaching;

@Entity
@Getter
@Setter
@Table(name="hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String city;

    @Column(columnDefinition = "")
    private String[] photos;



}
