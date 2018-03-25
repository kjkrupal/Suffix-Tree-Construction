import java.util.TreeMap;
import java.util.ArrayList;

public class SuffixTree{
  String sequence_name;
  String sequence;

  int temp_id;
  int leaf_id;
  char[] string;
  char[] alphabet;
  int k = 0;
  int n;
  int alphabet_length;
  ArrayList <Integer> index = new ArrayList<Integer>();

  public SuffixTree(String sequence, String sequence_name, char[] alphabet){
    this.sequence_name = sequence_name;
    this.sequence = sequence + "$";
    this.n = this.sequence.length();
    this.string = this.sequence.toCharArray();
    this.alphabet = alphabet;
    this.alphabet_length = alphabet.length;
  }

  public void beginTreeConstructionProcess(){
    try{
      int i = 0;

      //Create root node with id 0 and everything set to null
      Node root = new Node(temp_id, null, -1, -1, null, 0, null);
      root.suffix_link = root;
      //Call GSL and initially pass root node and starting string pointer
      //System.out.println(root);
      //System.out.println("Root: " + root);
      //Call findPath initially to insert first suffix
      generalizedSuffixLink(root, i);
      /*
      //Begin iteration for string starting from 0 till n
      while(i != n + 1){

        //Leaf id for the i-th iteration
        leaf_id++;

        //Call nodeHop method, it will return the SL(u)
        //Node v = nodeHop()

        //Call findPath method with root as present node because this while-loop will always begin from root node
        findPath(root, i);

        //findPath creates node for i-th suffix, so increment i for next iteration
        i++;
      }
      */
      System.out.println(root.children);

      traverse(root, '$');

      for(int s : index){
        if(s == -1)
          System.out.println(string[n - 1]);
        else
          System.out.println(string[s]);
      }


      //System.out.println(root.children);

    }
    catch(Exception e){
      e.printStackTrace();
    }

  }

