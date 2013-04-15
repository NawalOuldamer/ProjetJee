package projetjee.question

import java.util.Date;
//import projetjee.profile.Enseigant
class Question {	
	
	String contenuQuestion
	Date dateCreationQuestion
	
	//static belongsTo = [enseignant:Enseignant]
	
	String toString(){
		return "Question [ Question : "+contenuQuestion+" Date : "+dateCreationQuestion+"]"
	}
    static constraints = {
		contenuQuestion blank:false
    }
}
