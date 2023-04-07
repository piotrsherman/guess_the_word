import java.util.Scanner;

public class Main {
    private static final String word = "moloko";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Угадайте слово");
        int wordLenght = word.length();//получаем колличество символов
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < wordLenght; i++) {
            stringBuilder.append("-");
        }
        String maskWord = stringBuilder.toString();//РАЗОБРАТЬСЯ В ТОМ, ЧТО ТАКОЕ stringBuilder!!!!!

        System.out.println(maskWord);

        do {
            System.out.print("Введите букву: ");
            char c = input.next().charAt(0);//???????
            if (word.toLowerCase().indexOf(c) >= 0) {//?????
                System.out.println("Есть такая буква в алфавите!");
                for (int i = 0; i < word.length(); i++) {// проходимся по каждой букве слова
                    if (word.charAt(i) == c) {
                        maskWord = replaceLetter(Character.toString(c), maskWord);//Character???
                    }
                }
                System.out.println(maskWord);
            } else {
                System.out.println("Промах. Давай ещё!");
            }

        } while (maskWord.contains("-"));

    }

    private static String replaceLetter(String letter, String maskWord) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter.charAt(0)) {
                stringBuilder.append(letter);//заменяем пропуск на букву
            } else if (maskWord.charAt(i) != '-') {
                stringBuilder.append(maskWord.charAt(i));//???
            }
            else  {
                stringBuilder.append("-");
            }
        }
        return stringBuilder.toString();
    }
}