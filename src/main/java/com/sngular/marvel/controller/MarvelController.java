package com.sngular.marvel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sngular.marvel.models.MarvelPage;
import com.sngular.marvel.repository.service.MarvelRecordHistoryService;

@RestController
@RequestMapping("/api/marvel")
public class MarvelController {
	
	private final MarvelApi marvelApi;
	private final MarvelRecordHistoryService historyService;
	
	@Autowired
	public MarvelController(MarvelRecordHistoryService historyService,
			@Value("${marvel.api.private-key}") String apiPrivateKey,
            @Value("${marvel.api.public-key}") String apiPublicKey,
            @Value("${marvel.api.timestamp}") String timestamp) {
		
		this.marvelApi = new MarvelApi(apiPrivateKey, apiPublicKey, timestamp);
		this.historyService = historyService;
	}
	
	@GetMapping("/characters")
    public ResponseEntity<?> getMarvelCharacters() {
		MarvelPage pages = marvelApi.getCharacters();
		historyService.saveQueryTime();
        return ResponseEntity.ok().body(pages);
    }
	
	@GetMapping("/characters/{characterId}")
    public ResponseEntity<?> getMarvelCharacterById(@PathVariable int characterId) {
		MarvelPage pages = marvelApi.getCharacterById(characterId);
		historyService.saveQueryTime();
        return ResponseEntity.ok().body(pages);
    }
	
}
