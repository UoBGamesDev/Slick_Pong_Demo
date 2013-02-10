import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Bat extends GameComponent implements Entity
{

	IBatController batController;
	Image bat;
	Vector position = new Vector();
	Ball ball;
	
	public Bat(GameContainer gc, IBatController batController, float startingX, Ball ball) throws SlickException
	{
		super(gc);
		this.batController = batController;
		this.ball = ball;
		bat = new Image("content/bat.png");
		position.x = startingX;
		position.y = (GameContainerConstants.ContainerHeight / 2) - (bat.getHeight() / 2);
	}
	
	@Override
	public void update()
	{
		BatInstructions instructions = batController.getNextInstructions();
		
		if(ball != null && (Float.compare(instructions.movementY, 0) != 0))
		{
			ball.startMoving();
		}
		
		position.y += instructions.movementY;
		position.y = MathHelper.clamp(position.y, 0, GameContainerConstants.ContainerHeight - bat.getHeight());
	}

	@Override
	public void render()
	{
		bat.draw(position.x, position.y);
	}

	@Override
	public Rectangle getCollisionMask()
	{
		return new Rectangle(position.x, position.y, bat.getWidth(), bat.getHeight());
	}

	@Override
	public void informOfCollision(Entity e)
	{
		// TODO Auto-generated method stub
		
	}

}
