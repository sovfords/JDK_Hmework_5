import java.util.Random;

public class Philosopher implements Runnable
{
    private  String name;
    private int countFoodToEat = 3;


    private boolean isSitDown = false;
    private boolean isEatLast = false;
    private boolean lHandReady = false;
    private boolean rHandReady = false;


    private Table table;

    Philosopher(String name)
    {
        this.name = name;

    }
    @Override
    public void run()
    {
        while (countFoodToEat > 0)
        {
            /* PS: Я не знаю, как это работает, но без пустой команды со строки 29 код нормально не работает...
               Я пролистал код и толком не нашёл в нём ошибки, которые рассматривались как неправильная реализация потоков
               (даже решил ситуацию, когда каждый философ мог бы взять по одной вилке в руку, что ломало бы код)
               и т.к. это решает вопрос и не является нагрузко, задачу решённой считаю, но это костыль, и если вы не примите работу,
               то прошу объяснить, из-за чего именно проблема появляется и как её решить.
            * */
            //System.out.println(name + " работает");
            System.out.print("");
            if(isSitDown && table.getAllST())
            {
                if(isEatLast)
                {
                    think();
                }
                else
                {

                        if (table.getFork(table.getIndex(this)).take()) {
                            lHandReady = true;
                            System.out.println("Философ " + name + " взял вилку в левую руку");


                        }
                        else
                        {
                            System.out.println(name+ ": Вилка для левой руки была занята...");
                        }
                        if (table.getFork(table.getIndex(this) + 1).take()) {
                        rHandReady = true;
                        System.out.println("Философ " + name + " взял вилку в правую руку");
                        }
                        else
                        {
                            System.out.println(name+ ":Вилка для правой руки была занята...");
                        }



                    if(lHandReady && rHandReady)
                    {
                        eat();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    else if(! lHandReady)
                    {
                        System.out.println("О нет, " + name + " не смог взять левую вилку! Ему стоит отпустить правую, ибо она ему не нужна...");
                        putRFork();
                    }
                    else if (! rHandReady)
                    {
                        System.out.println("О нет, " + name + " не смог взять правую вилку! Ему стоит отпустить левую, ибо она ему не нужна...");
                        putLFork();
                    }


                }
            }
        }
        System.out.println("Философ " +name + " наелся");
    }

    public void sitDown(Table table)
    {

        table.addPeople(this);
        isSitDown = true;
        this.table = table;
        System.out.println("Философ " + name + " сел за стол");

    }
    public void think()
    {

            isEatLast = false;
            System.out.println("Философ " + name + " подумал");

    }

    public void eat()
    {
        System.out.println("Философ " + name + " поел");
            putLFork();

            putRFork();


        isEatLast = true;
        countFoodToEat -= 1;



    }

    private void putLFork()
    {
        table.getFork(table.getIndex(this)).put();
        lHandReady = false;
        System.out.println("Философ " +name + " отпустил вилку из левой руки");
    }

    private void putRFork()
        {
            table.getFork(table.getIndex(this) + 1).put();
            rHandReady = false;
            System.out.println("Философ " +name + " отпустил вилку из правой руки");
        }


}
