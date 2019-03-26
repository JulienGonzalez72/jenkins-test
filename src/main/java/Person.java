/**
 * Represents a person.
 * @author Julien Gonzalez
 */
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
	
	public void grow(int years) {
		if (years < 0) {
			throw new IllegalArgumentException("years must be positive or null !");
		}
		age += years;
	}
	
	@Override
	public String toString() {
		return firstName + " " + familyName + " (" + age + " ans)";
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
