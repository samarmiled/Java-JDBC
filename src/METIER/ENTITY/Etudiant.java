package METIER.ENTITY;

public class Etudiant {
private int id;
private String nom,prenom;
public Etudiant(String nom, String prenom) {
	this.nom = nom;
	this.prenom = prenom;
}
public Etudiant() {
	super();
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
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





}
