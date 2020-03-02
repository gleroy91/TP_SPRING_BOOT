package ensg.eu.TPSpring;

import java.util.Date;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ensg.eu.TPSpring.metier.Participant;
import ensg.eu.TPSpring.services.ParticipantRepository;

@SpringBootApplication
public class TpSpringApplication {
	
	public static void main(String[] args) {
			
		SpringApplication.run(TpSpringApplication.class, args);
	}

}
