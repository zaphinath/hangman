package hangman;

import java.io.File;

public class Hangman {
  private static String usage = "Usage: java HangMan dictionary wordLength guesses";
  //private static File dictionary;
  //private static int wordLength;
  //private static int guesses;


  public static void main(String[] args) {
    if (args.length > 3 || args.length < 2) {
      System.out.println(usage);
      System.exit(-9);
    }
    File dictionary = new File(args[0]);
    int wordLength = Integer.parseInt(args[1]);
    int guesses = Integer.parseInt(args[2]);

    EvilHangmanGameImpl game = new EvilHangmanGameImpl();
  
    game.startGame(dictionary, wordLength);
    game.playGame(guesses);
  }
  
}
