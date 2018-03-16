public class SuffixTree{
  String sequence_name;
  String sequence;

  char[] sequence_array;
  char[] alphabet;

  int sequence_length;
  int alphabet_length;

  public SuffixTree(String sequence, String sequence_name, char[] alphabet){
    this.sequence_name = sequence_name;
    this.sequence = sequence + "$";
    this.sequence_length = sequence.length();
    this.sequence_array = this.sequence.toCharArray();
    this.alphabet = alphabet;
    this.alphabet_length = alphabet.length;
  }

  public void beginTreeConstructionProcess(){

    int i = 0; //checking sequence
    int j = 0; //for checking internal node
    int k = 0; //for keeping count of nodes
    Node node[] = new Node[2 * sequence_length - 1];
    Node node[k] = new Node(0, null, 0, 0, null, 0);
    k++;
    while(sequence_array[i] != '$'){
      if(root.children.get(sequence_array[i]) != null){
        findPath(node[j].children.get(sequence_array[i]), i);
      }
      else{
        node[k] = new Node(k, node[j], i, sequence_length, null, sequence_length - i);
      }

      /*if(check hashmap of node[j] and sequence_array[i]){
        call a function( for matching the children's edge_label of n[j] and sequence_array[i])
        else
        make a new node with with i as start n[j] as parent
      }*/

    public void findPath(Node present, int i){
        if(match){
        if(child is present){
          if( the length of edge label == n)
           make the edge
           else (Call function findpath( pass the node, edge_label of node +1))
        }
        }
        if(mismatch){
                  if( the child matches the key of the child present in the hashmap)
                  call findPath(current node and i)
                  else(create a new node which has the characters of string and his child as null
                        create a new node at the point of mismatch which will have children same as his parent
                        his parent's children will be updated with the point of mismatch till end and the new string mismatch point)
                  )
        }

      }

  }

}
