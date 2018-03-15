import java.Util.HashMap;

public class Node{
  int id;
  Node suffix_link;
  Node parent;
  String edge_label;
  HashMap<char, Node> children;
  int depth;

}
