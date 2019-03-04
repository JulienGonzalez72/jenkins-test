import org.json.JSONObject;

public class Person {
	
	private String firstName, familyName;
	private int age;
	
	public Person(String firstName, String familyName, int age) {
		this.firstName = firstName;
		this.familyName = familyName;
		this.age = age;
	}
	
	public void grow() {
		age++;
	}
	
	@Override
	public String toString() {
		return firstName + " " + familyName + " (" + age + " ans)";
	}
	
	public JSONObject toJSON() {
		JSONObject json = new JSONObject();
		json.put("firstName", firstName);
		json.put("familyName", familyName);
		json.put("age", age);
		return json;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
