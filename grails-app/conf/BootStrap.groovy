import projetjee.User

class BootStrap {

    def init = { servletContext ->
		
		User ismail = new User(
			nom:"senhaji",
			prenom:"ismail",
			mail:"senhaji@hot.fr",
			pwd="123",
			role="Etudiant"
			)
		ifismail.save(){
			println "Erreur lors de la cr�ation du user ismail"
		}
    }
    def destroy = {
    }
}
