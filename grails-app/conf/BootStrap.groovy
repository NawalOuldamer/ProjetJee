import projetjee.User

class BootStrap {

    def init = { servletContext ->
		
		User ismail = new User(
			nom:"senhaji",
			prenom:"ismail",
			mail:"senhaji@hot.fr",
			pwd:"12345678",
			role:"Etudiant"
			)
		if (!ismail.save()){
			ismail.errors.allErrors.each{error ->
			println "Erreur lors de la création du user ismail"}
		}
    }
    def destroy = {
    }
}
