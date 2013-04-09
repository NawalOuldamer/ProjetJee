package projetjee

class Enseignant extends User{
	String departement 
	public String toString() {
		return "Enseignant [departement = "+departement+"]";
	}
	
	static constraints = {
		departement inList:["Informatique","Math","Physique","Bio","Chimie"]
	}
}
