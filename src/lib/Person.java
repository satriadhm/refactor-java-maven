package lib;


public class Person {
    public enum Gender{
		LELAKI, PEREMPUAN
	}
    private String firstName;
	private String lastName;
	private String idNumber;
	private String address;
    public Gender gender;

	public Person(String firstName, String lastName, String idNumber, String address, Gender gender) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = idNumber;
		this.address = address;
		this.gender = gender;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public String getIdNumber() {
		return this.idNumber;
	}

	public String getAddress() {
		return this.address;
	}

	public Gender getGender(){
		return this.gender;
	}

}
