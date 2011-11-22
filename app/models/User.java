package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class User extends Model {
	public String firstName;
	public String lastName;
	public String email;
	
	public User(String firstName, String lastName, String email){
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public static User connect(String lastName, String email){
    	return find("byLastNameAndEmail", lastName, email).first();
	}
}
