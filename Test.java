import  java.util.TreeMap;
import java.util.Map;

class Test{

  public static void main(String[] args) {

    Map<String, String> map = new TreeMap<String, String>();
    map.put("1", "Krupal");
    map.put("3", "Ankit");
    map.put("4", "Bhavesh");
    map.put("2", "Deepesh");
    map.put("2", "Tanvi");

    for (String id : map.keySet()) {
      System.out.println(id);
    }
    System.out.println(map.get("2"));
  }
}
