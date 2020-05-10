package com.example.demo.controller;

import com.example.demo.model.ExtraCost;
import com.example.demo.repository.ExtraCostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/extraCost")

@RestController
public class ExtraCostController {

	@Autowired
	private ExtraCostRepository extraCostRepository;

	@PostMapping
	public ExtraCost insert (@RequestBody ExtraCost extraCost) {
		return extraCostRepository.save(extraCost);
	}

	@GetMapping
	public ResponseEntity<List<ExtraCost>> list() {
		return new ResponseEntity<List<ExtraCost>>(
				extraCostRepository.findAll(), HttpStatus.OK
		);
	}

	@GetMapping(path = {"/{id}"})
	public ResponseEntity findById (@PathVariable Long id) {
		return extraCostRepository.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity update (@PathVariable("id") long id,
	                              @RequestBody ExtraCost extraCost) {
		return extraCostRepository.findById(id)
				.map(record -> {
					record.setValue(extraCost.getValue());
					record.setName(extraCost.getName());
					ExtraCost updated = extraCostRepository.save(record);
					return ResponseEntity.ok().body(updated);
				}).orElse(ResponseEntity.notFound().build());
	}
}