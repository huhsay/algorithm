package datastructure.hashing;

public class Program_contact {
    public boolean solution(String[] phone_book) {
        for (int i = 0; i < phone_book.length; i++) {
            String temp = phone_book[i];
            String target;
            for (int j = 0; j < phone_book.length; j++) {
                if( i == j ) continue;
                target = phone_book[j];

                if( target.length() < temp.length()) continue;
                if( target.substring(0, temp.length()).equals(temp) ){
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[] phone_book = { "101", "10"};
        Program_contact test = new Program_contact();
        System.out.println( test.solution(phone_book) );
    }
}
