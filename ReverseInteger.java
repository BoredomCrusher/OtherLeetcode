package OtherLeetcode;

public class ReverseInteger {
    // Leetcode 7
    public static void main(String[] args) {
        for (int i = -1000; i < 1000; i += 150) {
            System.out.println("reverse " + i + " is " + reverse(i));
        }
    }

    public static int reverse(int x) {
        boolean isNegative = x < 0;
        String reverse = "";
        while (x / 10 != 0) {
            reverse += Math.abs(x % 10);
            x /= 10;
        }

        reverse += Math.abs(x);

        if (isNegative)
            reverse = "-" + reverse;

        try {
            return Integer.parseInt(reverse);
        } catch (NumberFormatException e) {
            return 0;
        }
        
    }
}
