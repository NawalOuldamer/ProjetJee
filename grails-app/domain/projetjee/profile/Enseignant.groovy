package projetjee.profile
import projetjee.question.Question

class Enseignant extends User{
		
	static constraints = {		
	}
	
	static hasMany = [question: Question]
}
