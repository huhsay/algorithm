package brutforce;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Programmers_mathLoser {
    public int[] solution(int[] answers) {
        int[][] peoples = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};

        int[] counts = new int[3];
        for (int i = 0; i < 3; i++) {
            counts[i] = countMatch(peoples[i], answers);
        }

        Stack<Student> stack = new Stack<>();
        int tempCount;
        for (int i = 0; i < 3; i++) {
            tempCount = counts[i];

            Student currentStudent;
            if(tempCount == 0) continue;
            if(stack.isEmpty()) {
                stack.add(new Student(i+1, tempCount));
            } else {
                currentStudent = stack.peek();
                if (currentStudent.count > tempCount){
                    continue;
                } else if (currentStudent.count == tempCount){
                    stack.add(new Student(i+1, tempCount));
                } else {
                    stack.clear();
                    stack.add(new Student(i+1, tempCount));
                }

            }

        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (Student student : stack) {
            arrayList.add(student.number);
        }

        int[] answer = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            answer[i] = arrayList.get(i);
        }

        return answer;
    }

    private int countMatch(int[] losers, int[] answers) {

        int count = 0;
        for (int i = 0; i < answers.length; i++) {
            if ( answers[i] == losers[i % losers.length] ) count++;
        }

        return count;
    }
}

class Student {
    int number;
    int count;

    public Student(int number, int count) {
        this.number = number;
        this.count = count;
    }
}