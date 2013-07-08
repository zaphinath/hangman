package hangman;

import java.io.File;
import java.util.Set;
import java.util.HashSet;
//import java.util.List;
//import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.lang.StringBuilder;

public class EvilHangmanGameImpl implements EvilHangmanGame {
  //private List<Character> guessedChars;	
  private StringBuilder guessedChars;
  private HashSet<String> dict;
	private boolean[] chars;
  private int remainingGuesses;  
  private StringBuilder secretWord; // This is the winning world  
  /* Constructor 
   * Set up array of 26 to know which chars have been used;
   */
  public EvilHangmanGameImpl() {
    guessedChars = new StringBuilder("Used letters: ");
    chars = new boolean[26];
    for (int i = 0; i < 26; i++) {
      chars[i] = false;
    }
  }

	/**
	 * Starts a new game of evil hangman using words from <code>dictionary</code>
	 * with length <code>wordLength</code>
	 * 
	 * @param dictionary Dictionary of words to use for the game
	 * @param wordLength Number of characters in the word to guess
	 */
	public void startGame(File dictionary, int wordLength) {
    loadDictionary(dictionary, wordLength);
    secretWord = new StringBuilder(wordLength);
    for (int i = 0; i < wordLength; i++) {
      secretWord.append('-');
    }
  
  }
	

	/**
	 * Make a guess in the current game.
	 * 
	 * @param guess The character being guessed
	 * @return The set of strings that satisfy all the guesses made so far
	 * in the game, including the guess made in this call. The game could claim
	 * that any of these words had been the secret word for the whole game. 
	 * 
	 * @throws GuessAlreadyMadeException If the character <code>guess</code> 
	 * has already been guessed in this game.
	 */
	public Set<String> makeGuess(char guess) throws GuessAlreadyMadeException {
    HashSet setSets = new HashSet<HashSet<String>>();
    return null;
  }

  public char getCharInput() {
    // make it lowercase
    // if used letter already prompt again to get new letter
    // if invalid input prompt for new input
    // check if it is a char
    // add char to array of used chars
    // append to string guessedChars
    System.out.print("Enter Guess: ");
    Scanner in = new Scanner(System.in);
    char c = (char) in.next().charAt(0);
    Character ch = new Character(c);
    ch = Character.toLowerCase(ch);
    int numValue = Character.getNumericValue(ch) - 10;
    if (numValue < 0 || numValue > 26) {
      System.out.println("Invalid Input");
      getCharInput();
    }
    if (chars[numValue] == true) {
      System.out.println("You already used that letter.");
      getCharInput();
    } else {
      chars[numValue] = true;
      guessedChars.append(" " + ch);
      remainingGuesses--;
    }
    return ch;
  }
  
  public void playGame(int numGuesses) {
    remainingGuesses = numGuesses;
    for (int i = 0; i < numGuesses; i++) {
      System.out.println("You have "+remainingGuesses+" guesses left");
      System.out.println(guessedChars.toString());
      System.out.println("Word: " + secretWord.toString());
      char guess = getCharInput();
      System.out.println(guess); 
    }
  }

  private void loadDictionary(File dictionary, int wordLength) {
    try {
      if (dictionary.length() == 0) {
        System.out.println("Dictionary Empty");
        System.exit(-9);
      }
      //guessedChars = new ArrayList<Character>();
      dict = new HashSet<String>();
      Scanner sc = new Scanner(dictionary);
      while (sc.hasNext()) {
        String tmp = sc.next();
        if (tmp.length() == wordLength) {
          dict.add(tmp);
        }
      }
    } catch (FileNotFoundException e) {
      System.out.println("No Such File");
    }

  }

	
}
