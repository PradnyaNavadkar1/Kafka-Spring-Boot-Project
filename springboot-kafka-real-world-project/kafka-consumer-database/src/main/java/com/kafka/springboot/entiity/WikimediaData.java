package com.kafka.springboot.entiity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="wikimedia_recent_change")
public class WikimediaData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long wikimediaId;
    @Lob  // it should be persisted as a large object (LOB) in the database
    private String wikimediaEventData;
}
