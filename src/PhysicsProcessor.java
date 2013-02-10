import org.newdawn.slick.GameContainer;


public class PhysicsProcessor extends GameComponent
{

	public PhysicsProcessor(GameContainer game)
	{
		super(game);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update()
	{
		
		
		for(GameComponent gc : Main.gameComponents)
		{
			if(gc instanceof Entity)
			{
				for(GameComponent gc2 : Main.gameComponents)
				{
					if(gc2 instanceof Entity)
					{
						if(((Entity)gc).getCollisionMask().intersects(((Entity) gc2).getCollisionMask()))
						{
							((Entity) gc).informOfCollision((Entity)gc2);
						}
					}
				}
			}
			
			
		}
		

		
	}

	@Override
	public void render()
	{
		// TODO Auto-generated method stub
		
	}
	
}
