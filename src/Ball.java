import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Ball extends GameComponent implements Entity
{
	Image ball;
	Vector position;
	Vector velocity = Vector.Zero();

	public Ball(GameContainer gc) throws SlickException
	{
		super(gc);
		ball = new Image("content/ball.png");
		velocity = Vector.Zero();
		position = centerOfWindow();
	}

	private Vector centerOfWindow()
	{
		return new Vector((GameContainerConstants.ContainerWidth / 2)
				- (ball.getWidth() / 2),
				(GameContainerConstants.ContainerHeight / 2)
						- (ball.getHeight() / 2));
	}

	@Override
	public void update()
	{
		position = Vector.add(position, velocity);

		if (getCollisionMask().top() < 0
				|| getCollisionMask().bottom() > GameContainerConstants.ContainerHeight)
		{
			velocity.y *= -1;
		}

		if (getCollisionMask().right() < 0
				|| getCollisionMask().left() > GameContainerConstants.ContainerWidth)
		{
			position = centerOfWindow();
			velocity = Vector.Zero();
		}
	}

	@Override
	public void render()
	{
		ball.draw(position.x, position.y);

	}

	public void startMoving()
	{
		if (velocity.equals(Vector.Zero()))
		{
			velocity.x = -0.7f;
		}
	}

	public Rectangle getCollisionMask()
	{
		return new Rectangle(position.x, position.y, ball.getWidth(),
				ball.getHeight());
	}

	@Override
	public void informOfCollision(Entity e)
	{
		if (e instanceof Bat)
		{
			velocity.x *= -1f;
			PolarCoordinate pc = new PolarCoordinate(velocity);

			pc.origin += MathHelper.randomFloat((float) -Math.PI / 8f,
					(float) +Math.PI / 8f);

			velocity = pc.toCartesian();

			if (getCollisionMask().right() > e.getCollisionMask().right())
			{
				float penetration = e.getCollisionMask().right()
						- getCollisionMask().left();
				position.x += penetration;
			}
			else
			{
				float penetration = getCollisionMask().right()
						- e.getCollisionMask().left();
				System.out.println(penetration);
				position.x -= penetration;
			}

		}
	}
}
