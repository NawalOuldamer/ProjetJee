package projetjee.profile

class User {
	
	String nom
	String prenom
	String mail
	String password
	String role
	
	
	
	public String toString() {
		return "Utilisateur [Nom = "+nom+",Prenom = "+prenom+",Mail = "+mail+" ,Mot de passe = "+password+"Role = "+role+"]";
	}
    
	static constraints = {
		nom nullable:false , blank:false
		prenom nullable:false, blank:false
		password nullable:false, size:8..10
		role inList:["Enseignant","Etudiant"]
		mail email:true, blank:false
		
		}
	
	}
