package projetjee

import projetjee.reponse.Reponse
class Etudiant extends User{
		
	static constraints = {
		
	}
		
	static hasMany = [reponses : Reponse]
}

