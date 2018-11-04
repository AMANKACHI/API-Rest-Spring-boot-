package org.sid.metier;

import java.util.Collection;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Formation {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private int duree;
	
	@OneToMany(mappedBy="formation")
	private Collection<Etudiant> etudiants;

	public Formation(String nom, int duree) {
		super();
		this.nom = nom;
		this.duree = duree;
	}
	
	
	
	
	
	
	

}
