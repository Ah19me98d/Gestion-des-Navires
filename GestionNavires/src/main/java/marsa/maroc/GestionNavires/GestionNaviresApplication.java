package marsa.maroc.GestionNavires;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import marsa.maroc.GestionNavires.service.IMarsaInitService;



@SpringBootApplication
public class GestionNaviresApplication implements CommandLineRunner {
	@Autowired
	private IMarsaInitService marsaInitService;
	public static void main(String[] args) {
		SpringApplication.run(GestionNaviresApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		marsaInitService.initGrues();
		
	}

}
