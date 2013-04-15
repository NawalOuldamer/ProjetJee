package projetjee.question

import java.util.Date;
import projetjee.profile.Enseignant;
class Question {	
	
	String contenuQuestion
	Date dateCreationQuestion
	Enseignant enseignant
	static belongsTo = [enseignant:Enseignant]
	
	String toString(){
		return "Question [ Question : "+contenuQuestion+" Date : "+dateCreationQuestion+ "Enseignant"+enseignant+"]"
	}
    static constraints = {
		contenuQuestion blank:false
	
    }
}
