package data;

public class Contact {

	public Contact(int id, String name, String email, int number, int countryCode) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.number = number;
		this.countryCode = countryCode;
	}
	private int id;
	private String name;
	private String email;
	private int number;
	private int countryCode;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(int countryCode) {
		this.countryCode = countryCode;
	}
	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", email=" + email + ", number=" + number + "]";
	}

	
}
