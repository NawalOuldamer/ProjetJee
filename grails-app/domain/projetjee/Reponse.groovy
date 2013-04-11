package projetjee

class Reponse {

	String reponse
	
		
    static constraints = {
		reponse(blank: false)
    }
		
	static belongsTo = [Etudiant, Question]
}
