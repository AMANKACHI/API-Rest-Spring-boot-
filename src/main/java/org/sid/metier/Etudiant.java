package org.sid.metier;

import java.text.Normalizer.Form;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Etudiant {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String nom;
	private String prenom;
	private Date datenaissance;
	
	@ManyToOne
	private Formation formation;

	public Etudiant(String nom, String prenom, Date datenaissance, Formation formation) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.datenaissance = datenaissance;
		this.formation = formation;
	}
	
	
	
	
	

}
