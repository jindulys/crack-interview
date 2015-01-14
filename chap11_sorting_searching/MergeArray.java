public class MergeArray {
    private static boolean equalArray(int[] a, int[] b) {
        for(int i = 0; i < b.length; i++) {
            if (a[i] != b[i]) return false;
        }

        return true;
    }


    // Function merge a short array to a large array
    public static void mergeArray(int[] L, int[] S) {
        if (L == null || S == null) return;

        int[] Lcopy = new int[L.length];
        int LeffectLongth = 0;
        for(int i = 0; i < L.length; i++) {
            if (L[i] != 0) {
                Lcopy[i] = L[i];
            } else {
                LeffectLongth = i;
                break;
            }

        }

        int Sl = S.length;
        int i = 0;
        int j = 0;

        // correct index
        int k = 0;

        while(i < LeffectLongth && j < Sl) {
            if (Lcopy[i] < S[j]) {
                L[k] = Lcopy[i];
                i++;
            } else {
                L[k] = S[j];
                j++;
            }
            k++;
        }

        System.out.println("i is : " + i);
        System.out.println("j is : " + j);

        if (j == Sl) {
            // case 1: Short array reaches the end
            while(i < LeffectLongth) {
                L[k] = Lcopy[i];
                i++;
                k++;
            }
        } else {
            // case 2: Large array reaches the end
            while(j < Sl) {
                L[k] = S[j];
                j++;
                k++;
            }
        }
    }


    // Answer's solution
    public static void mergeArrayAns(int[] L, int[] S) {
        if (L == null || S == null) return;

        int LeffectLongth = 0;
        for(int i = 0; i < L.length; i++) {
            if (L[i] == 0) {
                LeffectLongth = i;
                break;
            }
        }

        int Sl = S.length;
        int i = LeffectLongth - 1;
        int j = Sl - 1;

        // correct index
        int k = LeffectLongth + Sl - 1;

        while( i >= 0 && j >= 0 ) {
            if (L[i] > S[j]) {
                L[k] = L[i];
                i--;
            } else {
                L[k] = S[j];
                j--;
            }
            k--;
        }

        while (j >= 0) {
            L[k] = S[j];
            j--;
            k--;
        }
    }

    public static void main(String[] args){
        int[] a = {1,6,8,16,18,19,20,21,0,0,0,0};
        int[] b = {3,9,17,33};

        int[] answer = {1,3,6,8,9,16,17,18,19,20,21,33};


        if (equalArray(a, answer)) {
            System.out.println("These two arrays are equal!");
        } else {
            System.out.println("These two arrays are different!");
        }

        mergeArrayAns(a, b);
        if (equalArray(a, answer)) {
            System.out.println("These two arrays are equal!");
        } else {
            System.out.println("These two arrays are different!");
        }
    }
}
