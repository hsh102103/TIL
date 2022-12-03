package baekjoon;

import java.util.Scanner;

public class BOJ_암호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String charToInt = "abcdefghijklmnopqrstuvwxyz";
        String plainText = sc.nextLine();
        String encryptionKey = sc.nextLine();

        while (encryptionKey.length() < plainText.length()) {
            encryptionKey += encryptionKey;
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            if (plainText.charAt(i) == ' ') {
                res.append(" ");
                continue;
            }
            int index = plainText.charAt(i) - encryptionKey.charAt(i)-1;
            if (index < 0) {
                index = 26 + index;
            }
            res.append(charToInt.charAt(index));
        }

        System.out.println(res);
    }
}
