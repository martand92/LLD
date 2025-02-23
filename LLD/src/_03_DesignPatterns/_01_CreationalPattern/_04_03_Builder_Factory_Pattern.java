package _03_DesignPatterns._01_CreationalPattern;

//This example shows how to use Factory with Builder pattern

class User2 {

	// All final attributes
	private final String firstName;
	private final String lastName;
	private final int age;
	private final String phone;
	private final String email;

	// Private constructor
	private User2(UserBuilder builder) {
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

		public User2 build() {
			return new User2(this);
		}
	}
}

interface UserFactrory {
	public User2 createUser();
}

class RegularUserFactory implements UserFactrory {

	@Override
	public User2 createUser() {
		return new User2.UserBuilder().withFirstName("John").withLastName("Doe").build();
	}
}

class AdminUserFactory implements UserFactrory {

	@Override
	public User2 createUser() {
		return new User2.UserBuilder().withFirstName("Admin").build();
	}
}

public class _04_03_Builder_Factory_Pattern {

	public static void main(String[] args) {

		UserFactrory regularUserFactory = new RegularUserFactory();
		System.out.println(regularUserFactory.createUser());

		UserFactrory adminUserfactory = new AdminUserFactory();
		System.out.println(adminUserfactory.createUser());

	}

}