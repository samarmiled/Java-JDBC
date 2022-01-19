package DAO;

import java.util.List;

import METIER.ENTITY.Etudiant;

public interface IScolarite {
public void addEtudiant(Etudiant e);
public List<Etudiant> getAllEtudiant();
public List<Etudiant> getEtudiantsPMC(String mc);
public Etudiant getEtudiant(int id);
public void modifierEtudiant(Etudiant e);
public void supprimerEtudiant(int id);
}
