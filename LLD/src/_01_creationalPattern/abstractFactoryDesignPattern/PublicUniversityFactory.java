package _01_creationalPattern.abstractFactoryDesignPattern;

public class PublicUniversityFactory extends UniversityFactory {

	@Override
	public AdmitCard getAdmitCard(String course) {
		// TODO Auto-generated method stub

		switch (course) {
		case "Math":
			return new USCAdmitCard();
		case "Physics":
			return new VSUAdmitCard();
		case "CS":
			return new ASUAdmitCard();
		default:
			break;
		}

		return null;
	}

	@Override
	public FeeCalculator getFeeCalculator(String course) {
		// TODO Auto-generated method stub
		
		switch(course) {
		case "Math":
			return new USCFeeCalculator();
		case "Physics":
			return new VSUFeeCalculator();
		case "CS":
			return new ASUFeeCalculator();
		default:
			break;
		}
		
		return null;
	}

}
