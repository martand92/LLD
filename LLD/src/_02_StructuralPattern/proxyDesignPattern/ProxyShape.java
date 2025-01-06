package _02_StructuralPattern.proxyDesignPattern;

public class ProxyShape implements Shape {

	private RealShape realShape;
	private String type;
	private String accessKey;

	public ProxyShape(String type, String accessKey) {
		this.type = type;
		this.accessKey = accessKey;
	}

	@Override
	public void draw() {
		
		// lazy initialization
		if (realShape == null)
			realShape = new RealShape(type);

		if (isValidAccessKey())
			realShape.draw();
		else
			System.out.println("Access denied: Invalid access key.");

	}

	private boolean isValidAccessKey() {
		// Add logic to check the access key here.
		// For simplicity, we'll check for a specific access key "12345".
		return "12345".equals(accessKey);
	}

}
