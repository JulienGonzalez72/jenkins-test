import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonTest {
	
	private Person person;
	
	@BeforeEach
	void setUp() {
		person = new Person("Julien", "Gonzalez", 20);
	}
	
	@Test
	void testSuccess() {
		person.grow();
		assertEquals(21, person.getAge());
	}
	
	@Test
	void testGrowMultiple() throws Exception {
		person.grow(17);
		assertEquals(37, person.getAge());
	}
	
	@Test
	void testJSON() throws Exception {
		JSONObject json = person.toJSON();
		assertTrue(json.has("firstName"));
		assertTrue(json.has("familyName"));
		assertTrue(json.has("age"));
	}
	
	//@Test
	void testFail() {
		person.grow();
		assertEquals(19, person.getAge());
	}

}
