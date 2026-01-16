import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
public class Main {
    public static void main(String[] args) throws IOException {
        boolean[][] schedule = new boolean[8][60];
        AppointmentBook a = new AppointmentBook(schedule);

        for (int i = 10; i < 15; i++) schedule[1][i] = true;
        for (int i = 30; i < 45; i++) schedule[1][i] = true;
        for (int i = 50; i < 60; i++) schedule[1][i] = true;

        a.printPeriod(2);

        System.out.println(a.findFreeBlock(2, 15));
        System.out.println(a.findFreeBlock(2, 9));
        System.out.println(a.findFreeBlock(2, 20));

        schedule = new boolean[8][60];

        setSchedule(schedule);

        AppointmentBook b = new AppointmentBook(schedule);

        int period = 2;
        while (period < 5) {
            System.out.println("Period: " + period);
            b.printPeriod(period);
            period++;
        }

        b.printPeriod(4);
        System.out.println(b.makeAppointment(2, 4, 22));
        System.out.println(b.makeAppointment(3, 4, 3));
        System.out.println(b.makeAppointment(2, 4, 30));
        b.printPeriod(4);

        System.out.println(read());
    }

    public static void setSchedule(boolean[][] schedule) {
        for (int i = 25; i < 30; i++) schedule[1][i] = true;
        for (int i = 0; i < 15; i++) schedule[2][i] = true;
        for (int i = 41; i < 60; i++) schedule[2][i] = true;
        for (int i = 5; i < 30; i++) schedule[3][i] = true;
        for (int i = 44; i < 60; i++) schedule[3][i] = true;
    }


    public static int read() throws FileNotFoundException {
        int meetings = 0;

        File f = new File("Schedules.txt");
        Scanner s = new Scanner(f);

        String schedule = "";

        while (s.hasNext()) {
            while (s.hasNextBoolean()) {
                schedule += s.nextBoolean() + " ";
            }

            AppointmentBook a = new AppointmentBook(readSchedule(schedule));
            schedule = "";
            if (a.makeAppointment(s.nextInt(), s.nextInt(), s.nextInt()))
                meetings += 1;
        }

        return meetings;
    }

    public static boolean[][] readSchedule(String lines) {
        Scanner s = new Scanner(lines);
        boolean[][] schedule = new boolean[8][60];
        for (int i = 0; i < schedule.length; i++) {
            for (int j = 0; j < schedule[i].length; j++) {
                schedule[i][j] = s.nextBoolean();
            }
        }
        return schedule;
    }

}