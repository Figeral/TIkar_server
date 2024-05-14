package com.prod.Tikar;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import com.prod.Tikar.model.Asset;
import com.prod.Tikar.model.Lessor;
import com.prod.Tikar.model.Rent;
import com.prod.Tikar.model.Renter;
import com.prod.Tikar.model.Staff;
import com.prod.Tikar.model.StaffRole;
import com.prod.Tikar.model.assets.Basement;
import com.prod.Tikar.model.assets.BasementType;
import com.prod.Tikar.model.assets.Building;
import com.prod.Tikar.model.assets.Residence;
import com.prod.Tikar.repository.AssetRepository;
// import com.prod.Tikar.repository.BasementRepository;
// import com.prod.Tikar.repository.BuildRepository;
import com.prod.Tikar.repository.LessorRepository;
//import com.prod.Tikar.repository.BasementRepository;
import com.prod.Tikar.repository.RentRepository;
import com.prod.Tikar.repository.RenterRepository;
import com.prod.Tikar.repository.StaffRepository;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@SpringBootApplication
public class TikarsarlApplication implements CommandLineRunner {
	@Autowired
	RentRepository rentRepo;
	@Autowired
	RenterRepository renterRepo;
	@Autowired
	AssetRepository assetRepo;
	@Autowired
	LessorRepository lessorRepo;
	@Autowired
	StaffRepository staffRepo;

	Staff staff = new Staff("Nsangou", "Mouliom", "nsangoumouliom", 690462556,
			null, StaffRole.Admin, true);
	Lessor lessor = new Lessor("Emmauel", "Fitzgerard", 690462556, null, true);

	List<Asset> residence = List.of(new Residence(lessor, staff, 6546515,
			"Browtnown villa",
			"Bonamoussadi", "", 1654, 60000000, null, 7, true));

	Building building = new Building(lessor, staff, 216525, "Maison des Rois",
			"Makepe", "maison a trois niveeau", 5265,
			50000000, null, 3, true);

	List<Asset> basement = List
			.of(new Basement(5, BasementType.Appartement_vide, true, building,
					"apartement", 80000, 120000, null, lessor, staff));

	Renter renter = new Renter("Manore", "Manore", 655154835, null, true);
	Rent rent = new Rent(null, null, 2000, renter, residence, false);
	Rent rent1 = new Rent(null, null, 2000, renter, basement, false);

	public

	static void main(String[] args) {
		SpringApplication.run(TikarsarlApplication.class, args);

	}

	@GetMapping("/")
	public List<Asset> getMethodName() {
		return assetRepo.findAll();

	}

	@Override
	public void run(String... args) throws Exception {

		staffRepo.save(staff);
		lessorRepo.save(lessor);
		assetRepo.saveAll(residence);
		assetRepo.save(building);
		assetRepo.saveAll(basement);

		renterRepo.save(renter);
		rentRepo.save(rent);
		// rentRepo.save(rent1);

		// System.out.println("size is " + assetRepo.findAll().size());

	}

}
