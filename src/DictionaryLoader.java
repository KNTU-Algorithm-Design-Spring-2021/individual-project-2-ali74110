import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DictionaryLoader {
    private List<String> words = new ArrayList<>();

    public DictionaryLoader() throws FileNotFoundException {
        File file = new File("F:\\ALI\\university\\Term 4\\Algorithm design" +
                "\\Projects\\individual-project-2-ali74110\\resources" +
                "\\The-Oxford-3000-master\\The-Oxford-3000-master\\The_Oxford_3000.txt");
        Scanner scanner = new Scanner(file);
        String word = "";
        while (!word.equals("=== end ==")){
            word = scanner.nextLine();
            word = word.trim();
            word = word.toLowerCase();
            words.add(word);
        }
        scanner.close();
    }

    public boolean contains(String word){
        return words.contains(word);
    }
}
