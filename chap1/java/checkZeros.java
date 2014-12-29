class checkZeros{


  /* Helper Function Print Matrix array
  */
  public static void printMatrix(int[][] mt){
    if (mt == null && mt.length == 0){
      return;
    }
    int rows = mt.length;
    int cols = mt[0].length;
    for (int i = 0; i<rows; i++){
      String line = "";
      for (int j=0; j<cols; j++){
        char[] currentLine = new char[] {' ',' ',' ',' ',' '};
        String strCount = String.valueOf(mt[i][j]);
        int countLen = strCount.length();
        for(int m = 0; m< countLen; m++){
          currentLine[4 - m] = strCount.charAt(countLen - m - 1);
        }
        String result = new String(currentLine);
        line = line + result + " ";
      }
      System.out.println(line);
    }
    System.out.println();
  }



  public static void replaceMatrixWithZero(int[][] mat){
    boolean[] rowFlag = new boolean[mat.length];
    boolean[] colFlag = new boolean[mat[0].length];
    for(int i = 0; i< mat.length; i++){
      for(int j= 0; j< mat[0].length; j++){
        if (mat[i][j] == 0){
          rowFlag[i] = true;
          colFlag[j] = true;
        }
      }
    }

    for(int i = 0; i< mat.length; i++){
      for(int j=0; j < mat[0].length; j++){
        if (rowFlag[i] || colFlag[j]){
          mat[i][j] = 0;
        }
      }
    }
  }

  public static void main(String[] args){
    int[][] mt =new int[][] {{2,3,0,6,9},{4,0,1,16,19},{89,90,19,101,219}};
    printMatrix(mt);
    replaceMatrixWithZero(mt);
    printMatrix(mt);
  }
}
