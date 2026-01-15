package code;

import java.util.HashMap;

public class CountUniqueCharacter {
    
    public HashMap<Character, Integer> countUniqueCharacter(String str){
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if (map.containsKey(c)){
                map.put(c, map.get(c)+1);
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }
}
