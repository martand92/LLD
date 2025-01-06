package _03_DesignPatterns._03_BehaviouralPattern.commandDesignPattern;

public class CircleCommand implements Command {

	private Shape shape;

	CircleCommand(Shape shape) {
		this.shape = shape;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		shape.draw();

	}

}
