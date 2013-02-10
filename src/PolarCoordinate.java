
public class PolarCoordinate
{
	public float radius;
	public float origin;
	
	public PolarCoordinate(Vector vector)
	{
        radius = (float)Math.sqrt(Math.pow(vector.x, 2) + Math.pow(vector.y, 2));
        origin = (float)Math.atan(vector.y / vector.x);

        //Corrects angle returned by Math.Atan
        if (vector.x < 0)
        {
            origin += Math.PI;
        }
	}
	
    public Vector toCartesian()
    {
        float x = (float)(radius * Math.cos(origin));
        float y = (float)(radius * Math.sin(origin));
        return new Vector(x, y);
    }

}
