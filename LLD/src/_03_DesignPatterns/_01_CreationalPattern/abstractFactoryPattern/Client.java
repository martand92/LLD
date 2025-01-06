package _03_DesignPatterns._01_CreationalPattern.abstractFactoryPattern;

public class Client {

	public static void main(String[] args) {
		int examScore = 125;

		UniversityFactory specificUniversityFactory = UniversityFactory.getUniversityFactory(examScore);

		AdmitCard admitCard = specificUniversityFactory.getAdmitCard("Math");
		FeeCalculator feeCalculator = specificUniversityFactory.getFeeCalculator("Math");
		System.out.println(admitCard.getClass());
		System.out.println(feeCalculator.calculateFee());
	}

}
