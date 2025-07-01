import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException{
        String path = "input.txt";
        try(Scanner scan = new Scanner(new File(path))){
            HashMap<List<Integer>, Integer> visitedHouses = new HashMap<>();
            HashMap<List<Integer>, Integer> santa2 = new HashMap<>();
            visitedHouses.put(List.of(0,0),1);
            int housesVisited = 1;
            List<Integer> recentLocation1 = List.of(0,0);
            List<Integer> recentLocation2 = List.of(0,0);
            String input = scan.nextLine();
            char[] moves = input.toCharArray();
            boolean santa1Turn = true;
            for(char c : moves){
                if(c=='^'){
                    if(santa1Turn){
                        recentLocation1 = List.of(recentLocation1.get(0), recentLocation1.get(1)+1);
                        if(!visitedHouses.containsKey(recentLocation1)){
                            housesVisited++;
                            visitedHouses.put(recentLocation1, 1);
                        } 
                        santa1Turn = false;
                    }else{
                        recentLocation2 = List.of(recentLocation2.get(0), recentLocation2.get(1)+1);
                        if(!visitedHouses.containsKey(recentLocation2)){
                            housesVisited++;
                            visitedHouses.put(recentLocation2, 1);
                        } 
                        santa1Turn = true;
                    }
                }else if(c=='>'){
                    if(santa1Turn){
                        recentLocation1 = List.of(recentLocation1.get(0)+1, recentLocation1.get(1));
                        if(!visitedHouses.containsKey(recentLocation1)){
                            housesVisited++;
                            visitedHouses.put(recentLocation1, 1);
                        }
                        santa1Turn = false;
                    }else{
                        recentLocation2 = List.of(recentLocation2.get(0)+1, recentLocation2.get(1));
                        if(!visitedHouses.containsKey(recentLocation2)){
                            housesVisited++;
                            visitedHouses.put(recentLocation2, 1);
                        } 
                        santa1Turn = true;
                    }
                    
                }
                else if(c=='v'){
                    if(santa1Turn){
                        recentLocation1 = List.of(recentLocation1.get(0), recentLocation1.get(1)-1);
                        if(!visitedHouses.containsKey(recentLocation1)){
                            housesVisited++;
                            visitedHouses.put(recentLocation1, 1);
                        }
                        santa1Turn = false;
                    }else {
                        recentLocation2 = List.of(recentLocation2.get(0), recentLocation2.get(1)-1);
                        if(!visitedHouses.containsKey(recentLocation2)){
                            housesVisited++;
                            visitedHouses.put(recentLocation2, 1);
                        } 
                        santa1Turn = true;
                    }
                    
                }else if(c=='<'){
                    if(santa1Turn){
                        recentLocation1 = List.of(recentLocation1.get(0)-1, recentLocation1.get(1));
                        if(!visitedHouses.containsKey(recentLocation1)){
                            housesVisited++;
                            visitedHouses.put(recentLocation1, 1);
                        }
                        santa1Turn = false;
                    }else {
                        recentLocation2 = List.of(recentLocation2.get(0)-1, recentLocation2.get(1));
                        if(!visitedHouses.containsKey(recentLocation2)){
                            housesVisited++;
                            visitedHouses.put(recentLocation2, 1);
                        } 
                        santa1Turn = true;
                    }
                    
                }
            }
            System.out.println("Repeated houses: "+housesVisited);
        }
    }
}
