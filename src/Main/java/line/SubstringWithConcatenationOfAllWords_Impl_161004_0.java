package line;

import org.junit.Test;

import java.util.*;


/**
 * Created by patrickyu on 10/4/16.
 * s: "barfoothefoobarman"
 * words: ["foo", "bar"]
 * <p>
 * You should return the indices: [0,9].
 * <p>
 * 这个虽然过了你目前的 test case, 原理也是没错的,但是 leetcode 上面超时了
 */
public class SubstringWithConcatenationOfAllWords_Impl_161004_0 implements SubstringWithConcatenationOfAllWords {


    @Override
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> rst = new ArrayList<>();

        Set<String> set = permuteUnique(words);
        int start = 0;
        int i = words[0].length() * words.length - 1;

        // num <= i < n
        for (; i < s.length(); i++) {
            if (set.contains(s.substring(start, i + 1))) {
                rst.add(start);
            }
            start++;
        }

        return rst;
    }


//    private Set<String> getWordsPermutation(String[] words) {
//        // i = 0;
//        Set<String> rstSet = new HashSet<>();
//
//        List<List<String>> rst = new LinkedList<>();
//        rst.add(new ArrayList<>(Arrays.asList(words[0])));
//
//
//        // i = 1; n-1
//        for (int i = 1; i < words.length; i++) {
//            int size = rst.size();
//            for (int j = 0; j < size; j++) {
//                List<String> list = rst.remove(0);
//                for (int k = 0; k < list.size(); k++) {
//                    List<String> listK = new ArrayList<>(list);
//                    listK.add(k, words[i]);
//                    rst.add(listK);
//                }
//                list.add(words[i]);
//                rst.add(list);
//            }
//        }
//
//        for (List<String> list : rst) {
//            StringBuilder sb = new StringBuilder();
//            for (String str : list) {
//                sb.append(str);
//            }
//            rstSet.add(sb.toString());
//        }
//        return rstSet;
//    }


    public Set<String> permuteUnique(String[] nums) {
        List<List<String>> rst = new ArrayList<>();


        Arrays.sort(nums);
        helper(rst, new ArrayList<>(), nums, new boolean[nums.length]);


        Set<String> rstSet = new HashSet<>();
        for (List<String> list : rst) {
            StringBuilder sb = new StringBuilder();
            for (String s : list) {
                sb.append(s);
            }
            rstSet.add(sb.toString());
        }

        return rstSet;
    }


    private void helper(List<List<String>> rst, List<String> path, String[] nums, boolean[] visited) {
        if (path.size() == nums.length) {
            rst.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || i > 0 && nums[i].equals(nums[i - 1]) && !visited[i - 1]) {
                continue;
            }

            visited[i] = true;
            path.add(nums[i]);
            helper(rst, path, nums, visited);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }

    @Test
    public void test() {
        String s = "barfoothefoobarman";
        String[] words = new String[]{"foo", "bar"};

//        System.out.println(findSubstring(s, words));
        System.out.println(permuteUnique(words));
    }
}
