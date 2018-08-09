import java.util.*;

public class BOJ_10755 {
    static long M; // 컴퓨터 개수
    static long N; // 이미 와있는 사람 - 이미와있는 사람중에 친구가 있을 수도 있다.
    static int Q; // 칭구

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        M = sc.nextLong();
        N = sc.nextLong();
        Q = sc.nextInt();

        Queue<Student> students = new PriorityQueue<Student>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Long.compare(o1.num, o2.num);
            }
        });

        Queue<Student> temp = new PriorityQueue<Student>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Long.compare(o1.location, o2.location);
            }
        });

        Queue<EmptySpace> emptySpaces = new PriorityQueue<>(new Comparator<EmptySpace>() {
            @Override
            public int compare(EmptySpace o1, EmptySpace o2) {

                if( o1.size < o2.size){
                    return 1;
                }else if( o1.size > o2.size){
                    return -1;
                }else{

                    if(o1.startLocation<o2.startLocation){
                        return -1;
                    }if(o1.startLocation>o2.startLocation){
                        return 1;
                    }
                    return 0;
                }
            }
        });

        for (long i=1 ; i<=N ; i++){
            Student studentTemp = new Student(i, sc.nextLong());
            temp.add(studentTemp);
            students.add(studentTemp);
        }
        temp.add(new Student(0,M+1));

        Student pre= new Student (0, 0);
        Student current;

        while(!temp.isEmpty()){
            current = temp.remove();
            emptySpaces.add(new EmptySpace(pre.location+1, current.location));
            pre = current;
        }

        for(long i=N+1; i<=M; i++){
            EmptySpace max = emptySpaces.remove();

            long newLocation = (max.startLocation+max.endLocation)/2;
            students.add(new Student(i, newLocation));

            emptySpaces.add(new EmptySpace(max.startLocation, newLocation));
            emptySpaces.add(new EmptySpace(newLocation+1, max.endLocation));
        }

    }

    static class Student{
        long num;
        long location;

        public Student(long num, long location) {
            this.num = num;
            this.location = location;
        }
    }

    static class EmptySpace{
        long startLocation;
        long endLocation;
        int size;

        public EmptySpace(long startLocation, long endLocation) {
            this.startLocation = startLocation;
            this.endLocation = endLocation;
            this.size = (int)(endLocation-startLocation);
        }
    }

}
