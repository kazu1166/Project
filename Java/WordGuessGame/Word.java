import java.util.Random;

public class Word {
    private String word; // Word for answer

    // Sets a random word from a predefined list
    public void setword(){
        String[] wordbox ={"APPLE", "BANANA", "JAPAN", "TURKEY", "AFRICA", "POLICE", "CANADA" }; // You can add new words in this alley

        // Set a random integer from the word count of the wordbox 
        Random r = new Random();
        int n = r.nextInt(wordbox.length);

        this.word = wordbox[n];
    }

    // Getter for the String Word
    public String getWord() {
        return word;
    }
}