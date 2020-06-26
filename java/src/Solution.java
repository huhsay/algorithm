import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.*;

public class Solution {

    public static void main(String args[]) {

        List list = new ArrayList();


        HashMap<String, Integer> ex = new HashMap<>();
        TreeMap<String, Integer> ex1 = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
        ex.put("a", 1);
        ex.put("b", 1);
        ex.put("c", 2);
        ex.put("d", 3);

        System.out.println(ex.toString());

    }

    @Test
    public void solution1() {
        Date date = new Date();
        date.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "1992-05-11";

        try {
            System.out.println(sdf.parse(dateString).toString());
        } catch (Exception e) {
            e.getMessage();
        }
    }
}

