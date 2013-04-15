package projetjee.profile

import org.springframework.dao.DataIntegrityViolationException

import projetjee.profile.User;

class UserController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	
	//def scaffold = User
	
	def login = {
		def user=User.findByMailAndRole(params.myLogin,params.myRole)
		if(user==null || user.getPassword()!=params.myPassword){
			flash.message="Erreur d'authentification"
			redirect(uri:"/")}
		else{
			
			//redirect(action:"show",id:user.id)
			redirect(action:"showHome",id:user.id)
			}
		}
	
	
	def create() {
		[userInstance: new User(params)]
	}

	def save() {
		def userInstance = new User(params)
		if (!userInstance.save(flush: true)) {
			render(view: "create", model: [userInstance: userInstance])
			return
		}
		flash.message = message(code: 'default.created.message', args: [message(code: 'user.label', default: 'User'), userInstance.id])
		redirect(action: "show", id: userInstance.id)
	}
	
	def logout = {
	  flash.message = "Goodbye ${session.user.nom}"
	  session.user = null
	  redirect(controller:"entry", action:"list")
	}
	
	def show(Long id) {
		def userInstance = User.get(id)
		if (!userInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), id])
			redirect(action: "list")
			return
		}

		[userInstance: userInstance]
	}
	
	def list(Integer max) {
		params.max = Math.min(max ?: 10, 100)
		[userInstanceList: User.list(params), userInstanceTotal: User.count()]
	}
	
	def showHome(Long id){
		def userInstance = User.get(id)
		def userRole = userInstance.getRole()
		if (!userInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), id])
			}
		else{
			if(userRole=="Enseignant")
			redirect(controller :"Enseignant" ,action: "showHomeEnseignant", id:userInstance.id)
			//redirect(controller: "Etudiant", action:"showHomeEtudiant",id :userInstance.id)
			return
		}

		[userInstance: userInstance]
		
	}

}

	