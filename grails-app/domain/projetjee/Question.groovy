package projetjee

import java.util.Date;

class Question {

	String ennonce
	Date dateCreation
    static constraints = {
		ennonce(blank: false)
    }
	
	
	//points to owning object	
	static belongsTo = [enseignant : Enseignant]
	
	
	// specifies sort order Post collections
	static mapping ={		
		sort dateCreation :"desc"
	}
	
	static hasMany = [reponses : Reponse]
}
