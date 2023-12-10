import java.util.Calendar;

public class CalendarPrinter {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java CalendarPrinter <month> <year>");
            return;
        }

        int month = Integer.parseInt(args[0]);
        int year = Integer.parseInt(args[1]);

        printCalendar(month, year);
    }

    public static void printCalendar(int month, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        int firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        // Create a 2D array to store the calendar
        String[][] calendarArray = new String[6][7];

        int day = 1;

        // Fill in the days of the month in the array
        for (int i = 0; i < calendarArray.length; i++) {
            for (int j = 0; j < calendarArray[i].length; j++) {
                if ((i == 0 && j < firstDayOfWeek - 1) || day > daysInMonth) {
                    calendarArray[i][j] = "   "; // Empty cell before the start of the month or after the end
                } else {
                    calendarArray[i][j] = String.format("%2d ", day); // Fill in the day
                    day++;
                }
            }
        }

        // Print the calendar
        System.out.println("Calendar for " + month + "/" + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        for (String[] week : calendarArray) {
            for (String dayOfMonth : week) {
                System.out.print(" "+dayOfMonth);
            }
            System.out.println();
        }
    }
}
