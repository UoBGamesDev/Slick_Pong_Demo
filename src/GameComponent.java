import org.newdawn.slick.GameContainer;

public abstract class GameComponent
{

	protected GameContainer game;
	
	public GameComponent(GameContainer game)
	{
		this.game = game;
	}
	
	public abstract void update();
	public abstract void render();
}
