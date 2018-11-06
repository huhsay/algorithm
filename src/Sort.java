import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Sort {

    public static void SelectionSort(int[] a){
        for (int i = 0; i < a.length ; i++) {
            int minIndex = i;

            // 배열을 돌면서 가장 작은 값의 인덱스를 선택한다.
            for (int j = i+1; j < a.length; j++) {
                   if(a[minIndex] > a[j]){
                       minIndex = j;
                   }
            }
            // 선택된 인덱스와 기준 인덱스와 스와이프 한다.
            swap(a, i, minIndex);
        }
    }

    public static void bubbleSort(int[] a){
        for (int i = a.length-1; i >=0; i--) {
            for (int j = 0; j < i; j++) {
                if(a[j] > a[j+1]){
                    swap(a, j, i);
                }
            }
        }
    }

    public static void insertionSort(int[] a){
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            int j = i;
            while((j>0) && (a[j-1] > temp)){
                a[j] = a[j-1];
                j--;
            }
            a[j] = temp;
        }
    }

    public static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

class SortTest {

    @Test
    void selectionSort() {

        int[] a = {3, 2, 1};
        Arrays.stream(a).forEach((s) -> System.out.print(s));
        Sort.SelectionSort(a);
        Arrays.stream(a).forEach((s) -> System.out.print(s));
        System.out.println();
    }

    @Test
    void bubbleSort(){
        int[] a = {5, 4, 3, 2, 1};
        Arrays.stream(a).forEach((s) -> System.out.print(s));
        Sort.bubbleSort(a);
        Arrays.stream(a).forEach((s) -> System.out.print(s));
        System.out.println();
    }

    @Test
    void insertionSort(){
        int[] a = {6, 3, 5, 2, 1};
        Arrays.stream(a).forEach((s) -> System.out.print(s));
        Sort.insertionSort(a);
        Arrays.stream(a).forEach((s) -> System.out.print(s));
        System.out.println();
    }
}
