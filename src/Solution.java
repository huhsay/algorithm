import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Solution{
    public static List<String> streamEX(String[] input){

        return Arrays.stream(input).map( x -> { if (x.contains("s")){ return "x" ;}
        else{ return x;}}).collect(Collectors.toList());

        Boolean bool = new Boolean("true");
        String

    }

    @Test
    public void solution1(){
        Date date = new Date();
        date.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "1992-05-11";

        try {
            System.out.println(sdf.parse(dateString).toString());
        }catch(Exception e){
            e.getMessage();
        }
    }
}

