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

      //Call findPath method with root as present node because this while-loop will always begin from root node
      findPath(root, i);

      //findPath creates node for i-th suffix, so increment i for next iteration
      i++;
    }

  }

  public boolean findPath(Node present, int i){

    int id = i;

    //The following block executes when the present node doesn't have any children
    if(present.children == null){

      //Since no children create a new child
      present.children = new TreeMap<char, Node>();

      //Put key-value pair in the newly created TreeMap
      present.children.put(string[i], new Node(i + 1, present, i, n, null, n - i));
    }

    /* The following block executes when the present node has a child but
    doesn't have a child corresponding to current character in the string */

    else if(present.children.get(string[i]) == null){

      //Add a new child in the existing TreeMap
      present.children.put(string[i], new Node(i + 1, present, i, n, null, n - i));
    }
    //The following block executes if the present node has a child corresponding to the character
    else{
      //Get the child node from the parent corresponding to character
      Node child = present.children.get(string[i]);

      //Store child node's start and end index into temporary variables
      int start = child.start;
      int end = child.end;

      //Begin match-mismatch process
      while(start != end + 1){

        //If match then continue matching until mismatch
        if(string[start] == string[i]){
          start++;
          i++;
        }
        //If mismatch then create a two new nodes
        else{
          /*Since now we have to create an internal node between the present node and it's child,
          the following line will get the refernce of present node's child so that it can be used to
          update the values present node's child according to the newly added internal node */
          Node child_1 = present.children.get(string[id]);

          //The following line creates a new internal node
          present.children.put(string[id], new Node(id, present, child.start, start - 1, null,
                                                    present.depth + (child.start - start)));

          //Get reference of newly created internal node
          Node new_internal_node = present.children.get(string[id]);

          //Update child_1's parent
          child_1.parent = new_internal_node;

          //Create a new TreeMap of children for internal node
          new_internal_node.children = new TreeMap<char, Node>();

          //Put child_1 reference as child into newly created TreeMap
          new_internal_node.children.put(string[start], child_1);

          //Update the starting index of child_1
          child_1.start = start;

          //The following line creates a new leaf node
          new_internal_node.children.put(string[i], new Node(i, chaild_1.parent, i, n, null, n-i));

          //Get out of while loop
          return true;

        }

      }
      /* The follwing will execute if the string is exhausted on the internal node. There are two cases that are possible
      1. There will be a child for the next character so go to that child node and repeat findPath process
      2. There will not be any child for the next character so simply create a child and finish */

      //The following will execute if there is no child with next character
      if(present.children.get(string[i]) == null){

        //Create a new child of present node with string starting from next character
        present.children.put(string[i], new Node(i, present, i, n, null, present.depth + (n - i + 1)));

        //Get out of the function
        return true;
      }
      //The following will execute if there is a child with next character
      else{

        //rRecursively call the findPath function with updated parent and starting position
        findPath(present.children.get(string[i]), i)
      }


    }

  }
}
