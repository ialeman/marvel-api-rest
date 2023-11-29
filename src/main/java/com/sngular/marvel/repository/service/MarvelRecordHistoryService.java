package com.sngular.marvel.repository.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sngular.marvel.models.MarvelRecordHistory;
import com.sngular.marvel.repository.MarvelRecordHistoryRepository;

@Service
public class MarvelRecordHistoryService {

	
	private final MarvelRecordHistoryRepository marvelRepository;

    @Autowired
    public MarvelRecordHistoryService(MarvelRecordHistoryRepository marvelRepository) {
        this.marvelRepository = marvelRepository;
    }

    public void saveQueryTime() {
        MarvelRecordHistory marvelQuery = new MarvelRecordHistory();
        marvelQuery.setDateTime(LocalDateTime.now());
        marvelRepository.save(marvelQuery);
    } 
}
