package projetjee

class Etudiant extends User{
	String parcours
	
	public String toString(){
		return "Etudiant [Parcours = "+parcours+"]";
	}
	static constraints = {
		parcours inList:["DL","IHM","IA","CAMSI"]
	}
	
	
	
}

