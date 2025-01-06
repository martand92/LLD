package _03_DesignPatterns._01_CreationalPattern.builderDesignPattern;

public class Client {
	
	public static void main(String[] args) {
		WardrobeBuilder.Builder builder = new WardrobeBuilder.Builder();
		
		//as each function returns builder object, it could be easily chained
		builder.doors(2).isMirror(true);
		
		//after building object, finally call build()
		builder.build();
		
		//WardrobeBuilder wardrobeBuilder = builder.build();
		//System.out.println(wardrobeBuilder.doors);
		//System.out.println(wardrobeBuilder.isMirror);
	}

}
