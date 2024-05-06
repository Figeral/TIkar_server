package com.prod.Tikar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@SpringBootApplication
public class TikarsarlApplication {

	public static void main(String[] args) {
		SpringApplication.run(TikarsarlApplication.class, args);
	}
@GetMapping("")
public String getMethodName() {
    return new String("hello world");
}

}
