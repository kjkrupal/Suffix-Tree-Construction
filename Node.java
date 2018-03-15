import java.Util.HashMap;

public class Node{
  int id;
  Node suffix_link;
  Node parent;
  int start;
  int end;
  HashMap<char, Node> children;
  int depth;

public Node(int id, Node parent,String edge_label,HashMap<char,Node> children,int depth){
  this.id=id;
  this.parent=parent;
  this.edge_label=edge_label;
  this.children=children;
  this.depth=depth;
}

}

/*while(s[i]!="$"){
  j=0
  if(#check hash map of j=0 and i=0){
    #call a function for checking
  }
  else{
    #make a new node and update hashtable
  }
}
Checking*/
