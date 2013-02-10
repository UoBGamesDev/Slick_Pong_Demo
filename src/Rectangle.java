
public class Rectangle
{
	public float x;
	public float y;
	public float width;
	public float height;
	
	public Rectangle(float x, float y, float width, float height)
	{
		this.x = x;
		this.y = y;
		this.width  = width;
		this.height = height;
	}
	
	public float top()
	{
		return y;
	}
	
	public float bottom()
	{
		return y + height;
	}
	
	public float left()
	{
		return x;
	}
	
	public float right()
	{
		return x + width;
	}
	
	public float centerY()
	{
		return top() + (height/2f);
	}
	
	public boolean intersects(Rectangle rect2)
	{
		if(top() > rect2.bottom())
		{
			return false;
		}
		
		if(bottom() < rect2.top())
		{
			return false;
		}
		
		if(right() < rect2.left())
		{
			return false;
		}
		
		if(left() > rect2.right())
		{
			return false;
		}
		
		return true;
		
		
	}
}
