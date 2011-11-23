package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class User extends Model {
	public String firstName;
	public String lastName;
	public String email;

	@ElementCollection
    public List<String> purchasedCollections = new ArrayList();
    
	public User(String firstName, String lastName, String email){
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public User(String firstName, String lastName, String email, List<String> collections){
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.purchasedCollections = collections;
	}
	
	public static User connect(String email){
    	return find("byEmail", email).first();
	}
	
	public Boolean purchaseCollection(String cid){
		Collection collection = Collection.find("byCid",cid).first();
		if(purchasedCollections.indexOf(cid) == -1){
			purchasedCollections.add(collection.cid);
			return true;
		}
		return false;
	}
}
