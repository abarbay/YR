package exam;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class LottoReader {
    private int[] arr = new int[90];

    public LottoReader() {

        try (BufferedReader read = new BufferedReader(new InputStreamReader(
                this.getClass().getClassLoader().getResourceAsStream("otos.csv")))) {
            String line = "";
            while ((line = read.readLine()) != null) {
                String currentLine = line;
                String[] content = currentLine.split(";");

                for (int i = 11; i < 16; i++) {
                    int num = Integer.parseInt(content[i]);
                    arr[num - 1]++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getNumber(int number) {
        LottoReader l = new LottoReader();
        return l.arr[number - 1];
    }
}
