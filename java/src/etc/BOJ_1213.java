package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1213 {

    static int[] alphabet = new int[26];
    static int index = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] name = br.readLine().toCharArray();

        for (int i = 0; i < name.length; i++) {
            int index = name[i] - 65;
            alphabet[index]++;
        }

        if (name.length % 2 == 0) {
            if (checkAlphabet(alphabet) != 0) {
                System.out.println("I'm Sorry Hansoo");
                return;
            }

            for (int i = 0; i < name.length / 2; i++) {

                for (int j = 0; j < 26; j++) {
                    if (alphabet[j] != 0 && alphabet[j] % 2 == 0) {
                        name[i] = name[name.length - 1 - i] = (char) (j + 65);
                        alphabet[j] = alphabet[j] - 2;
                        break;
                    }
                }
            }


        } else {
            if (checkAlphabet(alphabet) != 1) {
                System.out.println("I'm Sorry Hansoo");
                return;
            }

            int index = 0;
            for (int i = 0; i < 26; i++) {
                if (alphabet[i] % 2 != 0) index = i;
            }

            name[(name.length - 1) / 2] = (char) (index + 65);
            alphabet[index]--;

            for (int i = 0; i < (name.length - 1) / 2; i++) {
                for (int j = 0; j < 26; j++) {
                    if (alphabet[j] != 0 && alphabet[j] % 2 == 0) {
                        name[i] = name[name.length - 1 - i] = (char) (j + 65);
                        alphabet[j] = alphabet[j] - 2;
                        break;
                    }
                }
            }


        }

        for (int i = 0; i < name.length; i++) {

            System.out.print(name[i]);
        }


    }

    public static int checkAlphabet(int[] alphabet) {
        int count = 0;
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] % 2 == 1) count++;
        }
        return count;
    }
}
