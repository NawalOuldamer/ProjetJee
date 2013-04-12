package projetjee

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
			
			redirect(action:"show",id:user.id)
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
	
	def register = {
		def user = new User(params)
		if (user.validate()) {
		user.save()
		flash.message = "Successfully Created User"
		redirect(uri: '/')
		} else {
		flash.message = "Error Registering User"
		return [ user: user ]
		render(action:"create")
		}
   }
	   
	
	def authentification = {
	  def user = User.findByLoginAndPassword(params.login, params.password)
	  if(user){
		session.user = user
		flash.message = "Hello ${user.nom}!"
		redirect(controller:"entry", action:"list")
	  }else{
		flash.message = "Sorry, ${params.login}. Please try again."
		redirect(action:"login")
	  }
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
}
