package Cards;


public class StarterFront extends ResourceFront{

    private Object[] startResources;

    public StarterFront(Object var1, Object var2, Object var3, Object var4, Object[] startResources){
        super(var1, var2, var3, var4, null, 0);
        setStartResources(startResources);
    }

    public Object[] getStartResources(){
        return startResources;
    }

    public void setStartResources(Object[] startResources){
        if (startResources.length == 1 || startResources.length == 2 ||startResources.length == 3) {
            this.startResources = startResources;
        } else {
            throw new IllegalArgumentException("req_resources must have either 3, 4, or 5 values");
        }
    }

    protected String constructPrettyPrint(){

        String middle1 = "";
        String middle2 = "";
        String middle3 = "";

        String up1 = "";
        String up2 = "";
        String up3 = "";

        String down1 = "";
        String down2 = "";
        String down3 = "";

        if(getVar1() != null && getVar2() != null && getVar3() != null && getVar4() != null && getStartResources().length == 1) {
            up1 = "┌---┐-----------------┌---┐\n";
            up2 = "| " + makeCode(getVar1()) + "|                 | " +makeCode(getVar2()) + "|\n";
            up3 = "└---┘                 └---┘\n";
            middle1 = "|          ┌---┐          |\n";
            middle2 = "|          | " + makeCode(getStartResources()[0]) + "|          |\n";
            middle3 = "|          └---┘          |\n";
            down1 = "┌---┐                 ┌---┐\n";
            down2 = "| " + makeCode(getVar3()) + "|                 | " + makeCode(getVar4()) + "|\n";
            down3 = "└---┘-----------------└---┘\n";

        }

        if(getVar1() != null && getVar2() != null && getVar3() != null && getVar4() != null && getStartResources().length == 2){
            up1 = "┌---┐-----------------┌---┐\n";
            up2 = "| " + makeCode(getVar1()) + "|                 | " +makeCode(getVar2()) + "|\n";
            up3 = "└---┘      ┌---┐      └---┘\n";
            middle1 = "|          | " + makeCode(getStartResources()[0]) + "|          |\n";
            middle2 = "|          | " + makeCode(getStartResources()[1]) + "|          |\n";
            middle3 = "|          └---┘          |\n";
            down1 = "┌---┐                 ┌---┐\n";
            down2 = "| " + makeCode(getVar3()) + "|                 | " + makeCode(getVar4()) + "|\n";
            down3 = "└---┘-----------------└---┘\n";
        }

        if(getVar1() != null && getVar2() != null && getVar3() == null && getVar4() == null && getStartResources().length == 3){
            up1 = "┌---┐-----------------┌---┐\n";
            up2 = "| " + makeCode(getVar1()) + "|                 | " +makeCode(getVar2()) + "|\n";
            up3 = "└---┘      ┌---┐      └---┘\n";
            middle1 = "|          | " + makeCode(getStartResources()[0]) + "|          |\n";
            middle2 = "|          | " + makeCode(getStartResources()[1]) + "|          |\n";
            middle3 = "|          | " + makeCode(getStartResources()[2]) + "|          |\n";
            down1 = "|          └---┘          |\n";
            down2 = "|                         |\n";
            down3 = "└-------------------------┘\n";
        }


        return new StringBuilder()

                .append(up1)
                .append(up2)
                .append(up3)
                .append(middle1)
                .append(middle2)
                .append(middle3)
                .append(down1)
                .append(down2)
                .append(down3)
                .toString();
    }

    public void prettyPrint() {
        System.out.print(constructPrettyPrint());
    }


    public String getPrintBack(){

        if( getVar1() == "empty" && getVar2() == "leaf" && getVar3() == "insect" && getVar4() == "empty"){
            setVar1("mushroom");
            setVar2("leaf");
            setVar3("insect");
            setVar4("animal");
        }

        if( getVar1() == "animal" && getVar2() == "empty" && getVar3() == "empty" && getVar4() == "mushroom"){
            setVar1("leaf");
            setVar2("animal");
            setVar3("mushroom");
            setVar4("insect");
        }

        if( getVar1() == "empty" && getVar2() == "empty" && getVar3() == "empty" && getVar4() == "empty"){
            setVar1("insect");
            setVar2("animal");
            setVar3("mushroom");
            setVar4("leaf");
        }

        if( getVar1() == "animal" && getVar2() == "empty" && getVar3() == "empty" && getVar4() == "mushroom"){
            setVar1("leaf");
            setVar2("insect");
            setVar3("animal");
            setVar4("mushroom");
        }

        if( getVar1() == "empty" && getVar2() == "empty" && getVar3() == null && getVar4() == null){
            setVar1("insect");
            setVar2("mushroom");
            setVar3("leaf");
            setVar4("animal");
        }

        if( getVar1() == "empty" && getVar2() == "empty" && getVar3() == null && getVar4() == null){
            setVar1("mushroom");
            setVar2("animal");
            setVar3("leaf");
            setVar4("insect");
        }

        return new StringBuilder()
                .append("┌---┐-----------------┌---┐\n")
                .append("| " + makeCode(getVar1()) + "|                 | " +makeCode(getVar2()) + "|\n")
                .append("└---┘                 └---┘\n")
                .append("|                         |\n")
                .append("|                         |\n")
                .append("|                         |\n")
                .append("┌---┐                 ┌---┐\n")
                .append("| " + makeCode(getVar3()) + "|                 | " + makeCode(getVar4()) + "|\n")
                .append("└---┘-----------------└---┘\n")
                .toString();
    }

    public String toString() {
        return constructPrettyPrint();
    }

}
