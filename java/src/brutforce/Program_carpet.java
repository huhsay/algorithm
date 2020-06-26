package brutforce;

public class Program_carpet {

    public int[] solution(int brown, int red) {
        int[] answer = new int[2];
        int test = (brown + 4) / 2;

        int y;
        for (int x = 3; x < test; x++) {

            y = test - x;

            if( x*y == brown + red){

                if( x > y){
                    answer[0] = x;
                    answer[1] = y;
                } else {

                    answer[0] = y;
                    answer[1] = x;
                }

            }


        }
        return answer;
    }
}
