package code;
public class Palindrome {
    public static boolean isPalindrome(int x) {
        String numberToString = String.valueOf(x);
        int numberLength = numberToString.length();
        int left = 0;
        int right = numberLength - 1;
        while (left < right){
            if ( numberToString.charAt(left) != numberToString.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args) {
        int x = -121;
        int y = 121;
        System.out.println(isPalindrome(x));
        System.out.println(isPalindrome(y));
    }
}
