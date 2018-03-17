import java.Util.HashMap;

public class Node{
  int id;
  Node suffix_link;
  Node parent;
  int start;
  int end;
  HashMap<char, Node> children;
  int depth;

  public Node(int id, Node parent, int start, int end, HashMap<char,Node> children, int depth){
    this.id = id;
    this.parent = parent;
    this.start = start;
    this.end = end;
    this.children = children;
    this.depth = depth;
  }

}
