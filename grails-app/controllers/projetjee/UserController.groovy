package projetjee

import org.springframework.dao.DataIntegrityViolationException

import projetjee.profile.User;

class UserController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	
	def scaffold = User
	
	def login = {}
	
	
	
	
	def register = {
		def user = new User(params)
		if (user.validate()) {
		user.save()
		flash.message = "Successfully Created User"
		redirect(uri: '/')
		} else {
		flash.message = "Error Registering User"
		return [ user: user ]
		}
   }
	   
	
	def authenticate = {
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

}
