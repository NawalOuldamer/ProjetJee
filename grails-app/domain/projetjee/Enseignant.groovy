package projetjee

class Enseignant extends User{

	 
		
	static constraints = {		
	}
	
	static hasMany = [question: Question]
}
