import java.io.*;

public class Main {

    public static void main (String [] args) {

        String [] file_names = new String[10];
        file_names[0] = "193378.txt";
        file_names[1] = "213164.txt";
        file_names[2] = "204146.txt";
        file_names[3] = "214253.txt";
        file_names[4] = "212490.txt";
        file_names[5] = "210133.txt";
        file_names[6] = "213097.txt";
        file_names[7] = "193715.txt";
        file_names[8] = "197346.txt";
        file_names[9] = "199879.txt";
        String [] new_file_names = new String [30];

        for (int k = 0; k < 30; k++) {

            String str1 = String.valueOf(k+1);
            str1 = str1 +".txt";
            new_file_names[k] = "C:\\Users\\kosta\\Desktop\\\\New_Collection_1\\" + str1;

        }

        int counter2 = 0;
        for (int i = 0; i < 10; i++) {

            String str = "";
            String file_name = "C:\\Users\\kosta\\Desktop\\\\Collection_1\\" + file_names[i];
            int counter = 0;

            try (FileReader reader = new FileReader(file_name);
                 BufferedReader br = new BufferedReader(reader)) {
                 String line;
                while ((line = br.readLine()) != null) {
                    counter++;
                }

            } catch (IOException e) {
                System.err.format("IOException: %s%n", e);
            }

            double k = 0.3;
            double result = k*counter;

            System.out.println();

            for (int j = 0; j < 3; j++ ) {

                if (j == 1) {
                    k = 0.6;
                    result = k*counter;
                }

                if (j == 2) {
                    k = 0.9;
                    result = k*counter;
                }

                try (FileReader reader1 = new FileReader(file_name);
                     BufferedReader br1 = new BufferedReader(reader1)) {

                    String line1;
                    int num = 0;
                    while ((line1 = br1.readLine()) != null) {
                        num++;

                        if (num <= (int)result) {
                            str = str + line1 + "\\n";
                        }

                    }

                } catch (IOException e1) {

                    System.err.format("IOException: %s%n", e1);

                }

                try {

                    File file = new File(new_file_names[counter2]);
                    FileWriter fw = new FileWriter(file);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(str);
                    bw.close();

                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }

                str = "";
                counter2++;

            }

        }

    }

}