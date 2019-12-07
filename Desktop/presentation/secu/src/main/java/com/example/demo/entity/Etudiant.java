package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;

@Entity
public class Etudiant implements Serializable{
	@Id
	@GeneratedValue
	private Long idEtudiant ; 
	private String nom ;
	private String prenom ;
 	private Date  dateNaiss;
	 
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDateNaiss() {
		return dateNaiss;
	}
	public void setDateNaiss(Date dateNaiss) {
		this.dateNaiss = dateNaiss;
	}
	public Etudiant(String nom, String prenom, Date dateNaiss) {
		super();
 
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaiss = dateNaiss;
	}
	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
