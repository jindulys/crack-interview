public class QuickSort {
    private QuickSort() {}

    public static void sort(Comparable[] a) {
        sort(a, 0, a.length-1);
        assert isSorted(a);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        // Base Case
        if (lo >= hi) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
        assert isSorted(a);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int v = lo;
        int i = lo;
        int j = hi + 1;
        while (true) {
            while (less(a[++i], a[v])) {
                // Take care of left point out of bound
                if (i == hi) break;
            }

            while (less(a[v], a[--j])) {
                // Take care of right point reach left
                if (j == lo) break;
            }

            // First we should check whether we reach cross point.
            // i > j : because
            if (i >= j) break;
            exch(a, i, j);
        }

        // we should exchange j because j th element is the smaller one.
        exch(a, v, j);
        return j;
    }

    private static void exch(Object[] a, int l1, int l2) {
        Object tmp = a[l1];
        a[l1] = a[l2];
        a[l2] = tmp;
    }

    private static boolean less(Comparable o1, Comparable o2) {
        return (o1.compareTo(o2) < 0);
    }

    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for(int i = lo+1; i <= hi; i++) {
            if (less(a[lo], a[lo - 1])) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String[] a = {"abract", "illuminate", "Grand", "Brant"};
        QuickSort.sort(a);
        System.out.println(a[0] + " " + a[1] + " " + a[2] + " " + a[3]);
    }
}
