import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

class JSONTest {

	@Test
	void testParse() {
		Person p = new Person("Roman", "Diez", 19);
		JSONObject json = JSONTransformer.toJSON(p);
		Person p2 = JSONTransformer.parse(new Person(null, null, 0), json);
		assertEquals(p.getFirstName(), p2.getFirstName());
		assertEquals(p.getFamilyName(), p2.getFamilyName());
		assertEquals(p.getAge(), p2.getAge());
	}
	
	@Test
	void testParseSuperClass() {
		Worker w = new Worker("Julien", "Gonzalez", 22, "Developer");
		JSONObject json = JSONTransformer.toJSON(w);
		Worker w2 = JSONTransformer.parse(new Worker(null, null, 0, null), json);
		assertEquals(w.getFirstName(), w2.getFirstName());
		assertEquals(w.getFamilyName(), w2.getFamilyName());
		assertEquals(w.getAge(), w2.getAge());
		assertEquals(w.getJob(), w2.getJob());
	}
	
	@Test
	void testToJSON() throws Exception {
		Person p = new Person("Roman", "Diez", 19);
		JSONObject json = JSONTransformer.toJSON(p);
		assertEquals(p.getFirstName(), json.get("firstName"));
		assertEquals(p.getFamilyName(), json.get("familyName"));
		assertEquals(p.getAge(), json.get("age"));
	}
	
	@Test
	void testToJSONSuperClass() throws Exception {
		Worker w = new Worker("Julien", "Gonzalez", 22, "Developer");
		JSONObject json = JSONTransformer.toJSON(w);
		assertEquals(w.getFirstName(), json.get("firstName"));
		assertEquals(w.getFamilyName(), json.get("familyName"));
		assertEquals(w.getAge(), json.get("age"));
		assertEquals(w.getJob(), json.get("job"));
	}
	
	@Test
	void testPrimitiveToJSON() throws Exception {
		assertEquals(0, JSONTransformer.toJSON((double) 0).getDouble("value"));
		assertEquals(0, JSONTransformer.toJSON((float) 0).getFloat("value"));
		assertEquals(0, JSONTransformer.toJSON((int) 0).get("value"));
		assertEquals(0, JSONTransformer.toJSON((long) 0).getLong("value"));
		assertEquals(0, JSONTransformer.toJSON((short) 0).getInt("value"));
		assertEquals(0, JSONTransformer.toJSON((byte) 0).getInt("value"));
		assertEquals('a', JSONTransformer.toJSON('a').get("value"));
		assertEquals(true, JSONTransformer.toJSON(true).get("value"));
	}
	
	@Test
	void testParsePrimitive() throws Exception {
		assertEquals(0, JSONTransformer.parse(0, new JSONObject().put("value", 0)));
		assertEquals(0, JSONTransformer.parse(0.0, new JSONObject().put("value", 0.0)));
		assertEquals(0, JSONTransformer.parse(0.0, new JSONObject().put("value", 0.0f)));
		assertEquals(0, JSONTransformer.parse(0, new JSONObject().put("value", (short) 0)));
		assertEquals(0, JSONTransformer.parse(0, new JSONObject().put("value", (byte) 0)));
		assertEquals(0, JSONTransformer.parse(0L, new JSONObject().put("value", 0L)));
		assertEquals('a', JSONTransformer.parse(0, new JSONObject().put("value", 'a')));
		assertEquals(true, JSONTransformer.parse(false, new JSONObject().put("value", true)));
	}
	
}
