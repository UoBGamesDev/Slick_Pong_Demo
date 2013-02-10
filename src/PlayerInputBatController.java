import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;


public class PlayerInputBatController implements IBatController
{
	
	GameContainer gc;
	
	public PlayerInputBatController(GameContainer gc)
	{
		this.gc = gc;
	}

	@Override
	public BatInstructions getNextInstructions(Bat bat)
	{
		float movementY = 0;
		
		if(gc.getInput().isKeyDown(Input.KEY_UP))
		{
			movementY -= 0.5f;
		}
		
		if(gc.getInput().isKeyDown(Input.KEY_DOWN))
		{
			movementY += 0.5f;
		}
		
		return new BatInstructions(movementY);
		
		
		
		
		
	}

}
