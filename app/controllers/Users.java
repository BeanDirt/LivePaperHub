package controllers;

import java.util.List;

import models.User;

import play.mvc.Controller;

public class Users extends Controller {
	
	public static void index() {
    }
	
	public static void all(){
		List users = User.findAll();
		renderJSON(users);
	}
	
	public static void show(Long id){
		User user = User.findById(id);
		renderJSON(user);
	}
	
	public static void create(User user){
		user.save();
	}
}
