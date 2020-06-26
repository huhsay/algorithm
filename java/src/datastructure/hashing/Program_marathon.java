package datastructure.hashing;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Program_marathon {

    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> temp = new HashMap<>();

        String people;
        for (int i = 0; i < participant.length; i++) {
            people = participant[i];
            if (temp.containsKey(people)) {
                temp.put(people, temp.get(people) + 1);
            } else {
                temp.put(people, 1);
            }
        }

        for (int i = 0; i < completion.length; i++) {
            people = completion[i];

            if ( temp.get(people) == 1 ) {
                temp.remove(people);
            } else {
                temp.put(people, temp.get(people)-1);
            }
        }

        Iterator<String> answer = temp.keySet().iterator();

        return answer.next();
    }

    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        Program_marathon program_marathon = new Program_marathon();
        System.out.println(program_marathon.solution(participant, completion));

    }
}
