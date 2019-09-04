package P1;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        HashMap<String,String> map1 = new HashMap<String, String>();
        map1.put("Smith", "1");
        map1.put("Marty", "2");
        HashMap<String,String> map2 = new HashMap<String, String>();
        map2.put("Marty", "2");
        map2.put("Newton", "3");
        map2.put("Hawking", "4");
        map2.put("Smith", "1");

        HashMap<String,String> map3 = new HashMap<String, String>();
        System.out.println(subMap(map1, map2));
        System.out.println(subMap(map3, map2));
    }

    public static boolean subMap(HashMap<String,String> map1, HashMap<String,String> map2){
        if(map1.isEmpty()) return true;
        for(String key : map1.keySet()){
            if(!map2.containsKey(key)){
                return false;
            }
            else if(!map1.get(key).equals(map2.get(key))) return false;
        }
        return true;
    }

}
