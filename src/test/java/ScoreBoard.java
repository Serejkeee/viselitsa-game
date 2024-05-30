import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class ScoreBoard {
    private static final int MAX_MISTAKE = 7;
    private static final char MASK = '_';
    private List<Character> searchWord;
    private final List<Character> table = new ArrayList<>();

    private final Set<Character> enteredLetter = new HashSet<>();
    private int countMistake;
    private int countRightLetter;
    private final String path = "C:\\Users\\Сергей Сафиянц\\Downloads\\viselitsa-game\\src\\test\\resources\\russian_nouns.txt";

    public ScoreBoard() {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(path))) {
            String line;
            List<String> dictinory = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                if (line.length() <= MAX_MISTAKE) {
                    dictinory.add(line);
                }
            }
            int randomWordNUm = new Random().nextInt(dictinory.size() - 1);
            searchWord = dictinory.get(randomWordNUm)
                    .chars()
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.toList());
            table.addAll(Collections.nCopies(searchWord.size(), MASK));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Enum checkLetter(char input) {
        boolean letterWas = enteredLetter.add(input);
        boolean guess = false;
        if (!letterWas) {
            System.out.println("\u001B[31mТакая буква уже вводилась\u001B[0m");
            return GuessState.GUESSED_REPEATEDLY;
        }
        for (int i = 0; i < searchWord.size(); i++) {
            if (input == searchWord.get(i)) {
                table.set(i, input);
                countRightLetter++;
                guess = true;
            }
        }
        if (guess) {
            return GuessState.GUESSED;
        } else {
            countMistake++;
            return GuessState.NOT_GUESSED;
        }

    }

    public void printScoreBoard() {
        System.out.print("Слово:");
        for (char c : table) {
            System.out.print(c);
        }
        System.out.println("\nОшибки: " + countMistake);
    }

    public String checkGameState() {
        if (countMistake < MAX_MISTAKE) {
            if (table.size() != countRightLetter) {
                return Main.NOT_FINISH;
            }  else {
                return Main.WIN;
            }
        }
        return Main.LOSS;
    }

    public String searchWord() {
        return searchWord.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
