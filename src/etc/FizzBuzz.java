package etc;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    public static List<String> alternativeFizzBuzz(final int n){
        final List<String> toReturn = new ArrayList<>(n);
        for (int i = 1; i <= n ; i++) {
            final String word = toWord(3, i, "Fizz") + toWord(5, i, "Buzz");

            if(StringUtils.isBlank(word)){
                toReturn.add(Integer.toString(i));
            }else{
                toReturn.add(word);
            }
        }
        return toReturn;
    }

    private static String toWord(int diviwor, int value, String word) {
        return value % diviwor == 0 ? word : "";
    }
}

class test{
    @Test
    public void test(){
        System.out.println(StringUtils.isBlank(""));
        System.out.println(FizzBuzz.alternativeFizzBuzz(15));
    }
}
