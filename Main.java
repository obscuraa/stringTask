import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    private static boolean IsSimilar(String first, String second) {
        String firstLower = first.toLowerCase();
        String secondLower = second.toLowerCase();

        for (String partOfFirst : firstLower.split(" "))
        {
            if (secondLower.contains(partOfFirst))
                return true;
        }

        for (var partOfSecond : secondLower.split(" "))
        {
            if (firstLower.contains(partOfSecond))
                return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\User\\Desktop\\input.txt"));

        int n = Integer.parseInt(br.readLine());

        String[] firstInput = new String[n];

        int i = 0;
        while (br.readLine() != null && i < n)
        {
            firstInput[i] = br.readLine();
            i++;
        }

        int m = Integer.parseInt(br.readLine());

        String[] secondInput = new String[m];

        int j = 0;
        while (br.readLine() != null && j < m)
        {
            secondInput[j] = br.readLine();
            j++;
        }

        br.close();

        ArrayList output = new ArrayList<String>();

        for (String item1 : firstInput)
        {
            boolean similarWasFound = false;
            for (String item2 : secondInput)
            {
                if (item1 == item2)
                    continue;

                if (IsSimilar(item1, item2) || (firstInput.length == 1 && firstInput.length == secondInput.length))
                {
                    output.add(item1 + ':' + item2);
                    similarWasFound = true;
                }
            }

            if (!similarWasFound)
                output.add(item1 + ":?");
        }

        FileWriter writer = new FileWriter("C:\\Users\\User\\Desktop\\output.txt");
        for(Object str : output) {
            writer.write(str + System.lineSeparator());
        }
        writer.close();
    }
}
