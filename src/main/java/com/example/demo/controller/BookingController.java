package com.example.demo.controller;

import com.example.demo.model.Booking;
import com.example.demo.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/booking")

@RestController
public class BookingController {

	@Autowired
	private BookingRepository bookingRepository;

	@PostMapping
	public Booking insert (@RequestBody Booking booking) {
		return bookingRepository.save(booking);
	}

	@GetMapping
	public ResponseEntity<List<Booking>> booking() {
		return new ResponseEntity<List<Booking>>(
				bookingRepository.findAll(), HttpStatus.OK
		);
	}

	@GetMapping(path = {"/{id}"})
	public ResponseEntity findById (@PathVariable Long id) {
		return bookingRepository.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity update (@PathVariable("id") long id,
	                              @RequestBody Booking booking) {
		return bookingRepository.findById(id)
				.map(record -> {
					record.setDate(booking.getDate());
					record.setStatus(booking.getStatus());
					record.setCommonArea(booking.getCommonArea());
					record.setUser(booking.getUser());
					Booking updated = bookingRepository.save(record);
					return ResponseEntity.ok().body(updated);
				}).orElse(ResponseEntity.notFound().build());
	}
}