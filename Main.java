public class Main
{
    public static void main(String[] args)
    {
        Table table = new Table();

        Fork fork1 = new Fork();
        Fork fork2 = new Fork();
        Fork fork3 = new Fork();
        Fork fork4 = new Fork();
        Fork fork5 = new Fork();

        Philosopher philosopher1 = new Philosopher("Amy");
        Philosopher philosopher2 = new Philosopher("Peter");
        Philosopher philosopher3 = new Philosopher("Maria");
        Philosopher philosopher4 = new Philosopher("Alex");
        Philosopher philosopher5 = new Philosopher("Simon");


        table.addFork(fork1);
        table.addFork(fork2);
        table.addFork(fork3);
        table.addFork(fork4);
        table.addFork(fork5);

        Thread thread1 = new Thread(philosopher1);
        Thread thread2 = new Thread(philosopher2);
        Thread thread3 = new Thread(philosopher3);
        Thread thread4 = new Thread(philosopher4);
        Thread thread5 = new Thread(philosopher5);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        philosopher1.sitDown(table);
        philosopher2.sitDown(table);
        philosopher3.sitDown(table);
        philosopher4.sitDown(table);
        philosopher5.sitDown(table);

        table.startEating();
    }
}
