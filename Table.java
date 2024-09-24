import java.util.ArrayList;

public class Table
{


    private ArrayList<Philosopher> people;
    private ArrayList<Fork> forks;
    private boolean allSitDown = false;

    Table()
    {
        people = new ArrayList<>();
        forks = new ArrayList<>();
    }

    public void addPeople(Philosopher philosopher)
    {
        people.add(philosopher);
    }

    public void addFork(Fork fork)
    {

        forks.add(fork);
    }

    public Philosopher getPeople(int index)
    {
        try {
            return people.get(index);
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.println("Философа с таким индексом нет");
            return null;
        }

    }

    public Fork getFork(int index)
    {
        try {
            return forks.get(index);
        }
        catch (IndexOutOfBoundsException e)
        {

            return forks.get(0);

        }

    }
    public int getIndex(Philosopher philosopher)
    {
        for(int i =0; i < people.size();i ++)
        {
            if(people.get(i) == philosopher)
            {
                return i;
            }
        }
        return -1;
    }

    public boolean getAllST()
    {
        return allSitDown;
    }
    public void startEating()
    {
        allSitDown = true;
    }


}
