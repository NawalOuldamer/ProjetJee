package projetjee

class Cours {
	String nom
	static belongsTo=User
	static hasMany=[utilisateur:User]
	
	public String toString() {
		return "Cours [ Nom = "+nom+"]";
	}
	static constraints = {
		nom inList:["MA","MPI","JEE","IAWS","MCPOOA","AL","DCLL",]
    }
}
