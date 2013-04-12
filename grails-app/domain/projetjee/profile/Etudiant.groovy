package projetjee.profile

import projetjee.reponse.Reponse
class Etudiant extends User{
		
	static constraints = {
		
	}
		
	static hasMany = [reponses : Reponse]
}

