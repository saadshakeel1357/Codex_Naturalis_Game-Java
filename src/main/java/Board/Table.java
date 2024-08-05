package Board;

import Cards.ResourceFront;
import Cards.StarterFront;

public class Table {

    public void addCardBottomLeftCorner(StarterFront start, ResourceFront res, String[] startcardLines, String[] rescardLines){

        for(int i = 0; i < startcardLines.length - 3; i++ ){
            System.out.println("                      " + startcardLines[i]);
        }
        System.out.println(rescardLines[0] + startcardLines[6].substring(5));
        System.out.println(rescardLines[1] + startcardLines[7].substring(5));
        System.out.println(rescardLines[2] + startcardLines[8].substring(5));
        for(int l = 3; l < rescardLines.length; l++ ){
            System.out.println(rescardLines[l]);
        }
    }


    public void addCardBottomRightCorner(StarterFront start, ResourceFront res, String[] startcardLines, String[] rescardLines){

        for(int i = 0; i < startcardLines.length - 3; i++){
            System.out.println(startcardLines[i]);
        }
        System.out.println(startcardLines[6].substring(0, startcardLines[6].length() -5)+ rescardLines[0]);
        System.out.println(startcardLines[7].substring(0, startcardLines[7].length() -5)+ rescardLines[1]);
        System.out.println(startcardLines[8].substring(0, startcardLines[8].length() -5)+ rescardLines[2]);
        for(int i = 3; i < rescardLines.length; i++){
            System.out.println("                      " + rescardLines[i]);
        }
    }

    public void addCardTopLeftCorner(StarterFront start, ResourceFront res, String[] startcardLines, String[] rescardLines){

        for(int i = 0; i < rescardLines.length - 3; i++){
            System.out.println(rescardLines[i]);
        }
        System.out.println(rescardLines[6] + startcardLines[0].substring(5));
        System.out.println(rescardLines[7] + startcardLines[1].substring(5));
        System.out.println(rescardLines[8] + startcardLines[2].substring(5));
        for(int i = 3; i < startcardLines.length; i++ ){
            System.out.println("                      " + startcardLines[i]);
        }
    }


    public void addCardTopRightCorner(StarterFront start, ResourceFront res, String[] startcardLines, String[] rescardLines){

        for(int i = 0; i < rescardLines.length - 3; i++){
            System.out.println("                      " + rescardLines[i]);
        }
        System.out.println(startcardLines[0].substring(0, startcardLines[0].length() -5) + rescardLines[6]);
        System.out.println(startcardLines[1].substring(0, startcardLines[1].length() -5) + rescardLines[7]);
        System.out.println(startcardLines[2].substring(0, startcardLines[2].length() -5) + rescardLines[8]);
        for(int i = 3; i < startcardLines.length; i++){
            System.out.println(startcardLines[i]);
        }
    }



    public static void main(String[] args) {

        // // TESTINGG
        // Table tb = new Table();

        // StarterFront card1 = new StarterFront("empty", "leaf", "insect", "empty", new String[]{"insect"});
        // ResourceFront card2 = new ResourceFront("mushroom", "leaf", "mushroom", "leaf", "mushroom", 0);
        

        
        // String[] card1Lines = card1.getPrettyPrint().split("\n");
        // String[] card2Lines = card2.getPrettyPrint().split("\n");

        // card1.prettyPrint();
        // card2.prettyPrint();
        // // tb.constructTablePrint();
        // tb.addCardBottomLeftCorner(card1, card2, card1Lines, card2Lines);


        // System.out.println("-----------------------------------------------------------------");

        // card1.prettyPrint();
        // card2.prettyPrint();

        // tb.addCardBottomRightCorner(card1, card2, card1Lines, card2Lines);


        // System.out.println("-----------------------------------------------------------------");

        // card1.prettyPrint();
        // card2.prettyPrint();

        // tb.addCardTopRightCorner(card1, card2, card1Lines, card2Lines);

        // System.out.println("-----------------------------------------------------------------");

        // card1.prettyPrint();
        // card2.prettyPrint();

        // tb.addCardTopLeftCorner(card1, card2, card1Lines, card2Lines);


    }
}