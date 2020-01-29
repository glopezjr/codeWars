import java.util.regex.Pattern;


public class CodeWars
{
    public static String reverseWords(final String original)
    {
        if (original.trim().length() == 0)
            return original;

        String[] reversedString = new StringBuilder(original.trim()).reverse().toString().split("\\s");
        StringBuilder solution = new StringBuilder();

        for (int i = (reversedString.length - 1); i >= 0; i--)
            solution.append(reversedString[i]).append(" ");

        return solution.toString().trim();
    }

    public static String[] mexicanWave (String str)
    {
        if (str.isEmpty())
            return new String[] { };

        String seatStr = str.toLowerCase();
        String[] wave = new String[str.replaceAll(" ", "").length()];

        for (int waveIndex = 0, seatIndex = 0; waveIndex < wave.length; waveIndex++, seatIndex++)
        {
            char seat = seatStr.charAt(seatIndex);

            while (Character.isWhitespace(seat))
            {
                seat = seatStr.charAt(++seatIndex);
            }

            StringBuilder seatWaveSB = new StringBuilder(seatStr);
            seatWaveSB.setCharAt(seatIndex, Character.toUpperCase(seat));
            wave[waveIndex] = seatWaveSB.toString();
        }

        return wave;
    }

    public static boolean validPhoneNumber(String phoneNumber)
    {
        return Pattern.matches("\\([0-9]{3}\\)\\s[0-9]{3}-[0-9]{4}", phoneNumber);
    }

    public static String cleanString(String s)
    {
        while (s.contains("#"))
            s = s.replaceAll("^#+|[^#]#", "");

        return s;
    }

    public static long[] productFib(long prod)
    {
        long previous = 0;
        long current = 1;
        long multiplied = previous * current;

        while (multiplied < prod)
        {
            long temp = current;
            current += previous;
            previous = temp;
            multiplied = previous * current;
        }

        return new long[] { previous, current, multiplied == prod ? 1 : 0 };
    }

    public static long ipsBetween(String start, String end)
    {
        return convertIpAddrToDec(end) - convertIpAddrToDec(start);
    }

    private static long convertIpAddrToDec(String ipAddr)
    {
        long result = 0;
        String[] ipAddressArr = ipAddr.split("\\.");

        for (int i = 0; i < ipAddressArr.length; i++)
        {
            int power = 3 - i;
            int ip = Integer.parseInt(ipAddressArr[i]);
            result += ip * Math.pow(256, power);
        }

        return result;
    }
}