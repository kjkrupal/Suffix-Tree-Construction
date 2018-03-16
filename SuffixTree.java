public class SuffixTree{
  String sequence_name;
  String sequence;

  char[] string;
  char[] alphabet;

  int n;
  int alphabet_length;

  public SuffixTree(String sequence, String sequence_name, char[] alphabet){
    this.sequence_name = sequence_name;
    this.sequence = sequence + "$";
    this.n = sequence.length();
    this.string = this.sequence.toCharArray();
    this.alphabet = alphabet;
    this.alphabet_length = alphabet.length;
  }

  public void beginTreeConstructionProcess(){

    int i = 0;

    //Create root node with id 0 and everything set to null
    Node root = new Node(0, null, -1, -1, null, 0);

    //Begin iteration for string starting from 0 till n
    while(string[i] != '$'){

      //Call findPath method with root as present node because this while will always begin from root node
      findPath(root, i);

      //findPath creates node for i-th suffix, so increment i for next iteration
      i++;
    }

  }

  public void findPath(Node present, int i){

    //The following block executes when the present node doesn't have any children
    if(present.children == null){

      //Since no children create a new child
      present.children = new HashMap<char, Node>();

      //Put key-value pair in the newly created HashMap
      present.children.put(string[i], new Node(i + 1, present, i, n, null, n - i));
    }

    /* The following block executes when the present node has a child but
    doesn't have a child corresponding to current character in the string */

    else if(present.children.get(string[i]) == null){

      //Add a new child in the existing HashMap
      present.children.put(string[i], new Node(i + 1, present, i, n, null, n - i))
    }

  }
}
