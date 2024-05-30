import java.util.Arrays;
import java.util.List;

public class Hangman {
     private final List<String> hangmanState;
     private int currentState;

     {

          hangmanState = Arrays.asList("    +---+\n" +
                          "    |   |\n" +
                          "    |\n" +
                          "    |\n" +
                          "    |\n" +
                          "    |\n" +
                          "    =========",

                  "    +---+\n" +
                          "    |   |\n" +
                          "    |   O\n" +
                          "    |\n" +
                          "    |\n" +
                          "    |\n" +
                          "    =========",

                  "    +---+\n" +
                          "    |   |\n" +
                          "    |   O\n" +
                          "    |   |\n" +
                          "    |\n" +
                          "    |\n" +
                          "    =========",

                  "    +---+\n" +
                          "    |   |\n" +
                          "    |   O\n" +
                          "    |  /|\n" +
                          "    |\n" +
                          "    |\n" +
                          "    =========",

                  "    +---+\n" +
                          "    |   |\n" +
                          "    |   O\n" +
                          "    |  /|\\\n" +
                          "    |\n" +
                          "    |\n" +
                          "    =========",

                  "    +---+\n" +
                          "    |   |\n" +
                          "    |   O\n" +
                          "    |  /|\\\n" +
                          "    |  /\n" +
                          "    |\n" +
                          "    =========",

                  "    +---+\n" +
                          "    |   |\n" +
                          "    |   O\n" +
                          "    |  /|\\\n" +
                          "    |  / \\\n" +
                          "    |\n" +
                          "    =========");
     }

     public void printhangman() {
          if (currentState == 7) {
               currentState = 6;
          }
          System.out.println(hangmanState.get(currentState));
     }

     public void changeState() {
          currentState++;
     }
}

