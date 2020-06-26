package test.kakao2019blind;

import org.junit.Test;

import java.util.*;

public class solution1 {

    private Map<String, String> nick = new HashMap<>();
    private List<String> answerList = new LinkedList<>();

    public String[] solution(String[] record) {


        for (int i = 0; i < record.length; i++) {
            split(record[i]);
        }

        for (int i = 0; i < record.length; i++) {
            makeSentence(record[i]);
        }

        String[] answer = answerList.toArray(new String[answerList.size()]);


        return answer;
    }

    private void split(String record) {
        String[] oper = record.split(" ");

        switch (oper[0]) {
            case "Enter":
                nick.put(oper[1], oper[2]);
                break;
            case "Change":
                nick.put(oper[1], oper[2]);
                break;
            default:
                break;

        }
    }

    private void makeSentence(String record) {
        String[] oper = record.split(" ");

        switch (oper[0]) {
            case "Enter":
                answerList.add(String.format("%s님이 들어왔습니다.", nick.get(oper[1])));
                break;
            case "Leave":
                answerList.add(String.format("%s님이 나갔습니다.", nick.get(oper[1])));
                break;
            default:
                break;

        }
    }

    @Test
    public void hello(){
        String[] string = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        solution1 s = new solution1();
        System.out.println(s.solution(string)[1]);
    }
}
