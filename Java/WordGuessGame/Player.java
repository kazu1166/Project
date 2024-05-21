public class Player {

    private int life; // Player's remaining life
    private boolean wincon = false; // Flag indicating if win condition is met
    private char[] playerword; // Array to store the guessed word

    //getters and setters
    public int getLife() {
        return life;
    }

    public boolean getWincon() {
        return wincon;
    }

    public char[] getPlayerword() {
        return playerword;
    }

    public void setLife(int life) {
        this.life = life;
    }

    // Initializes the player's guessed word with underscores
    public void gameword(String word){
        int lettercount = word.length();
        this.playerword = new char[lettercount];
        for (int i=0; i<this.playerword.length;i++){
            this.playerword[i]='_';
        }
    }
    
    // Updates the win condition based on the player's progress and remaining life
    public void checkWincon(){
        boolean clear =false;
        if(this.life > 0) {
            for (int i = 0; i <this.playerword.length; i++) {
                if (this.playerword[i] == '_') {
                    this.wincon = false;
                    clear= false;
                    break;
                }
                clear = true;
            }
            if(clear){
                this.wincon = true;
                
                System.out.println("***************************");
                System.out.println("***************************");
                System.out.println("*****GAME Completed********");
                System.out.println("***************************");
                System.out.println("***************************");
            }
        }
        else if(this.life <= 0){
            System.out.println();
            System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
            System.out.println("░░░░ G ░░ A ░░ M ░░ E ░░░░░░ O ░░ V ░░ E ░░ R ░░" +"░░░░░░░░░░░");
            System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
            
            this.wincon = true;
        }
    }
}