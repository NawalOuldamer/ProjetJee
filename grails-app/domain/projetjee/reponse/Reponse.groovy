package projetjee.reponse

class Reponse {
	
	String contenuReponse
	Date dateReponse
	
	
	
	public String toString() {
		return contenuReponse;
	}
    static constraints = {
		contenuReponse(blank:false)
    }
}
