package com.sngular.marvel.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sngular.marvel.models.MarvelRecordHistory;

public interface MarvelRecordHistoryRepository extends JpaRepository<MarvelRecordHistory, UUID> {

}
