
public class Main
{
    public static void main(String[] args) {
        boolean[][] schedule = new boolean[8][60];
        for (int i = 25; i < 30; i++) {
            schedule[1][i] = true;
        }
        for (int i = 0; i < 15; i++) {
            schedule[2][i] = true;
        }
        for (int i = 41; i < 60; i++) {
            schedule[2][i] = true;
        }
        for (int i = 5; i < 30; i++) {
            schedule[3][i] = true;
        }
        for (int i = 44; i < 60; i++) {
            schedule[3][i] = true;
        }
        AppointmentBook a = new AppointmentBook(schedule);
        int period = 2;
        while (period < 5)
        {
            System.out.println(period);
            a.printPeriod(period);
            period++;
        }
    }
}