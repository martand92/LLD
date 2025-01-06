package _01_creationalPattern.builderDesignPattern;

public class WardrobeBuilder {

	// Declare all variables as final as they are assigned values from static
	// class's (Builder) object
	@SuppressWarnings("unused")
	private final int doors;

	@SuppressWarnings("unused")
	private final boolean isMirror;

	@SuppressWarnings("unused")
	private final boolean isWheels;

	@SuppressWarnings("unused")
	private final boolean isHangingRod;

	@SuppressWarnings("unused")
	private final int compartments;

	// Private Constructor of WardrobeBuilder that would be instantiated inside
	// build() of static class
	private WardrobeBuilder(Builder builder) {
		this.doors = builder.doors;
		this.isMirror = builder.isMirror;
		this.isWheels = builder.isWheels;
		this.isHangingRod = builder.isHangingRod;
		this.compartments = builder.compartments;
	}

	public static class Builder {
		private int doors;
		private boolean isMirror;
		private boolean isWheels;
		private boolean isHangingRod;
		private int compartments;

		// Create function for each property and return Builder
		public Builder doors(int doors) {
			this.doors = doors;
			return this;
		}

		public Builder isMirror(boolean isMirror) {
			this.isMirror = isMirror;
			return this;
		}

		public Builder isWheels(boolean isWheels) {
			this.isWheels = isWheels;
			return this;
		}

		public Builder isHangingRod(boolean isHangingRod) {
			this.isHangingRod = isHangingRod;
			return this;
		}

		public Builder compartments(int compartments) {
			this.compartments = compartments;
			return this;
		}

		// Now have a build function that returns instance of WardrobeBuilder by calling
		// WardrobeBuilder's constructor by passing currently constructed builder object
		// (this)
		public WardrobeBuilder build() {
			return new WardrobeBuilder(this);
		}
	}

}
