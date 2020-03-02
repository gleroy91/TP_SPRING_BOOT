package ensg.eu.TPSpring.services;

import org.springframework.data.repository.CrudRepository;

import ensg.eu.TPSpring.metier.Participant;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface ParticipantRepository extends CrudRepository<Participant, Integer> {

}