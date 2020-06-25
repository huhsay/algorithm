package test.naver;

public class Solution1 {
    public int solution(String[] emails) {
        int answer = 0;

        for (int i = 0; i < emails.length; i++) {
            String email = emails[i];
            boolean at = false;
            for (int j = 0; j < email.length(); j++) {
                char temp = email.charAt(j);
                if (temp == '@') {
                    at = true;
                }
                if (temp == '.') {
                    if (at) {
                        answer++;
                    }
                }
            }
        }


        return answer;
    }

    public int solution2(String[] emails) {
        int answer = 0;

        for (int i = 0; i < emails.length; i++) {
            String[] email = emails[i].split("@");

            if (email.length == 2) {
                if (email[0].length() == 0) continue;

                String domain = email[1];
                String[] domains = domain.split("\\.");

                if (domains.length == 2) {
                    String top = domains[1];

                    if (top.equals("com") || top.equals("net") || top.equals("org")) {
                        answer++;
                    }
                }


            }
        }


        return answer;
    }

    public static void main(String[] args) {

        String[] emails = {"@x.com"};
        Solution1 test = new Solution1();
        System.out.println(test.solution2(emails));
    }
}
