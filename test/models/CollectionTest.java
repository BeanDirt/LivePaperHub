package models;
import models.Collection;

import org.junit.Before;
import org.junit.Test;

import play.test.Fixtures;
import play.test.UnitTest;


public class CollectionTest extends UnitTest {

	@Before
	public void setup(){
		Fixtures.deleteDatabase();
		Fixtures.loadModels("data.yml");
	}
	
	@Test
	public void tryConnectAsCollection(){
		assertEquals(2,Collection.connect(true).size());
	}
}
