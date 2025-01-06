package _03_BehaviouralPattern.commandDesignPattern;

public class SquareCommand implements Command {

	private Shape shape;

	SquareCommand(Shape shape) {
		this.shape = shape;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		shape.draw();

	}

}
