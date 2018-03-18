class traversal{
    Tree=Sort( children of each node; start with root)
    Print_Tree( print_tree node_children != Null)
      Print_Tree(print_Tree node_children ++ )

      and from top to leaf
        get the first character at each node and try spelling out the whole String
        (i.e. from the the position of that character in the sting -1 or position-1)
        print the character retrieved.

}

char BWT[] = new char[sequnce_length];
int k =0;
public static boolean DFS(Node, int k){

    if(node.children == NULL){
      int i= suffix_link of node;
      if (i>0){
        BWT[k++]=s[i-1];
      }
      else{
        BWT[k++]='$';
      }
    }
    else {
       return DFS(node.children, k);
   }
}
for(i=0;i<sequnce_length;i++)
{
  System.out.println(string[BWT[i]-1]);
}
