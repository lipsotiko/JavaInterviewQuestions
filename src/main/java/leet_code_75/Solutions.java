package leet_code_75;

public class Solutions {
    public String mergeAlternately(String word1, String word2) {

        StringBuilder sb = new StringBuilder();

        int maxLength = Math.max(word1.length(), word2.length());

        for (int i = 0; i < maxLength; i++) {
            if (i < word1.length()) {
                sb.append(word1.charAt(i));
            }

            if (i < word2.length()) {
                sb.append(word2.charAt(i));
            }
        }


        return sb.toString();
    }

    public String gcdOfStrings(String str1, String str2) {
        int occurances = 0;
        String result = "";
        for (int i = 0; i < str2.length() + 1; i++) {
            String subStr = str2.substring(0, i);
            int l = str1.length() - str1.replaceAll(str2.substring(0, i), "").length();

            System.out.println(l);
            System.out.println(subStr);
            if (l >= occurances
                    && str1.replaceAll(subStr, "").isEmpty()
                    && str2.replaceAll(subStr, "").isEmpty()
            ) {
                result = subStr;
                occurances = l;
            }
        }
        return result;
    }

}
