/*  Selection Sort
*
*
*/

import java.util.Comparator;

public class Selection {
    // This class should not be instantiated.
    private Selection() {}
    public static void sort(Comparable[] a) {
        int N = a.length;
        for(int i = 0; i < N; i++) {
            int min = i;
            for (int j = i+1; j < N; j++) {
                if(less(a[j], a[min])) min = j;
            }
            exch(a, i, min);
            assert isSorted(a, 0, i);
        }
        assert isSorted(a);
    }


    /**************************************
    * Helper Sorting Function
    ****************************************/
    // is a < b ?
    private static boolean less(Comparable a, Comparable b) {
        return (a.compareTo(b) < 0);
    }

    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    /**********************************************************
    * Check if array is sorted - useful for debuggin
    ***********************************************************/

    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for(int i = lo+1; i < hi; i++) {
            if(less(a[i],a[i-1])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] a = {"abract", "illuminate", "Grand", "Brant"};
        Selection.sort(a);
        System.out.println(a[0] + " " + a[1] + " " + a[2] + " " + a[3]);
    }
}
