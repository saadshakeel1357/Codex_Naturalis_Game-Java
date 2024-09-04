package Board;

import Cards.Cards;
import Cards.GoldFront;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Table {


    public List<Integer> card2 = new ArrayList<>();
    public List<Integer> cardCorner = new ArrayList<>();
    public List<Integer> card1 = new ArrayList<>();
    public List<int[]> corners = new ArrayList<>();

    public int[] resOnTable = new int[4];

    public int[] objOnTable = new int[3];

    public String displayAllCards(Player player) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (Cards card : player.getPlayedCards()) {
            sb.append("Card ").append(i).append(": \n");
            sb.append(card.getPrettyPrint()).append("");

            // Check if the current card is in card2 list to find its connection details
            int cardIndex = card2.indexOf(i);
            if (cardIndex != -1) {
                int connectedCardIndex = card1.get(i-1);
                int connectedCorner = cardCorner.get(i-1);
                sb.append("Connected to card ").append(connectedCardIndex)
                  .append(" through corner ").append(connectedCorner).append("\n\n\n");
            } else {
                sb.append("\n\n\n");
            }
            i++;
        }
        return sb.toString();
    }




    public void setObjOnTable(Player player, Cards card, int index, int corner){
        if(card.getVar1() == "bottle"){ objOnTable[0]++; }
        if(card.getVar1() == "paper"){ objOnTable[1]++; }
        if(card.getVar1() == "feather"){ objOnTable[2]++; }

        if(card.getVar2() == "bottle"){ objOnTable[0]++; }
        if(card.getVar2() == "paper"){ objOnTable[1]++; }
        if(card.getVar2() == "feather"){ objOnTable[2]++; }

        if(card.getVar3() == "bottle"){ objOnTable[0]++; }
        if(card.getVar3() == "paper"){ objOnTable[1]++; }
        if(card.getVar3() == "feather"){ objOnTable[2]++; }

        if(card.getVar4() == "bottle"){ objOnTable[0]++; }
        if(card.getVar4() == "paper"){ objOnTable[1]++; }
        if(card.getVar4() == "feather"){ objOnTable[2]++; }

        if( corner == 1){
            if(player.getPlayedCards().get(index).getVar1() == "bottle"){ objOnTable[0]--; }
            if(player.getPlayedCards().get(index).getVar1() == "paper"){ objOnTable[1]--; }
            if(player.getPlayedCards().get(index).getVar1() == "feather"){ objOnTable[2]--; }
        }

        if( corner == 2){
            if(player.getPlayedCards().get(index).getVar2() == "bottle"){ objOnTable[0]--; }
            if(player.getPlayedCards().get(index).getVar2() == "paper"){ objOnTable[1]--; }
            if(player.getPlayedCards().get(index).getVar2() == "feather"){ objOnTable[2]--; }
        }

        if( corner == 3){
            if(player.getPlayedCards().get(index).getVar3() == "bottle"){ objOnTable[0]--; }
            if(player.getPlayedCards().get(index).getVar3() == "paper"){ objOnTable[1]--; }
            if(player.getPlayedCards().get(index).getVar3() == "feather"){ objOnTable[2]--; }
        }

        if( corner == 4){
            if(player.getPlayedCards().get(index).getVar4() == "bottle"){ objOnTable[0]--; }
            if(player.getPlayedCards().get(index).getVar4() == "paper"){ objOnTable[1]--; }
            if(player.getPlayedCards().get(index).getVar4() == "feather"){ objOnTable[2]--; }
        }

    }



    public void setResOnTable(Player player, Cards card, int index, int corner){
        if(card.getVar1() == "leaf"){ resOnTable[0]++; }
        if(card.getVar1() == "insect"){ resOnTable[1]++; }
        if(card.getVar1() == "animal"){ resOnTable[2]++; }
        if(card.getVar1() == "mushroom"){ resOnTable[3]++; }

        if(card.getVar2() == "leaf"){ resOnTable[0]++; }
        if(card.getVar2() == "insect"){ resOnTable[1]++; }
        if(card.getVar2() == "animal"){ resOnTable[2]++; }
        if(card.getVar2() == "mushroom"){ resOnTable[3]++; }

        if(card.getVar3() == "leaf"){ resOnTable[0]++; }
        if(card.getVar3() == "insect"){ resOnTable[1]++; }
        if(card.getVar3() == "animal"){ resOnTable[2]++; }
        if(card.getVar3() == "mushroom"){ resOnTable[3]++; }

        if(card.getVar4() == "leaf"){ resOnTable[0]++; }
        if(card.getVar4() == "insect"){ resOnTable[1]++; }
        if(card.getVar4() == "animal"){ resOnTable[2]++; }
        if(card.getVar4() == "mushroom"){ resOnTable[3]++; }

        if( corner == 1){
            if(player.getPlayedCards().get(index).getVar1() == "leaf"){ resOnTable[0]--; }
            if(player.getPlayedCards().get(index).getVar1() == "insect"){ resOnTable[1]--; }
            if(player.getPlayedCards().get(index).getVar1() == "animal"){ resOnTable[2]--; }
            if(player.getPlayedCards().get(index).getVar1() == "mushroom"){ resOnTable[3]--; }
        }

        if( corner == 2){
            if(player.getPlayedCards().get(index).getVar2() == "leaf"){ resOnTable[0]--; }
            if(player.getPlayedCards().get(index).getVar2() == "insect"){ resOnTable[1]--; }
            if(player.getPlayedCards().get(index).getVar2() == "animal"){ resOnTable[2]--; }
            if(player.getPlayedCards().get(index).getVar2() == "mushroom"){ resOnTable[3]--; }
        }

        if( corner == 3){
            if(player.getPlayedCards().get(index).getVar3() == "leaf"){ resOnTable[0]--; }
            if(player.getPlayedCards().get(index).getVar3() == "insect"){ resOnTable[1]--; }
            if(player.getPlayedCards().get(index).getVar3() == "animal"){ resOnTable[2]--; }
            if(player.getPlayedCards().get(index).getVar3() == "mushroom"){ resOnTable[3]--; }
        }

        if( corner == 4){
            if(player.getPlayedCards().get(index).getVar4() == "leaf"){ resOnTable[0]--; }
            if(player.getPlayedCards().get(index).getVar4() == "insect"){ resOnTable[1]--; }
            if(player.getPlayedCards().get(index).getVar4() == "animal"){ resOnTable[2]--; }
            if(player.getPlayedCards().get(index).getVar4() == "mushroom"){ resOnTable[3]--; }
        }

    }

  
    public synchronized boolean goldCardPlayable(GoldFront card) {
        int index = 0;
        int index2 = 0;


        if(card.getReqResources().length == 5){

            if(card.getReqResources()[0] == "leaf") index = 0;
            if(card.getReqResources()[0] == "insect") index = 1;
            if(card.getReqResources()[0] == "animal") index = 2;
            if(card.getReqResources()[0] == "mushroom") index = 3;


            if(resOnTable[index] >= 5) return true;

        }

        if(card.getReqResources().length == 3){

            if(card.getReqResources()[0] == card.getReqResources()[2]){
                if(card.getReqResources()[0] == "leaf") index = 0;
                if(card.getReqResources()[0] == "insect") index = 1;
                if(card.getReqResources()[0] == "animal") index = 2;
                if(card.getReqResources()[0] == "mushroom") index = 3;

                if(resOnTable[index] >= 3) return true;
            }

            if(card.getReqResources()[0] != card.getReqResources()[2]){
                if(card.getReqResources()[0] == "leaf") index = 0;
                if(card.getReqResources()[0] == "insect") index = 1;
                if(card.getReqResources()[0] == "animal") index = 2;
                if(card.getReqResources()[0] == "mushroom") index = 3;

                if(card.getReqResources()[2] == "leaf") index2 = 0;
                if(card.getReqResources()[2] == "insect") index2 = 1;
                if(card.getReqResources()[2] == "animal") index2 = 2;
                if(card.getReqResources()[2] == "mushroom") index2 = 3;

                if(resOnTable[index] >= 2 && resOnTable[index2] >=1) return true;
            }

        }

        if(card.getReqResources().length == 4){
            if(card.getReqResources()[0] == "leaf") index = 0;
            if(card.getReqResources()[0] == "insect") index = 1;
            if(card.getReqResources()[0] == "animal") index = 2;
            if(card.getReqResources()[0] == "mushroom") index = 3;

            if(card.getReqResources()[3] == "leaf") index2 = 0;
            if(card.getReqResources()[3] == "insect") index2 = 1;
            if(card.getReqResources()[3] == "animal") index2 = 2;
            if(card.getReqResources()[3] == "mushroom") index2 = 3;

            if(resOnTable[index] >= 3 && resOnTable[index2] >= 1) return true;
        }
        return false;
    }

  
    public void initializeCorners(Cards card){
        int a = 0, b = 0, c = 0, d = 0;
        if(card.getVar1() != null){  a = 1;}
        if(card.getVar2() != null){  b = 1;}
        if(card.getVar3() != null){  c = 1;}
        if(card.getVar4() != null){  d = 1;}

        corners.add(new int[]{ a, b, c, d});
    }



    public synchronized String addCard(Player player, Cards playableCard, int index, int corner, BufferedReader in, PrintWriter out) throws IOException {

        initializeCorners(playableCard);

        do {
            switch (corner) {
                case 1:
                    if (corners.get(index)[0] == 1) {
                        player.getPlayedCards().add(playableCard);
                        setResOnTable(player, playableCard, index, corner);
                        setObjOnTable(player, playableCard, index, corner);
                        card2.add(player.getPlayedCards().size() - 1);
                        card1.add(index);
                        corners.get(index)[0] = 0;
                        corners.get(corners.size() - 1)[3] = 0;
                        cardCorner.add(corner);
                  


                        return addCardTopLeftCorner(player, player.getPlayedCards().get(index), playableCard);
                    } else {
                        out.println("Selected corner 1 not playable, choose another corner:");
                        corner = Integer.parseInt(in.readLine());
                        break;
                    }

                case 2:
                    if (corners.get(index)[1] == 1) {
                        player.getPlayedCards().add(playableCard);
                        setResOnTable(player, playableCard, index, corner);
                        setObjOnTable(player, playableCard, index, corner);
                        card2.add(player.getPlayedCards().size() - 1);
                        card1.add(index);
                        corners.get(index)[1] = 0;
                        corners.get(corners.size() - 1)[2] = 0;
                        cardCorner.add(corner);

                        return addCardTopRightCorner(player, player.getPlayedCards().get(index), playableCard);
                    } else {
                        out.println("Selected corner 2 not playable, choose another corner:");
                        corner = Integer.parseInt(in.readLine());
                        break;
                    }

                case 3:
                    if (corners.get(index)[2] == 1) {
                        player.getPlayedCards().add(playableCard);
                        setResOnTable(player, playableCard, index, corner);
                        setObjOnTable(player, playableCard, index, corner);
                        card2.add(player.getPlayedCards().size() - 1);
                        card1.add(index);
                        corners.get(index)[2] = 0;
                        corners.get(corners.size() - 1)[1] = 0;
                        cardCorner.add(corner);

                        


                        return addCardBottomLeftCorner(player, player.getPlayedCards().get(index), playableCard);
                    } else {
                        out.println("Selected corner 3 not playable, choose another corner:");
                        corner = Integer.parseInt(in.readLine());
                        break;
                    }

                case 4:
                    if (corners.get(index)[3] == 1) {
                        player.getPlayedCards().add(playableCard);
                        setResOnTable(player, playableCard, index, corner);
                        setObjOnTable(player, playableCard, index, corner);
                        card2.add(player.getPlayedCards().size() - 1);
                        card1.add(index);
                        corners.get(index)[3] = 0;
                        corners.get(corners.size() - 1)[0] = 0;
                        cardCorner.add(corner);

                        System.out.println(player.getPlayedCards());
                        System.out.println(card1);
                        System.out.println(card2);
                        System.out.println(cardCorner);
                     


                        return addCardBottomRightCorner(player, player.getPlayedCards().get(index), playableCard);
                    } else {
                        out.println("Selected corner 4 not playable, choose another corner:");
                        corner = Integer.parseInt(in.readLine());
                        break;
                    }

                default:
                    out.println("Invalid corner selected, choose another corner:");
                    corner = Integer.parseInt(in.readLine());
                    break;
            }
        } while (true);
    }


    public String addCardBottomLeftCorner(Player player,Cards start, Cards res) {
        StringBuilder result = new StringBuilder();

        String[] startcardLines = start.getPrettyPrint().split("\n");
        String[] rescardLines = res.getPrettyPrint().split("\n");

        result.append("                      ").append("            (").append(player.getPlayedCards().indexOf(start)).append(")\n");
        for (int i = 0; i < startcardLines.length - 3; i++) {
            result.append("                      ").append(startcardLines[i]).append("\n");
        }
        result.append(rescardLines[0]).append(startcardLines[6].substring(5)).append("\n");
        result.append(rescardLines[1]).append(startcardLines[7].substring(5)).append("\n");
        result.append(rescardLines[2]).append(startcardLines[8].substring(5)).append("\n");

        for (int l = 3; l < rescardLines.length; l++) {
            result.append(rescardLines[l]).append("\n");
        }
        result.append("            (").append(player.getPlayedCards().size() -1).append(")\n");

        return result.toString();
    }

    public String addCardBottomRightCorner(Player player, Cards start, Cards res) {
        StringBuilder result = new StringBuilder();

        String[] startcardLines = start.getPrettyPrint().split("\n");
        String[] rescardLines = res.getPrettyPrint().split("\n");

        result.append("            (").append(player.getPlayedCards().indexOf(start)).append(")\n");
        for (int i = 0; i < startcardLines.length - 3; i++) {
            result.append(startcardLines[i]).append("\n");
        }
        result.append(startcardLines[6].substring(0, startcardLines[6].length() - 5)).append(rescardLines[0]).append("\n");
        result.append(startcardLines[7].substring(0, startcardLines[7].length() - 5)).append(rescardLines[1]).append("\n");
        result.append(startcardLines[8].substring(0, startcardLines[8].length() - 5)).append(rescardLines[2]).append("\n");
        for (int i = 3; i < rescardLines.length; i++) {
            result.append("                      ").append(rescardLines[i]).append("\n");
        }
        result.append("                      ").append("            (").append(player.getPlayedCards().size() -1).append(")\n");
        return result.toString();

    }

    public String addCardTopLeftCorner(Player player, Cards start, Cards res) {
        StringBuilder result = new StringBuilder();


        String[] startcardLines = start.getPrettyPrint().split("\n");
        String[] rescardLines = res.getPrettyPrint().split("\n");

        result.append("            (").append(player.getPlayedCards().size() -1).append(")\n");
        for (int i = 0; i < rescardLines.length - 3; i++) {
            result.append(rescardLines[i]).append("\n");
        }
        result.append(rescardLines[6]).append(startcardLines[0].substring(5)).append("\n");
        result.append(rescardLines[7]).append(startcardLines[1].substring(5)).append("\n");
        result.append(rescardLines[8]).append(startcardLines[2].substring(5)).append("\n");
        for (int i = 3; i < startcardLines.length; i++) {
            result.append("                      ").append(startcardLines[i]).append("\n");
        }
        result.append("                      ").append("            (").append(player.getPlayedCards().indexOf(start)).append(")\n");

        return result.toString();
    }
    
    public String addCardTopRightCorner(Player player, Cards start, Cards res) {
        StringBuilder result = new StringBuilder();


        String[] startcardLines = start.getPrettyPrint().split("\n");
        String[] rescardLines = res.getPrettyPrint().split("\n");

        result.append("                      ").append("            (").append(player.getPlayedCards().size() -1).append(")\n");
        for (int i = 0; i < rescardLines.length - 3; i++) {
            result.append("                      ").append(rescardLines[i]).append("\n");
        }
        result.append(startcardLines[0].substring(0, startcardLines[0].length() - 5)).append(rescardLines[6]).append("\n");
        result.append(startcardLines[1].substring(0, startcardLines[1].length() - 5)).append(rescardLines[7]).append("\n");
        result.append(startcardLines[2].substring(0, startcardLines[2].length() - 5)).append(rescardLines[8]).append("\n");
        for (int i = 3; i < startcardLines.length; i++) {
            result.append(startcardLines[i]).append("\n");
        }
        result.append("            (").append(player.getPlayedCards().indexOf(start)).append(")\n");

        return result.toString();
    }


    public void prettyPrint(String cardsOnTable, PrintWriter out) {
        out.print(cardsOnTable);
    }
    

    public static void main(String[] args) {
        // Test the Table class methods here if needed
    }
}
