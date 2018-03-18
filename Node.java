import java.util.TreeMap;

public class Node{
  int id;
  Node suffix_link;
  Node parent;
  int start;
  int end;
  TreeMap<Character, Node> children;
  int depth;
  int count;

  public Node(int id, Node parent, int start, int end, TreeMap<Character,Node> children, int depth){
    this.id = id;
    this.parent = parent;
    this.start = start;
    this.end = end;
    this.children = children;
    this.depth = depth;
    this.count++;
  }

}
