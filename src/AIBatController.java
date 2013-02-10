public class AIBatController implements IBatController
{

	Ball ball;

	public AIBatController(Ball ball)
	{
		this.ball = ball;
	}

	@Override
	public BatInstructions getNextInstructions(Bat bat)
	{
		float difference = ball.getCollisionMask().centerY()
				- bat.getCollisionMask().centerY();

		if (difference > 0.5f)
		{
			return new BatInstructions(0.5f);
		}
		else if (difference < -0.5f)
		{
			return new BatInstructions(-0.5f);
		}

		else
		{
			return new BatInstructions(difference);
		}
	}

}
