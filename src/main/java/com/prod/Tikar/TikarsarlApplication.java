package com.prod.Tikar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import com.prod.Tikar.model.Asset;
import com.prod.Tikar.model.Rent;
import com.prod.Tikar.model.Renter;
import com.prod.Tikar.model.assets.Basement;
import com.prod.Tikar.model.assets.BasementType;
import com.prod.Tikar.repository.BasementRepository;
import com.prod.Tikar.repository.RentRepository;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@SpringBootApplication
public class TikarsarlApplication implements CommandLineRunner {
	@Autowired
	BasementRepository basementRepo;

	public static void main(String[] args) {
		SpringApplication.run(TikarsarlApplication.class, args);
	}

	@GetMapping("")
	public String getMethodName() {
		return new String("<h1>hello world<h1/>");
	}

	@Override
	public void run(String... args) throws Exception {
		// basementRepo.save(new Basement(5, BasementType.studio, true));
	}

}
