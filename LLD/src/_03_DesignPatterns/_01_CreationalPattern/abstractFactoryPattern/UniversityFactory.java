package _03_DesignPatterns._01_CreationalPattern.abstractFactoryPattern;

//Abstract factory interface
public abstract class UniversityFactory {
	private static int cutoff = 109;

	// This abstract factory interface further delegates call to factory interface
	// method
	public static UniversityFactory getUniversityFactory(int score) {
		if (score > cutoff)
			return new IvyLeagueUniversityFactory();
		else
			return new PublicUniversityFactory();
	}

	public abstract AdmitCard getAdmitCard(String course);

	public abstract FeeCalculator getFeeCalculator(String course);
}
