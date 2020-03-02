package ensg.eu.TPSpring.metier;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table( name = "participant_table" )
public class Participant {
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	public int num_pers;
	
	@Column(name = "nom", nullable = false)
	public String nom;
	
	@Column(name = "prenom", nullable = false)
	public String prenom;
	
	@Column(name = "email", nullable = false)
	public String email;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_naiss", nullable = false)
	public Date date_naiss;
	
	
	@ManyToMany
	@JoinTable(
	  name = "evenement_participation", 
	  joinColumns = @JoinColumn(name = "num_pers"), 
	  inverseJoinColumns = @JoinColumn(name = "num_even"))
	public List<Evenement> evenements = new ArrayList<Evenement>();

	public Participant(String nom, String prenom, String email, Date date_naiss) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.date_naiss = date_naiss;
	}
	
	public Participant() {
		
	}
	
	@Override
	public String toString() {
		String result = prenom + " " + nom ;
		//for (Evenement evenement : evenements) {
		//	result += "\n - " + evenement; 
		//}
		return result;
	}
}