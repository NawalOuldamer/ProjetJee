package projetjee

class Inscription {
	String nom
	String prenom
	String email
	String pwd
	String pwdC   // pwdC: password de confirmation
	
    static constraints = {		
		nom(blank: false)
		prenom(blank:false)
		email(blank: false, unique: true)
		pwd(blank: false, size :8..10)
		
		pwdC(
			blank: false,
			validator:{val,obj->return val==obj.pwd;}
			)
    }
	
}
