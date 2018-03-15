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

    int i = 0;
    int j = 0;

    Node root = new Node(0, null, );

    while(sequence_array[i] != '$'){

    }

  }

}
