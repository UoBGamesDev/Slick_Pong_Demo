
public class MathHelper
{
	private MathHelper()
	{}
	
	public static float clamp( float n,  float min,  float max)
	{
		if(n > max)
		{
			return max;
		}
		
		if(n < min)
		{
			return min;
		}
		
		return n;
	}
	
    public static float randomFloat(float min, float max)
    {
        return (float)Math.random() * (max - min) + min;
    }
}
