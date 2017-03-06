package tree;

import org.junit.Test;

import java.util.*;

/**
 * Created by patrickyu on 10/20/16.
 */
public class WordBreakII_Impl_161020_1 implements WordBreakII {
    @Override
    public List<String> wordBreak(String s, Set<String> wordDict) {

        List<String> rst = new ArrayList<>();


        int maxWordLen = 0;

        for (String str : wordDict) {
            maxWordLen = Math.max(maxWordLen, str.length());
        }

        for (int end = 0; end < maxWordLen; end++) {
            if (end >= s.length()) {
                break;
            }

            if (!wordDict.contains(s.substring(0, end + 1))) {
                continue;
            }


            List<StringBuilder> rstChild = helper(0, end, s, wordDict, maxWordLen);

            for (StringBuilder child : rstChild) {

                rst.add(child.reverse().toString());
            }
        }

        return rst;
    }


    private List<StringBuilder> helper(int start, int end, String s, Set<String> wordDict, int maxWordLen) {

        List<StringBuilder> rst = new ArrayList<>();

        if (end == s.length() - 1 && wordDict.contains(s.substring(start, end + 1))) {
            rst.add(new StringBuilder(s.substring(start, end + 1)).reverse());
            return rst;
        }

        int startChild = end + 1;

        for (int i = 0; i < maxWordLen; i++) {

            int endChild = startChild + i;

            if (endChild >= s.length()) {
                break;
            }

            if (!wordDict.contains(s.substring(startChild, endChild + 1))) {
                continue;
            }


            List<StringBuilder> rstChild = helper(startChild, endChild, s, wordDict, maxWordLen);

            for (StringBuilder child : rstChild) {
                child.append(" " + new StringBuilder(s.substring(start, end + 1)).reverse());
            }

            rst.addAll(rstChild);
        }
        return rst;
    }


    @Test
    public void test() {
        String s = "catsanddog";
        Set<String> wordDict = new HashSet<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");


//        System.out.println(helper(0, 3, s, wordDict, 4));

        System.out.println(wordBreak(s, wordDict));

    }


    @Test
    public void test2() {
        String s = "abcd";
        Set<String> wordDict = new HashSet<>();
        wordDict.add("a");
        wordDict.add("abc");
        wordDict.add("b");
        wordDict.add("cd");


//        System.out.println(helper(0, 3, s, wordDict, 4));

        System.out.println(wordBreak(s, wordDict));

    }


    @Test
    public void test3() {
        String s = "bb";
        Set<String> wordDict = new HashSet<>();
        wordDict.add("a");
        wordDict.add("b");
        wordDict.add("bbb");
        wordDict.add("bbbb");


//        System.out.println(helper(0, 3, s, wordDict, 4));

        System.out.println(wordBreak(s, wordDict));

    }


    @Test
    public void test4() {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        Set<String> wordDict = new HashSet<>(Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"));


//        System.out.println(helper(0, 3, s, wordDict, 4));

        System.out.println(wordBreak(s, wordDict));

    }
}
