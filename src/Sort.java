import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Sort {

    public static void SelectionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int minIndex = i;

            // 배열을 돌면서 가장 작은 값의 인덱스를 선택한다.
            for (int j = i + 1; j < a.length; j++) {
                if (a[minIndex] > a[j]) {
                    minIndex = j;
                }
            }
            // 선택된 인덱스와 기준 인덱스와 스와이프 한다.
            swap(a, i, minIndex);
        }
    }

    public static void bubbleSort(int[] a) {
        for (int i = a.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, i);
                }
            }
        }
    }

    public static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            int j = i;
            while ((j > 0) && (a[j - 1] > temp)) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = temp;
        }
    }

    public static List<Integer> insertionSort(final List<Integer> numbers){
        final List<Integer> sortedList = new LinkedList<>();

        originalList:
        for (Integer number: numbers) {
            for (int i = 0; i < sortedList.size(); i++) {
                if(number < sortedList.get(i)){
                    sortedList.add(i, number);
                    continue originalList;
                }
            }
            sortedList.add(sortedList.size(), number);
        }

        return sortedList;
    }

    public static void quickSort(int[] a, int leftIndex, int rightIndex) {

        if (leftIndex < rightIndex) {
            int pivot = partition(a, leftIndex, rightIndex);
            quickSort(a, leftIndex, pivot - 1);
            quickSort(a, pivot + 1, rightIndex);
        }
    }

    public static List<Integer> quickSort(List<Integer> numbers){
        if(numbers.size() < 2){
            return numbers;
        }

        final Integer pivot = numbers.get(0);
        final List<Integer> lower = new ArrayList<>();
        final List<Integer> higher = new ArrayList<>();

        for (int i = 1; i < numbers.size(); i++) {
            if(numbers.get(i) < pivot) {
                lower.add(numbers.get(i));
            }else{
                higher.add(numbers.get(i));
            }
        }

        final List<Integer> sorted = quickSort(lower);
        sorted.add(pivot);
        sorted.addAll(quickSort(higher));

        return sorted;
    }

    private static int partition(int[] a, int leftIndex, int rightIndex) {
        int pivot, temp, L, R;
        L = leftIndex;
        R = rightIndex;
        pivot = (leftIndex + rightIndex) / 2;

        while (L < R) {
            while (a[L] <= a[pivot] && L <= R) L++;
            while (a[R] > a[pivot] && L <= R) R--;

            if (L <= R) {
                swap(a, L, R);
                if (R == pivot) return L;
            }
        }

        swap(a, pivot, R);
        return R;
    }

    public static void mergeSort(int[] a, int left, int right) {
        int mid;
        if (left < right) {
            mid = (left + right) / 2;
            mergeSort(a, left, mid);
            mergeSort(a, mid + 1, right);
            merge(a, left, mid, right);
        }
    }

    private static void merge(int[] a, int left, int mid, int right) {
        int[] sorted = new int[a.length];
        int l = left;
        int r = mid + 1;

        int index = left;

        while (l <= mid && r <= right) {
            if (a[l] < a[r]) {
                sorted[index] = a[l];
                l++;
            } else {
                sorted[index] = a[r];
                r++;
            }
            index++;
        }
        if (l > mid) {
            for (int i = r; i <= right; i++, index++) {
                sorted[index] = a[i];
            }
        }else{
            for (int i = l; i <= mid ; i++, index++) {
                sorted[index] = a[i];
            }
        }

        for (int i = left; i <= right; i++) {
            a[i] = sorted[i];
        }

    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static boolean binarySearch(final List<Integer> numbers, final Integer value){
        if( numbers == null || numbers.isEmpty()){
            return false;
        }

        final Integer comparison = numbers.get(numbers.size()/2);
        if(value.equals(comparison)){
            return true;
        }

        if( value < comparison){
            return binarySearch(numbers.subList(0, numbers.size()/2), value);
        }else{
            return binarySearch(numbers.subList(numbers.size()/2+1, numbers.size()), value);
        }
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
    void bubbleSort() {
        int[] a = {5, 4, 3, 2, 1};
        Arrays.stream(a).forEach((s) -> System.out.print(s));
        Sort.bubbleSort(a);
        Arrays.stream(a).forEach((s) -> System.out.print(s));
        System.out.println();
    }

    @Test
    void insertionSort() {
        int[] a = {6, 3, 5, 2, 1};
        Arrays.stream(a).forEach((s) -> System.out.print(s));
        Sort.insertionSort(a);
        Arrays.stream(a).forEach((s) -> System.out.print(s));
        System.out.println();
    }

    @Test
    void quickSort() {
        int[] a = {3, 4, 5, 6, 1};
        Arrays.stream(a).forEach((s) -> System.out.print(s));
        Sort.quickSort(a, 0, 4);
        Arrays.stream(a).forEach((s) -> System.out.print(s));
        System.out.println();
    }

    @Test
    void mergeSort() {
        int[] a = {4, 5, 6, 9, 1, 3};
        Arrays.stream(a).forEach((s) -> System.out.print(s));
        Sort.mergeSort(a, 0, 5);
        Arrays.stream(a).forEach((s) -> System.out.print(s));
    }
}
