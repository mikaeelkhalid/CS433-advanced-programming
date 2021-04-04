package a01;

public class isUnique {

    public static boolean isUniqueChars(String str) {
        if (str.length() > 26) {
            return false;
        }
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0)
                return false;
            checker |= (1 << val);
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = { "abcde", "hello", "car", "city", "eminem" };
        for (String word : words) {
            System.out.println(word + ": " + isUniqueChars(word));
        }
    }
}
