package projetjee

class Etudiant extends User{
		
	static constraints = {
		
	}
		
	static hasMany = [reponses : Reponse]
}

