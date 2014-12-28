class Rotation{
  public static void rotate(int[][] matrix, int n){
    // Perform it layer by layer.
    for(int layer = 0; layer < n/2; layer++){
      int first = layer;
      // notice when we rotate the first element will be some array's last elment so if we start
      // from begining we could safely get the last, then we just stop at the second last element.
      int last = n - 1 - layer;
      for(int pos = first; pos < last; pos++){
        int offset = pos - first;
        // save the top
        int top = matrix[first][pos];
        // exchange left with top
        matrix[first][offset] = matrix[last - offset][first];
        // exchange bottom with left
        matrix[last - offset] = matrix[last][last - offset];
        // exchange right with bottom
        matrix[last][last - offset] = matrix[pos][last];
        // exchange top with right
        matrix[pos][last] = top;
      }
    }
  }
}
