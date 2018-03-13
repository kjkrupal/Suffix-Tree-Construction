class Node{
  char data;
  Node parent;
  Node child[][] = new char[sigma+1][2];
}
public class Node insert_node(char x){
if(x == null || input.size() == 0){
              throw new IllegalArgumentException("Input is null or doesn't contain any elements");
          }

}
void setparent(Node n,Node previous){
  n.parent=previous;
}
void setchild(Node n,char data,int position,int length){
  while(lenght!=0){
    if(n.data==child[length][0]){
      if(child[length][1]==0){
        child[length][1]=1;
      }
    }
  }
  n.child[position]=data;
}
void setparent(Node previous){
  this.setparent=previous;
  if(n!=null)
  n.parent=this;
}
void next_node(Node next){
  this.next_node=next;
  if(next!=null)
  next.child[]=this;
}
