
import java.util.LinkedList;

public class SearchNode {
  public static void main(String[] args) {
    Graph g = createNewGraph();

    Graph.Node[] nodes = g.getNodes();
    Graph.Node start = nodes[2];
    Graph.Node end = nodes[5];
    System.out.println(search(g, start, end));
  }

  public static Graph createNewGraph() {
    Graph g = new Graph();
    Graph.Node[] temp = new Graph.Node[6];

    temp[0] = new Graph.Node("a", 3);
    temp[1] = new Graph.Node("b", 0);
    temp[2] = new Graph.Node("c", 0);
    temp[3] = new Graph.Node("d", 1);
    temp[4] = new Graph.Node("e", 1);
    temp[5] = new Graph.Node("f", 0);

    temp[0].addAdjacent(temp[1]);
    temp[0].addAdjacent(temp[2]);
    temp[0].addAdjacent(temp[3]);
    temp[3].addAdjacent(temp[4]);
    temp[4].addAdjacent(temp[5]);

    for(int i = 0; i < 6; i++) {
      g.addNode(temp[i]);
    }
    return g;
  }

  public static boolean search(Graph g, Graph.Node start, Graph.Node end) {
    LinkedList<Graph.Node> q = new LinkedList<Graph.Node>();
    Graph.Node[] ns = g.getNodes();
    for (Graph.Node n : ns) {
      if (n != null) {
        n.state = Graph.Node.State.Unvisited;
      }
    }


    start.state = Graph.Node.State.Visiting;
    q.add(start);
    Graph.Node n;
    while(!q.isEmpty()) {
      n = q.removeFirst();
      if (n != null) {
        for (Graph.Node u : n.getAdjacent()) {
          if (u.state == Graph.Node.State.Unvisited) {
            if (u == end) {
              return true;
            } else {
              u.state = Graph.Node.State.Visiting;
              q.add(u);
            }
          }
        }

        n.state = Graph.Node.State.Visited;
      }
    }
    return false;
  }
}
