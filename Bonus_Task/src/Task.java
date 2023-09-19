class Task
{
    static int MAXYEAR = 9021;
    static int MINYEAR = 1010;

    public static void main(String[] args)
    {
        printBonusDatesBetween(2010, 2015);
    }

    public static void printBonusDatesBetween(int fromYear, int toYear)
    {
        for (int y = fromYear; y <= toYear; y++)
        {
            String str = String.valueOf(y);

            String rev = str;
            rev = reverse(rev);

            int month = Integer.parseInt(rev.substring(0, 2));
            int day = Integer.parseInt(rev.substring(2));

            if (isValidDate(day, month, y))
            {
                System.out.print(str + "-" + rev.substring(0,2) + "-" + rev.substring(2) + "\n");
            }
        }
    }

    public static boolean isLeap(int year)
    {
        return (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0));
    }

    public static boolean isValidDate(int d, int m, int y)
    {
        if (y > MAXYEAR || y < MINYEAR)
            return false;
        if (m < 1 || m > 12)
            return false;
        if (d < 1 || d > 31)
            return false;

        // February
        if (m == 2)
        {
            if (isLeap(y))
                return (d <= 29);
            else
                return (d <= 28);
        }

        // April, June, Sept and Nov
        if (m == 4 || m == 6 || m == 9 || m == 11)
            return (d <= 30);

        return true;
    }

    public static String reverse(String input)
    {
        char[] a = input.toCharArray();
        int r = a.length - 1;
        for (int i = 0; i < r; i++, r--)
        {
            char t = a[i];
            a[i] = a[r];
            a[r] = t;
        }
        return String.valueOf(a);
    }
}