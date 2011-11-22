import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {

	@SuppressWarnings("deprecation")
	@Before
	public void setup(){
		Fixtures.deleteAll();
		Fixtures.loadModels("data.yml");
	}
	
	@SuppressWarnings("deprecation")
	@After
	public void tearDown(){
		Fixtures.deleteAll();
	}
	
    @Test
    public void createAndRetrieveUser(){
    	User ted = User.find("byEmail", "citizen@tedconn.com").first();
    	
    	User foo = User.connect("kablooey", "foo@gmail.com");
    	
    	assertNull(ted);
    	assertEquals("Foo", foo.firstName);
    }
    
    @Test
    public void tryConnectAsUser(){
    	assertNotNull(User.connect("Jones", "bob@gmail.com"));
    	assertNull(User.connect("Foo","citizen@tedconn.com"));
    	assertNull(User.connect("Conn","example@example.com"));
    	assertNull(User.connect("foo", "example@example.com"));
    }
}
