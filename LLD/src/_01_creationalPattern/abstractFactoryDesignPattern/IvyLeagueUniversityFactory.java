package _01_creationalPattern.abstractFactoryDesignPattern;

public class IvyLeagueUniversityFactory extends UniversityFactory {

	@Override
	public AdmitCard getAdmitCard(String course) {
		// TODO Auto-generated method stub
		switch (course) {
		case "Math":
			return new MITAdmitCard();
		case "Physics":
			return new CalTechAdmitCard();
		case "CS":
			return new GeorgiaTechAdmitCard();
		default:
			break;
		}

		return null;
	}

	@Override
	public FeeCalculator getFeeCalculator(String course) {
		// TODO Auto-generated method stub

		switch (course) {
		case "Math":
			return new MITFeeCalculator();
		case "Physics":
			return new CalTechFeeCalculator();
		case "CS":
			return new GeorgiaTechFeeCalculator();
		default:
			break;
		}

		return null;
	}

}
