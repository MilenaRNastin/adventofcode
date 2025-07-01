import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
    
    private static int paperNeeded(int w, int l, int h){
        int area1 = w*l;
        int area2 = w*h;
        int area3 = l*h;
        int smallestArea = 0;
        if(area1>area2){
            if(area2>area3){
                smallestArea = area3;
            } else{
                smallestArea = area2;
            }
        }else if(area1>area3){
            smallestArea = area3;
        }else{
            smallestArea = area1;
        }
        return 2*area1+2*area2+2*area3+smallestArea;
    }

    private static int ribbonLength(int w, int l, int h){
        int bow = w*l*h;
        int wrap = 0;
        if(w<l){
            if(l<h){
                wrap = 2*w+2*l;
            } else{
                wrap = 2*w + 2*h;
            }
        }else{
            if(h<w){
                wrap = 2*l + 2*h;
            } else {
                wrap = 2*w+2*l;
            }
        }
        return bow+wrap;
    }


    public static void main(String[] args) throws FileNotFoundException {
        String path = "input.txt";
        try(Scanner scan = new Scanner(new File(path))){
            int totalPaper = 0;
            int totalRibbon = 0;
            while(scan.hasNextLine()){
                String line = scan.nextLine();
                String[] dimensions = line.split("x");
                totalPaper += paperNeeded(Integer.parseInt(dimensions[0]),
                                        Integer.parseInt(dimensions[1]),
                                        Integer.parseInt(dimensions[2]));
                totalRibbon += ribbonLength(Integer.parseInt(dimensions[0]),
                                        Integer.parseInt(dimensions[1]),
                                        Integer.parseInt(dimensions[2]));
            }
            System.out.println("Total paper needed: "+ totalPaper);
            System.out.println("Total ribbon needed: " + totalRibbon);
        }
    }
}
