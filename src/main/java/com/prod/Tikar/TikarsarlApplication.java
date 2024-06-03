package com.prod.Tikar;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prod.Tikar.model.Asset;
import com.prod.Tikar.model.Lessor;
import com.prod.Tikar.model.Rent;
import com.prod.Tikar.model.Renter;
import com.prod.Tikar.model.Staff;
import com.prod.Tikar.model.StaffRole;
import com.prod.Tikar.model.assets.AssetType;
import com.prod.Tikar.model.assets.Basement;
import com.prod.Tikar.model.assets.BasementType;
import com.prod.Tikar.model.assets.Building;
import com.prod.Tikar.model.assets.Residence;
import com.prod.Tikar.repository.AssetRepository;
import com.prod.Tikar.repository.BasementRepository;
import com.prod.Tikar.repository.BuildingRepository;
import com.prod.Tikar.repository.LessorRepository;
import com.prod.Tikar.repository.RentRepository;
import com.prod.Tikar.repository.RenterRepository;
import com.prod.Tikar.repository.ResidenceRepository;
import com.prod.Tikar.repository.StaffRepository;

@RestController
@SpringBootApplication
public class TikarsarlApplication implements CommandLineRunner {
	@Autowired(required = true)
	RentRepository rentRepo;
	@Autowired
	RenterRepository renterRepo;
	@Autowired
	AssetRepository assetRepo;
	@Autowired
	LessorRepository lessorRepo;
	@Autowired
	StaffRepository staffRepo;
	@Autowired
	BuildingRepository buildRepo;
	@Autowired
	BasementRepository basementRepo;
	@Autowired
	ResidenceRepository residenceRepo;
	String city[] = { "douala", "yaounde" };
	Staff staff = new Staff("Nsangou", "Mouliom", "nsangoumouliom", 690462556, null, StaffRole.Admin, true);
	Lessor lessor = new Lessor("Emmauel", "Fitzgerard", 690462556, null, true);

	Asset residence = new Residence(lessor, staff, 6546515L,
			" Black town",
			"Akwa", city[1], "", 1645, 4400000, null, 12, false, AssetType.Residence);
	Building building = new Building(lessor, staff, 2165256L, "Maison des Rois", "Makepe", city[0],
			"Immeuble a trois niveeau",
			5265,
			50000000, null, 3, true, AssetType.Building);

	Basement basement = new Basement(5, BasementType.vide, true, building, "apartement", 80000, 120000,
			null, staff, AssetType.Appartement);

	Renter renter = new Renter("Paco", "DE la plume", 655154835, null, true);
	Renter renter1 = new Renter("Danielle", "Abib", 695123546, null, true);
	Rent rent = new Rent(null, null, 645000, renter, residence, true);

	Rent rent1 = new Rent(null, null, 145000, renter1, basement, false);
	List<Rent> r = List.of(rent, rent1);
	List<Renter> renters = List.of(renter, renter1);

	@Autowired
	public

	static void main(String[] args) {
		SpringApplication.run(TikarsarlApplication.class, args);

	}

	@GetMapping(value = "/error")
	public String getMethodName() {
		return "<h1> Page not found lol </h1>";

	}

	@Override
	public void run(String... args) throws Exception {

		staffRepo.save(staff);
		lessorRepo.save(lessor);
		assetRepo.save(building);
		assetRepo.save(residence);

		// assetRepo.save(basement);
		basementRepo.save(basement);
		renterRepo.saveAll(renters);
		rentRepo.saveAll(r);
		// rentRepo.save(rent);

	}
}
