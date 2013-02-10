import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Main extends BasicGame
{
	static List<GameComponent>gameComponents = new ArrayList<GameComponent>();
	
	public Main()
	{
		super("Hello World");
	}

	@Override
	public void init(GameContainer gc) throws SlickException
	{
		Ball ball = new Ball(gc);
		gameComponents.add(ball);
		gameComponents.add(new Bat(gc, new PlayerInputBatController(gc), 10, ball));
		gameComponents.add(new Bat(gc, new AIBatController(ball), GameContainerConstants.ContainerWidth - 30, null));
		gameComponents.add(new PhysicsProcessor(gc));

	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException
	{
		for(GameComponent gameComponent : gameComponents)
		{
			gameComponent.update();
		}		
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		for(GameComponent gameComponent : gameComponents)
		{
			gameComponent.render();
		}
	}

	public static void main(String[] args) throws SlickException
	{
		AppGameContainer app = new AppGameContainer(new Main());
		app.setShowFPS(false);
		app.setDisplayMode(GameContainerConstants.ContainerWidth, GameContainerConstants.ContainerHeight, false);
		app.start();
	}
}