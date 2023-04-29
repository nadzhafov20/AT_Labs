package lab_2;

public class CharacterArrays {
    public static void main(String[] args) {
        char[] charArray = {'t', 'i', 'm', 'a', 'r', 'f', 't', '7', 'e', 'h', 'o', 'u'};
        int vowelCount = 0;

        for(int i = 0; i < charArray.length; i++) {
            System.out.print(charArray[i] + " ");

            char c = charArray[i];
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowelCount++;
            }
        }

        System.out.println("\nКількість голосних: " + vowelCount);
    }
}
