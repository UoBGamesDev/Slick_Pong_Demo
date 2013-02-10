public class Vector
{
	public float x;
	public float y;

	public Vector()
	{

	}

	public Vector(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
	
	public Vector(PolarCoordinate p)
	{
		
	}

	public static Vector Zero()
	{
		return new Vector(0, 0);
	}

	public static Vector add(Vector vector1, Vector vector2)
	{
		return new Vector(vector1.x + vector2.x, vector1.y + vector2.y);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj.getClass() == Vector.class)
		{
			Vector vector = (Vector) obj;
			if ((Float.compare(x, vector.x) == 0)
					&& (Float.compare(y, vector.y) == 0))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return super.equals(obj);
		}
	}
}
