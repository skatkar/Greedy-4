import java.util.HashMap;
import java.util.Map;

public class ShortestWay {
    // TC : O(m * n)
    // SC : O(1)
    public int shortestWay(String source, String target) {
        if(source == null || source.length() == 0) return 0;

        // This will help us if we encounter a character in target which is not there in source
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i < source.length();i ++) {
            char c = source.charAt(i);
            map.put(c, i);
        }
        int i=0; // pointer in target
        int pos=0; // pointer in source
        int tl = target.length();
        int sl = source.length();
        int result = 1; //assuming there will be at least 1 subsequence

        while(i < tl) {
            char c = target.charAt(i);
            if(!map.containsKey(c)) return -1;

            if(source.charAt(pos) == c) {
                i++;
            }
            pos++;

            if(i < tl && pos == sl) {
                result++;
            }
        }

        return result;
    }
}
