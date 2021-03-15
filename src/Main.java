import java.util.ArrayList;
import processing.core.*;

public class Main {
    public static void main(String[] args) {
//        testIsPalindrome();
//        testfindBestJobs();
//        testCountXHalf();
//        testCountXFirst();
//        testRemoveX();
//        testInsertStarTwin();
        testGroupSum();
     }

    private static void testIsPalindrome() {
        String[] words = new String[] {"noon", "noan", "civic", "civac", "rotator"};
        for (String word : words) {
            System.out.println( word + ": " + isPalindrome(word) );
        }
    }
    private static Boolean isPalindrome(String word) {
        if (word.length() <= 1) { return true; }

        String first = word.substring(0, 1);
        String rest  = word.substring(1, word.length()-1 );
        String last  = word.substring(word.length()-1, word.length() );

        return first.equals(last) && isPalindrome(rest);
    }

    private static void testfindBestJobs() {
        int[] times  = new int[] { 1,  2,  3,   8,  7,  4};
        int[] prices = new int[] {60, 15, 30, 120, 45, 75};

        for (int hours = 10; hours < 400; hours += 10) {
            System.out.println(hours + " :" + findBestJobs(times, prices, hours, 0));
        }
    }
    private static ArrayList<Integer> findBestJobs(int[] jobTimes, int[] jobPrices, int maxTime, int startingIndex) {
        //TODO
        return new ArrayList<>();
    }

    private static void testCountXHalf() {
        System.out.println( countXHalf("abcdefg") );
        System.out.println( countXHalf("") );
        System.out.println( countXHalf("x") );
        System.out.println( countXHalf("xx") );
        System.out.println( countXHalf("xxx") );
        System.out.println( countXHalf("xxxx") );
        System.out.println( countXHalf("xxxxx") );
    }
    private static int countXHalf(String str) {
        if (str.length() == 0) {
            return 0;
        }
        if (str.length() == 1) {
            if (str.equals("x")) { return 1; }
            else { return 0; }
        }
        String str1 = str.substring(0, str.length()/2);
        String str2 = str.substring(str.length()/2);
        return countXHalf(str1) + countXHalf(str2);
    }

    private static void testCountXFirst() {
        System.out.println( countXFirst("abcdefg") );
        System.out.println( countXFirst("") );
        System.out.println( countXFirst("x") );
        System.out.println( countXFirst("xx") );
        System.out.println( countXFirst("xxx") );
        System.out.println( countXFirst("xxxx") );
        System.out.println( countXFirst("xxxxx") );
    }
    private static int countXFirst(String str) {
        if (str.length() == 0) {
            return 0;
        }
        if (str.length() == 1) {
            if (str.equals("x")) { return 1; }
            else { return 0; }
        }
        String str1 = str.substring(0, 1);
        String str2 = str.substring(1);
        return countXFirst(str1) + countXFirst(str2);
    }

    private static void testRemoveX() {
        System.out.println( removeX("abcdef") );
        System.out.println( removeX("abcdefg") );
        System.out.println( removeX("") );
        System.out.println( removeX("x") );
        System.out.println( removeX("xx") );
        System.out.println( removeX("xxx") );
        System.out.println( removeX("xxxx") );
        System.out.println( removeX("xxxxx") );
        System.out.println( removeX("axbxcxdxexf") );
        System.out.println( removeX("xabxcxdxefx") );
    }
    private static String removeX(String str) {
        if (str.length() == 0) { return ""; }
        if (str.length() == 1) {
            if (str.equals("x")) { return ""; }
            else { return str; }
        }
        String str1 = str.substring(0, str.length()/2);
        String str2 = str.substring(str.length()/2);
        return removeX(str1) + removeX(str2);
    }

    private static void testInsertStarTwin() {
        System.out.println( insertStarTwin("xx") );
        System.out.println( insertStarTwin("aab") );
        System.out.println( insertStarTwin("abb") );
        System.out.println( insertStarTwin("abbb") );
        System.out.println( insertStarTwin("aabb") );
        System.out.println( insertStarTwin("xxx") );
        System.out.println( insertStarTwin("xxxx") );
        System.out.println( insertStarTwin("xxxxx") );
        System.out.println( insertStarTwin("axbxcxdxexf") );
        System.out.println( insertStarTwin("xabxcxdxefx") );
    }
    private static String insertStarTwin(String str) {
        if (str.length() <= 1) { return str; }
        if (str.length() == 2) {
            if (str.substring(0,1).equals( str.substring(1,2))) {
                return str.substring(0,1) + "*" + str.substring(1); }
            else { return str; }
        }
        String str1 = str.substring(0, 2);
        String str2 = str.substring(2);
        // TODO fix missing star in certain cases
        return insertStarTwin(str1) + insertStarTwin(str2);
    }

    private static void testGroupSum() {
        System.out.println( groupSum(0, new int[] {2, 4, 8}, 10) ); // → true
        System.out.println( groupSum(0, new int[] {2, 4, 8}, 14) ); // → true
        System.out.println( groupSum(0, new int[] {2, 4, 8},  9) ); // → false
    }
    private static Boolean groupSum(int start, int[] arr, int sum) {
        if (start >= arr.length) { return sum == 0; }
        return groupSum(start+1, arr, sum - arr[start]) || groupSum(start+1, arr, sum);
    }
}
