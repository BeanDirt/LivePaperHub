package controllers;

import models.User;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.test.Fixtures;

@OnApplicationStart
public class Bootstrap extends Job {

	@SuppressWarnings("deprecation")
	public void doJob(){
		if(User.count() == 0){
			Fixtures.deleteAll();
			Fixtures.loadModels("initial-data.yml");
		}
	}
}