  public void traverse(Node node, char c){
    try{
      if(node.children == null){
        index.add(node.id - 2);
      }
      else{
        for(char ch : node.children.keySet()){
          //System.out.print(ch);
          traverse(node.children.get(ch), ch);
        }
      }
    }
    catch(Exception e){
        e.printStackTrace();
    }
  }
  public void findPath(Node present, int k, int alpha){
    try{

      int i = k + alpha;

      //Preserve the current index i in id
      int id = i;
        //System.out.println(i);
        //The following block executes when the present node doesn't have any children
        if(present.children == null){

          //Since no children create a new child
          present.children = new TreeMap<Character, Node>();

          leaf_id++;
          //Put key-value pair in the newly created TreeMap
          present.children.put(string[i], new Node(leaf_id, present, i, n - 1, null, present.depth + (n - i), null));

          k++;
          //Call generalizedSuffixLink to get suffix link of parent
          generalizedSuffixLink(present.children.get(string[i]), k);
        }

        /* The following block executes when the present node has a child but
        doesn't have a child corresponding to current character in the string */
        else if(present.children.get(string[i]) == null){

          //System.out.println(i);
          leaf_id ++;
          //Add a new child in the existing TreeMap
          present.children.put(string[i], new Node(leaf_id, present, i, n - 1, null, present.depth + (n - i), null));

          k++;
          //Call generalizedSuffixLink to get suffix link of parent
          generalizedSuffixLink(present.children.get(string[i]), k);
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

              temp_id++;
              //The following line creates a new internal node
              present.children.put(string[id], new Node(temp_id, present, child.start, start - 1, null,
                                                    present.depth + (start - child.start), null));


              //Get reference of newly created internal node
              Node new_internal_node = present.children.get(string[id]);

              //Update child_1's parent
              child_1.parent = new_internal_node;

              //Create a new TreeMap of children for internal node
              new_internal_node.children = new TreeMap<Character, Node>();

              //Put child_1 reference as child into newly created TreeMap
              new_internal_node.children.put(string[start], child_1);

              //Update the starting index of child_1

              child_1.start = start;

              leaf_id ++;
              //The following line creates a new leaf node
              new_internal_node.children.put(string[i], new Node(leaf_id, child_1.parent, i, n - 1, null, child_1.parent.depth + (n - i), null));

              k++;
              //Call generalizedSuffixLink to get suffix link of parent
              generalizedSuffixLink(new_internal_node.children.get(string[i]), k);

              break;
              //Get out of while loop
              //return true;

            }
          }
          /* The follwing will execute if the string is exhausted on the internal node. There are two cases that are possible
          1. There will be a child for the next character so go to that child node and repeat findPath process
          2. There will not be any child for the next character so simply create a child and finish */

          //The following will execute if there is no child with next character
          if(child.children.get(string[i]) == null){

            leaf_id++;
            //Create a new child of present node with string starting from next character
            child.children.put(string[i], new Node(leaf_id, present, i, n - 1, null, present.depth + (n - i), null));

            k++;
            //Call generalizedSuffixLink to get suffix link of parent
            generalizedSuffixLink(child.children.get(string[i]), k);

            //Get out of the function
            //return true;
          }
          //The following will execute if there is a child with next character

          else{

            //Recursively call the findPath function with updated parent and starting position
            findPath(present.children.get(string[id]), i, 0);
          }
        }

    }
    catch(Exception e){
      //e.printStackTrace();
    }
  }

  public boolean generalizedSuffixLink(Node leaf, int i){

    System.out.println(i);
    try{
      //Get parent of the current leaf node
      Node u = leaf.parent;

      if(i == n){
        return true;
      }
      else{
      //Initial case
      if(u == null){

        findPath(leaf, i, 0);
      }
      //Case 1-B, if the parent's parent is null, then the parent is a root node and root's SL is root itself
      else if(u.parent == null){

        //Call findPath with SL of parent (root (which is itself))
        findPath(u.suffix_link, i, 0);
      }
      else{
        //System.out.println(i);
        //Case 2, where suffix links are unknown, work with grand parents
        if(u.suffix_link == null){

          // Get grandparent u' which should have suffix_link
          Node u_prime = u.parent;
          int B_start = u.start;
          int B_end = u.end;

          //Get v' from u' as it exists
          //System.out.println("Line: 251, 0: " + u_prime);

          Node v_prime = u_prime.suffix_link;

          //Case 2A, check if grand parent is not root itself
          if(u_prime.parent != null){

            //Get alpha
            int alpha = u_prime.depth - 1;

            //System.out.println("Line: 261, 1: " + v_prime);
            //Nodehop on the v_prime node to get v

            Node v = nodeHop(v_prime, i, alpha, B_start, B_end);

            //Set suffix_link of u to v
            u.suffix_link = v;

            //System.out.println(" 267 " +u.suffix_link);

            //call findPath and pass v
            findPath(v, i, alpha);
          }
          //Case 2B, the grand parent is root itself
          else{
            //System.out.println(i);
            //To get beta prime
            B_start = B_start + 1;

            if(B_start > B_end){
              u.suffix_link = u_prime;

              findPath(u_prime, i, 0);
            }
            else{
              //System.out.println("Line: 281, 2: " + v_prime);
              //Nodehop on the v_prime node to get v
              int beta = u.depth - 1;
              //System.out.println(i);
              Node v = nodeHop(v_prime, i, beta, B_start, B_end);

              //Set suffix_link of u to v

              u.suffix_link = v;
              //System.out.println(" 291 " + u.suffix_link);

              //Get beta
              //System.out.println("Value of i " + i + " Value of beta " + beta);

              //Call findPath
              findPath(v, i, beta);
            }
          }
        }
        //Case 1A, the following block will execute if u has suffix link established
        else{
          //Get alpha
          int alpha = u.depth - 1;

          //Get suffix link of u
          Node v = u.suffix_link;
          //System.out.println("  309" +u.suffix_link);
          //call findPath with v
          findPath(v, i, alpha);
        }
      }
    }
    }
    catch(Exception e){
      e.printStackTrace();
    }
    return false;
  }

  public Node nodeHop(Node v_prime, int i, int alpha, int b_start, int b_end){

    try{
      //int k = i + alpha;
      //System.out.println("Line 322 " + b_start);

      Node child = v_prime.children.get(string[b_start]);
      //System.out.println(v_prime);
      int start = child.start;
      int end = child.end;

      /*if(b_end > child.end){
        nodeHop(child, i , alpha,b_start + (child.end - child.start) + 1 , b_end);
      }
      else if(b_end == child.end){
        return child;
      }
      else{
        while(b_start != b_end + 1){
          if(string[start] == string[b_start]){
            start++;
            b_start++;
          }
          else{
            Node child_1 = child;
            v_prime.children.put(string[child.start], new Node(temp_id, v_prime, child.start, start, null,
                                                               v_prime.depth + (start - child.start), null));
            Node v = v_prime.children.get(string[child.start]);

            child_1.parent = v;

            child_1.start = start + 1;

            v.children = new TreeMap<Character, Node>();

            v.children.put(string[child_1.start], child_1);

            return v;

          }
        }
      }*/
      if(child.end > b_end){

        Node child_1 = child;
        start = start + (b_end - b_start) +1;
        temp_id++;
        v_prime.children.put(string[child.start], new Node(temp_id, v_prime, child.start, b_end, null,
                                                           v_prime.depth + (b_end - child.start - 1), null));

        Node v = v_prime.children.get(string[child.start]);

        child_1.parent = v;

        child_1.start = b_end  + 1;

        v.children = new TreeMap<Character, Node>();

        v.children.put(string[child_1.start], child_1);

        return v;

      }
      else if(child.end == b_end){
        return child;
      }

      else{
        b_start = b_start + (child.end - child.start) + 1;
        return nodeHop(child, i, alpha, b_start, b_end);

      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}
