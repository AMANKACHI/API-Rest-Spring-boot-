package org.sid;

import java.util.Date;

import org.sid.metier.Etudiant;
import org.sid.metier.EtudiantRepository;
import org.sid.metier.Formation;
import org.sid.metier.FormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class MicroserviceEtudiantApplication implements CommandLineRunner {
	
	@Autowired
	private EtudiantRepository etudiantRepository;
	
	@Autowired
	private FormationRepository formationRepository;
	
	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceEtudiantApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		repositoryRestConfiguration.exposeIdsFor(Formation.class,Etudiant.class);
		repositoryRestConfiguration.getCorsRegistry().addMapping("/**").allowedOrigins("http://localhost:4200").allowedHeaders(".").allowedMethods("OPTIONS","HEAD","GET","PUT","POST","DELETE","PATCH");
		repositoryRestConfiguration.setReturnBodyOnCreate(true);
		
		Formation f1=formationRepository.save(new Formation("Laravel",30));
		Formation f2=formationRepository.save(new Formation("Symfony",30));
		Formation f3=formationRepository.save(new Formation("angularjs",30));
		Formation f4=formationRepository.save(new Formation("Reactjs",30));
		
		etudiantRepository.save(new Etudiant("Soufiane","AMANKACHI",new Date(),f1));
		etudiantRepository.save(new Etudiant("farah","AMANKACHI",new Date(),f2));
		etudiantRepository.save(new Etudiant("fahd","AMANKACHI",new Date(),f3));
		etudiantRepository.save(new Etudiant("Farah","ElJorjany",new Date(),f4));
		
	}
}
