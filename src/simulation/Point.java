package simulation;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class Point {

    int x;
    int y;

    private static final Comparator<Point> COMPARATOR = Comparator.comparingInt((Point point) -> point.x).thenComparingInt(point -> point.y);

    public int compareTo(Point p){
            int result = Integer.compare(x, p.x);
            if(result==0){
                return Integer.compare(y, p.y);
            }
            return result;
    }
}

class StringNullCheck{

    @Test
    public void check(){
        String s=null;

        if(s.equals(null))
        System.out.println(true);
    }
}
