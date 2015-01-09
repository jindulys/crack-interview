public class Graph {
  private Node[] vertices;
  public int count;

  public Graph() {
    vertices = new Node[30];
    count = 0;
  }

  public void addNode(Node n) {
    if (count < 30) {
      vertices[count] = n;
      count++;
    } else {
      System.out.println("The Graph is Full");
    }
  }

  public Node[] getNodes() {
    return vertices;
  }


  public static class Node {
    public static enum State {
      Unvisited, Visited, Visiting;
    }

    private Node[] adjacent;
    private String vertex;
    public int adjacentCount;
    public State state;

    public Node(String vertex, int adjacentLength) {
      this.vertex = vertex;
      adjacent = new Node[adjacentLength];
      adjacentCount = 0;
    }

    public void addAdjacent(Node x) {
      if (adjacentCount < 30) {
        adjacent[adjacentCount] = x;
        adjacentCount++;
      } else {
        System.out.print("No more adjacent can be added");
      }
    }

    public String getVertex() {
      return vertex;
    }

    public Node[] getAdjacent() {
      return adjacent;
    }
  }
}
