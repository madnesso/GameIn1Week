

public interface IClamp {
    public float clamp(float var, float min, float max);
}

/*        if(var >= max)
            return var = max;
        else if(var <= min)
            return var = min;
        else 
            return var;*/
