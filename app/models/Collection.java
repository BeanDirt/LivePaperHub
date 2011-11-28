package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class Collection extends Model {

	public String cid;
	public String title;
	public String description;
	public Boolean trial;
	public Boolean enabled;
	public String price;
	
	public Collection(String cid, String title, String description, Boolean trial, Boolean enabled, String price){
		this.cid = cid;
		this.title = title;
		this.description = description;
		this.trial = trial;
		this.enabled = enabled;
		this.price = price;
	}
	
	public static List<Collection> connect(Boolean enabled){
		return find("byEnabled", enabled).fetch();
	}
}
