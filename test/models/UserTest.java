package models;
import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class UserTest extends UnitTest {

	@SuppressWarnings("deprecation")
	@Before
	public void setup(){
		Fixtures.deleteAll();
		Fixtures.loadModels("data.yml");
	}
	
	@After
	public void tearDown(){
		//Fixtures.deleteAll();
	}
	
    @Test
    public void createAndRetrieveUser(){
    	new User("Brian","Lanier","brinskee@gmail.com").save();
    	User brian = User.find("byEmail", "brinskee@gmail.com").first();

    	assertNotNull(brian);
    	assertEquals("Brian", brian.firstName);
    }
    
    @Test
    public void tryConnectAsUser(){
    	User ted = User.connect("citizen@tedconn.com");
    	User brian = User.connect("brinskee@gmail.com");
    	assertNotNull(ted);
    	assertNull(brian);
    }
    
    @Test
    public void tryPurchaseCollection(){
    	User ted = User.connect("citizen@tedconn.com");
    	assertEquals(1, ted.purchasedCollections.size());
    	assertEquals("64452654-72157627195160401", ted.purchasedCollections.get(0));
    	ted.purchaseCollection("64452654-72157627078307668");
    	assertEquals(2, ted.purchasedCollections.size());
    	assertEquals(-1, ted.purchasedCollections.indexOf("abc"));
    	assertTrue(ted.purchasedCollections.indexOf("64452654-72157627078307668") != -1);
    	assertFalse(ted.purchaseCollection("64452654-72157627078307668"));
    }
}
