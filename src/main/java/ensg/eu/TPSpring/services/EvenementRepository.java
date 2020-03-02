package ensg.eu.TPSpring.services;

import org.springframework.data.repository.CrudRepository;

import ensg.eu.TPSpring.metier.Evenement;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface EvenementRepository extends CrudRepository<Evenement, Integer> {

}