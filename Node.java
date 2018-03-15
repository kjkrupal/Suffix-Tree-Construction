import java.Util.HashMap;

public class Node{
  int id;
  Node suffix_link;
  Node parent;
  int start;
  int end;
  HashMap<char, Node> children;
  int depth;

  public Node(Node parent, int start, int end){
    id++;

    children = new HashMap<>()
  }

}
