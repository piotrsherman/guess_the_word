import java.util.Scanner;

public class Main {
    private static final String word = "moloko";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Guess the word");
        int wordLength = word.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < wordLength; i++) {
            stringBuilder.append("-");
        }
        String maskWord = stringBuilder.toString();
        int incorrectGuesses = 0; // initialize counter for incorrect guesses
        int now = 0;
        Gallows gallows = new Gallows();

        System.out.println(maskWord);

        while (incorrectGuesses < 7 && maskWord.contains("-")) { // continue the game until 7 incorrect guesses or word is guessed
            System.out.print("Enter a letter: ");

            char c = input.next().charAt(0);
            if (word.toLowerCase().indexOf(c) >= 0) {
                System.out.println("You are right");
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == c) {
                        maskWord = replaceLetter(Character.toString(c), maskWord);
                    }
                }
                System.out.println(maskWord);
            } else {
                System.out.println("No, try again");
                incorrectGuesses++; // increment the counter for incorrect guesses
                now = 7 - incorrectGuesses;
                System.out.println("You have " + (now) + " incorrect guesses left"); // display the number of incorrect guesses left
                if (now == 6) { gallows.sixErrorsLeft();}
                if (now == 5) { gallows.fiveErrorsLeft();}
                if (now == 4) { gallows.foreErrorsLeft();}
                if (now == 3) { gallows.threeErrorsLeft();}
                if (now == 2) { gallows.twoErrorsLeft();}
                if (now == 1) { gallows.oneErrorsLeft();}
                if (now == 0) { gallows.zeroErrorsLeft();}
            }
        }

        if (!maskWord.contains("-")) {
            System.out.println("Congratulations, you won!");
        } else {
            System.out.println("Sorry, you lost. The word was " + word);
        }
    }

    private static String replaceLetter(String letter, String maskWord) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter.charAt(0)) {
                stringBuilder.append(letter);
            } else if (maskWord.charAt(i) != '-') {
                stringBuilder.append(maskWord.charAt(i));
            } else {
                stringBuilder.append("-");
            }
        }
        return stringBuilder.toString();
    }
}