package _03_DesignPatterns._01_CreationalPattern;

class User {

	// All final attributes
	private final String firstName;
	private final String lastName;
	private final int age;
	private final String phone;
	private final String email;

	// Private constructor
	private User(UserBuilder builder) {
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.age = builder.age;
		this.phone = builder.phone;
		this.email = builder.email;
	}

	// Getters
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", phone=" + phone + ", email="
				+ email;
	}

	/*
	 * The final keyword on UserBuilder prevents other classes from inheriting from
	 * it, but it does not restrict the creation of multiple UserBuilder and User
	 * objects.
	 */
	public static final class UserBuilder {
		private String firstName;
		private String lastName;
		private int age;
		private String phone;
		private String email;

		public UserBuilder withFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public UserBuilder withLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public UserBuilder withAge(int age) {
			this.age = age;
			return this;
		}

		public UserBuilder withPhone(String phone) {
			this.phone = phone;
			return this;
		}

		public UserBuilder withEmail(String email) {
			this.email = email;
			return this;
		}

		public User build() {
			return new User(this);
		}
	}
}

public class _04_01_BuilderPattern {

	public static void main(String[] args) {
		User user = new User.UserBuilder().withFirstName("John").withLastName("Doe").withAge(30)
				.withPhone("123-456-7890").withEmail("john.doe@example.com").build();

		System.out.println(user);
	}

}

/*
 * Here builder class is inner class to main class. This provides better
 * encapsulation (by making main class in-accessible)
 * 
 * But builder class can also be standalone in same package or have it in
 * separate package
 */
