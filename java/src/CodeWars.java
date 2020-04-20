import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


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

    public static String part(long n)
    {
        StringBuilder result = new StringBuilder();
        long range = 0;
        double average = 0;
        double median = 0;

        // delete duplicates
        Map<Integer, List<Integer>> existElements = new TreeMap<Integer, List<Integer>>();
        List<Integer> listOfNumbers = enumProds(n, existElements).stream().distinct().collect(Collectors.toList());
        Collections.sort(listOfNumbers);

        for (Integer num: listOfNumbers)
            average += num;

        average /= listOfNumbers.size();
        range = listOfNumbers.get(listOfNumbers.size() - 1) - listOfNumbers.get(0);

        if (listOfNumbers.size()%2 == 0)
            median = (double)(listOfNumbers.get(listOfNumbers.size() / 2 - 1) + listOfNumbers.get(listOfNumbers.size() / 2)) / 2;

        else
            median = (double) listOfNumbers.get(listOfNumbers.size() / 2);


        result.append("Range: ");
        result.append(range);
        result.append(" Average: ");
        DecimalFormat f = new DecimalFormat("##.00");
        result.append(f.format(average));
        result.append(" Median: ");
        result.append(f.format(median));

        return result.toString();
    }

    private static List<Integer> enumProds(long n, Map<Integer, List<Integer>> existElements)
    {
        List<Integer> addends = new ArrayList<Integer>();

        if (!existElements.containsKey((int) n))
        {
            if (n == 1)
                addends.add(1);
            else if (n == 2)
            {
                addends.add(2);
                addends.add(1);
            }
            else
            {
                long num = n;
                num--;

                addends.add((int) n);
                addends.add((int) num);

                long newNum = num;
                while (num > 1)
                {
                    num--;
                    List<Integer> listOfProds = enumProds(n - num, existElements);

                    for (Integer prevNumber: listOfProds)
                    {
                        newNum = num;
                        newNum *= prevNumber;
                        addends.add((int) newNum);
                    }
                }
            }

            addends = addends.stream().distinct().collect(Collectors.toList());
            existElements.put((int) n, addends);
        }
        else
        {
            addends.addAll(existElements.get((int)n));
        }

        return addends;
    }
}
