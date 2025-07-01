import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "input.txt";
        int floor = 0;
        int counter = 0;
        int basementPosition=0;
        boolean foundBasement = false;
        try(Scanner scan = new Scanner(new File(path))){
            String line = scan.nextLine();
            for(int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if(c == '('){
                    floor++;
                } else {
                    floor--;
                }
                counter++;
                if(floor == -1 && !foundBasement) {
                    basementPosition=counter;
                    foundBasement = true;
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + path);
            return;
            
        }
        System.out.println("Final floor: " + floor);
        System.out.println("Basement found at: "+ basementPosition);
    }
}