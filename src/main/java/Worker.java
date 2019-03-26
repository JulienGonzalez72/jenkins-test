
public class Worker extends Person {
	
	private String job;
	
	public Worker(String firstName, String familyName, int age, String job) {
		super(firstName, familyName, age);
		this.job = job;
	}
	
	public String getJob() {
		return job;
	}
	
	public void setJob(String job) {
		this.job = job;
	}
	
}
