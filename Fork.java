public class Fork
{
    private volatile boolean isUse = false;
    Fork()
    {

    }

    public boolean take()
    {
        if(!isUse)
        {
            isUse = true;
            return true;
        }
        return false;
    }

    public boolean put()
    {
        if (isUse)
        {
            isUse = false;
            return true;
        }
        return false;
    }
}
