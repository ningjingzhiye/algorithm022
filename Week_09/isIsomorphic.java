import java.util.HashMap;
import java.util.Map;

public class Solution {

    //使用HashMap
    public boolean isIsomorphic(String s, String t) {
        if (s == null && t == null) {
            return true;
        } else if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> s2t = new HashMap<>();
        Map<Character, Character> t2s = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char s1 = s.charAt(i);
            char t1 = t.charAt(i);
            if ((s2t.containsKey(s1) && s2t.get(s1) != t1) || (t2s.containsKey(t1) && t2s.get(t1) != s1)) {
                return false;
            }
            s2t.put(s1, t1);
            t2s.put(t1, s1);
        }
        return true;
    }

    //使用数组，运行更快
    public boolean isIsomorphic2(String s, String t) {
        if (s == null && t == null) {
            return true;
        } else if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] s2t = new int[256];
        int[] t2s = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char s1 = s.charAt(i);
            char t1 = t.charAt(i);
            if (s2t[s1] != t2s[t1]) {
                return false;
            }
            s2t[s1] = i + 1;
            t2s[t1] = i + 1;
        }
        return true;
    }

}
