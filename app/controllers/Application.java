package controllers;

import play.*;
import play.mvc.*;
import play.test.Fixtures;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
    	List users = User.findAll();
    	renderJSON(users);
    }
}