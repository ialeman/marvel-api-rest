package com.sngular.marvel.models;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

import java.time.LocalDateTime;
import java.util.UUID;


@Data
@Entity
public class MarvelRecordHistory {

	@Id
    @GeneratedValue
	@Type(type="uuid-char")
    private UUID id;

    private LocalDateTime dateTime;
    
}
