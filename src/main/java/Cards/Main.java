package Cards;

public class Main {
    public static void main(String[] args) {

        // // testing for front of resource card
        // ResourceFront frontCard = new ResourceFront("mushroom", "plant", "False", "Bottle", "plant", 0);
        // System.out.println("\n" + frontCard.toString() + "\n");
        // frontCard.prettyPrint();

        
        // testing for back of resource card
       // ResourceBack backCard = new ResourceBack("empty", "empty", "empty", "empty", "plant");
        //System.out.println("\n" + backCard.toString() + "\n");
        //backCard.prettyPrint();



        // testing for front of gold card
       // Object[] reqResources = {"animal", "animal", "animal", "animal", "animal"};

       // GoldFront goldCard = new GoldFront("empty", "empty", "empty", "empty", "plant", 2, "plant",  reqResources);

       // System.out.println("\n" + goldCard.toString()+ "\n");
        // goldCard.prettyPrint();


        // // tetsing for back of gold dcard
        // Object[] reqResources = {"plant", "animal", "animal"};

        // GoldBack goldCardback = new GoldBack("empty", "empty", "empty", "empty", "plant");

        // System.out.println("\n" + goldCardback.toString()+ "\n");
        // goldCardback.prettyPrint();

        //GoldFront goldi1 = new GoldFront("animal", "empty", "mushroom", "leaf", "leaf", 2, "bottle", new String[]{"leaf", "leaf","leaf", "animal"});
        //goldi1.prettyPrint();

        ResourceFront front = new ResourceFront("leaf", "leaf", "leaf", "leaf", "leaf", 1);
        front.prettyPrint();

        // StarterFront starter = new StarterFront("empty", "empty", null, null, new String[]{"leaf", "animal", "mushroom" });
        //Objective obi = new Objective(3, "vertical pattern", new String[]{"animal", "feather"}, null);
        //obi.prettyPrint();
        
    }
}