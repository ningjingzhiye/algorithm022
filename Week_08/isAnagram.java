public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) {
            return true;
        } else if (s == null || t == null) {
            return false;
        } else if (s.length() != t.length()) {
            return false;
        }
        int[] tmp = new int[26];
        for (int i = 0; i < s.length(); i++) {
            tmp[s.charAt(i) - 'a']++;
            tmp[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (tmp[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
