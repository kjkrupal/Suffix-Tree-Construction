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
      j = 0;
      if(node[j].children.get(sequence_array[i]) != null){
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

      int n = present.end - present.start;
      int p = present.start;

      while(n != 0){
        if(sequence_array[i] == sequence_array[p]){
          n--;
          p++;
        }
        if(mismatch){
          break at mismatch point
        }
        if(n == 0){
          check(if any hashmap (send parameters j and i=(i+length.edge_label)))
        }
      }

  }

}
