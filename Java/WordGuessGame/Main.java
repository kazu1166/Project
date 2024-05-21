import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       printWelcomeMessage();
       playGame();
    }

    // A method show the rule of this game when player start the game
    private static void printWelcomeMessage() {
        System.out.println();
        System.out.println("*******************************************************");
        System.out.println("*                                                     *");
        System.out.println("*            Welcome to Word Guess Game!              *");
        System.out.println("*                                                     *");
        System.out.println("*     You'll have 3 lives to guess the hidden word.   *");
        System.out.println("*                                                     *");
        System.out.println("*      Input a letter you guessed. If it matches      *");
        System.out.println("*         any letter in the word, it will reveal      *");
        System.out.println("*               the correct letter(s).                *");
        System.out.println("*                                                     *");
        System.out.println("*    If you enter a wrong letter, your life will be   *");
        System.out.println("*                  reduced by one.                    *");
        System.out.println("*                                                     *");
        System.out.println("*   Keep guessing until you either solve the word     *");
        System.out.println("*            or run out of attempts!                  *");
        System.out.println("*                                                     *");
        System.out.println("*******************************************************");
        System.out.println();
    }

    // A method runs the game
    private static void playGame() {

        // Setup the scanner
        Scanner input = new Scanner(System.in);

        do {
            // Instantiate word
            Word word = new Word();
            // Sets game word
            word.setword(); 

            // Instantiate player
            Player p1 = new Player();
            // Sets Player's life
            p1.setLife(3);   // You can change the number of user's life here 

            // Initialize the player's word
            p1.gameword(word.getWord());
            

            do {
                
                System.out.println("************************");
                System.out.println("**  ENTER ANY LETTER  **");
                System.out.println("************************");

                char letter = input.next().toUpperCase().charAt(0); // Input accepts both uppercase and lowercase
                boolean guess = false;

                // Compare the entered letters to the letters in the answer
                for(int i=0;i<word.getWord().length();i++){
                    if(word.getWord().charAt(i)== letter){  // If the guessed letter matchs any letter in the answer
                        p1.getPlayerword()[i]=letter;       // Reveal the correct letter(s)
                        System.out.println("Correct letter");
                        guess = true;
                    }
                }
                if(!guess){
                    System.out.println("Wrong letter");
                    p1.setLife(p1.getLife()-1);            // If the guessed letter doesn't much any letter in the answer, reduce player's life by 1
                }
                System.out.println("Life "+p1.getLife()); 
                System.out.println();
                System.out.println(p1.getPlayerword());
                System.out.println();

                p1.checkWincon();                          // Check win condition

            } while (!p1.getWincon()); // Continue until the conditions to end the game are met


            System.out.println();
            System.out.println();
            System.out.println("Do you want to play again? (Y/N): ");
            String playAgain = input.next();
            System.out.println();

            if (!playAgain.equalsIgnoreCase("Y")) { // If user chose "N" 
                break;                                            // End the game
            }

        } while (true); // Otherwise play again
        
    }



}

