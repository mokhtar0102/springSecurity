package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Etudiant;

public interface EtudiantRepository  extends JpaRepository<Etudiant	, Long>{

}
