import java.util.*;

public class ShortestWay {
    // Linear search
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

    // TC : O(m* log n) m- length of target string, n-length of source string
    // SC : O(1)
    public int shortestWay_binarySearch(String source, String target) {
        if(source == null || source.length() == 0) return 0;

        // This will help us if we encounter a character in target which is not there in source
        Map<Character, List<Integer>> map = new HashMap<>();
        for(int i=0; i < source.length();i ++) {
            char c = source.charAt(i);
            if(!map.containsKey(c)) map.put(c, new ArrayList<>());
            map.get(c).add(i);
        }

        int i=0; // pointer in target
        int pos=0; // pointer in source
        int tl = target.length();
        int sl = source.length();
        int result = 1; //assuming there will be at least 1 subsequence

        while(i < tl) {
            char c = target.charAt(i);
            if(!map.containsKey(c)) return -1;

            List<Integer> list = map.get(c);
            int k = Collections.binarySearch(list, pos);

            if(k < 0) k = -k-1;
            if(k < list.size()){
                pos = 0;
                result++;
            }else {
                pos = list.get(k) + 1;
                i++;
            }
        }
        return result;
    }
}
