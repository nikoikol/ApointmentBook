
public class Main
{
    public static void main(String[] args)
    {
    boolean[][] schedule = new boolean [8][60];
    for(int i = 10; i < 15; i++)
    {
        schedule[1][i] = true;
    }
    for(int i = 30; i < 44; i++)
        {
            schedule[1][i] = true;
        }
    for(int i = 50; i < 59; i++)
        {
            schedule[1][i] = true;
        }
    AppointmentBook a = new AppointmentBook(schedule);
    a.printPeriod(2);
    System.out.println(a.findFreeBlock(1, 5));
    }
}