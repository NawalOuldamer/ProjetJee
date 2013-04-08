package projetjee

class Question {

	String question
	
	static hasMany = [reponse : Reponse]
	
	
    static constraints = {
    }
}
