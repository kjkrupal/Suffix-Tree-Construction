public class Sequence{
  String sequence_name;
  String sequence;

  char[] sequence_array;
  char[] alphabet;

  int sequence_length;
  int alphabet_length;

  Sequence(String sequence, String sequence_name, char[] alphabet){
    this.sequence_name = sequence_name;
    this.sequence = sequence + "$";
    this.sequence_length = sequence.length();
    this.sequence_array = this.sequence.toCharArray();
    this.alphabet = alphabet;
    this.alphabet_length = alphabet.length;
  }
}
