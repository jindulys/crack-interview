public class MergeSort {
    private MergeSort() {

    }

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        // precondition: a[lo .. mid] and a[mid + 1 .. hi] are sorted subarrays.
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid+1, hi);

        // First copy it.
        for(int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        int i = lo;
        int j = mid+1;
        for(int k = lo; k<=hi; k++) {
            if (i > mid)                    a[k] = aux[j++];
            else if (j > hi)                a[k] = aux[i++];
            else if (less(aux[i], aux[j]))  a[k] = aux[i++];
            else                            a[k] = aux[j++];
        }

        assert isSorted(a, lo, hi);
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo)/2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid+1, hi);
        merge(a, aux, lo, mid, hi);
    }

    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length-1);
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
        MergeSort.sort(a);
        System.out.println(a[0] + " " + a[1] + " " + a[2] + " " + a[3]);
    }
}
