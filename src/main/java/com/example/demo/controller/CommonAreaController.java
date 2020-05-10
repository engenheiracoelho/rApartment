package com.example.demo.controller;

import com.example.demo.model.CommonArea;
import com.example.demo.repository.CommonAreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/commonArea")

@RestController
public class CommonAreaController {

	@Autowired
	private CommonAreaRepository commonAreaRepository;

	@PostMapping
	public CommonArea insert (@RequestBody CommonArea commonArea) {
		return commonAreaRepository.save(commonArea);
	}

	@GetMapping
	public ResponseEntity<List<CommonArea>> list() {
		return new ResponseEntity<List<CommonArea>>(
				commonAreaRepository.findAll(), HttpStatus.OK
		);
	}

	@GetMapping(path = {"/{id}"})
	public ResponseEntity findById (@PathVariable Long id) {
		return commonAreaRepository.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity update (@PathVariable("id") long id,
	                              @RequestBody CommonArea commonArea) {
		return commonAreaRepository.findById(id)
				.map(record -> {
					record.setName(commonArea.getName());
					record.setLocation(commonArea.getLocation());
					record.setExtraCost(commonArea.getExtraCost());
					CommonArea updated = commonAreaRepository.save(record);
					return ResponseEntity.ok().body(updated);
				}).orElse(ResponseEntity.notFound().build());
	}
}
