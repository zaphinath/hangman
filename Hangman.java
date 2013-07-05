package hangman;



public class Hangman {
  private static String usage = "Usage: java HangMan dictionary wordLength guesses";

  public static void main(String[] args) {
    if (args.length > 3 || args.length < 2) {
      System.out.println(usage);
      System.exit(-9);
    }
    String dictionary = args[0];
    String wordLength = args[1];
    String guesses = args[2];
  }

  EvilHangmanGame game = new EvilHangmanGameImpl();

}
