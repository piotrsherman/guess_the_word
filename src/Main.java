import java.util.Scanner;
public class Main {
    private static final int MAX_TRIES = 7;
    private static final char BLANK_CHAR = '-';
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wrongAttempts = 0;
        String wordToGuess = "hello";
        char[] guessedLetters = new char[wordToGuess.length()];
        for (int i = 0; i < guessedLetters.length; i++) {
            guessedLetters[i] = BLANK_CHAR;
        }
        while (wrongAttempts < MAX_TRIES && new String(guessedLetters).contains("-")) {
            System.out.println("Guess a letter: ");
            char guess = scanner.next().charAt(0);
            if (!Character.isLetter(guess)) {
                System.out.println("Please enter a valid letter.");
                continue;
            }
            boolean found = false;
            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == guess) {
                    guessedLetters[i] = guess;
                    found = true;
                }
            }
            if (!found) {
                wrongAttempts++;
                System.out.println("Wrong guess! Attempts left: " + (MAX_TRIES - wrongAttempts));
            }
            drawHangman(wrongAttempts);
            System.out.println("Current progress: " + new String(guessedLetters));
        }
        if (!new String(guessedLetters).contains("-")) {
            System.out.println("Congratulations! You guessed the word: " + wordToGuess);
        } else {
            System.out.println("Sorry, you ran out of attempts. The word was: " + wordToGuess);
        }
    }
    private static void drawHangman(int wrongAttempts) {
        Gallows gallows = new Gallows();
        switch (wrongAttempts) {
            case 6:
                gallows.sixErrorsLeft();
                break;
            case 5:
                gallows.fiveErrorsLeft();
                break;
            case 4:
                gallows.foreErrorsLeft();
                break;
            case 3:
                gallows.threeErrorsLeft();
                break;
            case 2:
                gallows.twoErrorsLeft();
                break;
            case 1:
                gallows.oneErrorsLeft();
                break;
            case 0:
                gallows.zeroErrorsLeft();
                break;
            default:
                break;
        }
    }
}