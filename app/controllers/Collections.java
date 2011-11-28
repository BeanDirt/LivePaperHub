package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Collection;
import models.User;
import play.mvc.Controller;

public class Collections extends Controller {

	public static void enabled(){
		List<Collection> collections = Collection.connect(true);
		System.out.println(collections.size());
		renderJSON(collections);
	}
	
	public static void purchased(String userEmail){
		User user = User.connect(userEmail);
		List<Collection> collections = new ArrayList();
		for(String cid : user.purchasedCollections){
			Collection c = Collection.find("byCid", cid).first();
			collections.add(c);
		}
		renderJSON(collections);
	}
	
	public static void purchase(String cid, String userEmail){
		User user = User.connect(userEmail);
		if(user.purchaseCollection(cid)){
			renderText("success");
		}
		else renderText("failure");
	}
}
