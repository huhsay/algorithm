package heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {

    public static void main(String args[]) throws IOException {
        int N;
        LinkedList<Character> stringList;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());

        for (int n = 0; n < N; n++) {
            boolean first = true;
            stringList = new LinkedList<Character>();
            stringList.add('a');
            String textCase = br.readLine();
            ListIterator iter = stringList.listIterator(stringList.size());

            for (int i = 0; i < textCase.length(); i++) {
                char tempChar = textCase.charAt(i);
                switch (tempChar) {
                    case '<':

                        if (iter.nextIndex() != 1) {
                            if (iter.hasPrevious())
                                iter.previous();
                        }

                        break;
                    case '>':
                        if (iter.hasNext()) {
                            iter.next();
                        }

                        break;
                    case '-':


                        if (iter.nextIndex() != 1) {
                            iter.previous();
                            iter.remove();
                        }

                        break;
                    default:
                        iter.add(tempChar);
                        if (first) {
                            first = false;
                        }
                }
            }
            stringList.remove();

            StringBuilder sb = new StringBuilder();

            while (!stringList.isEmpty()) {
                sb.append(stringList.remove());
            }

            System.out.print(sb);

        }
    }
}
