package ensg.eu.TPSpring.metier;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import ensg.eu.TPSpring.metier.Evenement;
import ensg.eu.TPSpring.metier.Participant;

@Entity
@Table( name = "evenement_table" )
public class Evenement {
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	public int num_even;
	
	@Column(name = "intitule", nullable = false)
	public String intitule;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_debut", nullable = false)
	public Date date_debut;
	
	@ManyToMany(mappedBy = "evenements")
	public List<Participant> participants = new ArrayList<Participant>();

	public Evenement(String intitule, Date date_debut) {
		super();
		this.intitule = intitule;
		this.date_debut = date_debut;
	}
	
	public Evenement() {
		
	}
	/*
	public void addParticipant(Participant participant) {
		listParticipants.add(participant);
		participant.evenements.add(this);
	}*/
	
	public boolean deletable() {
		return participants.size() == 0;
	}
	
	@Override
	public String toString() {
		return intitule + " (" + date_debut + ")";
	}
	
	@Override
	public boolean equals(Object o) {
		if ( this == o ) {
			return true;
		}
		if ( o == null || getClass() != o.getClass() ) {
			return false;
		}
		Evenement evenement = (Evenement) o;
		return Objects.equals( intitule, evenement.intitule );
	}

}
