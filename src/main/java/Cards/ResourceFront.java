package Cards;

public class ResourceFront extends Resource {

    public ResourceFront(Object var1, Object var2, Object var3, Object var4, Object kingdom, int point) {
        super(var1, var2, var3, var4, kingdom, point); 
    }

    protected String constructPrettyPrint(){

        String middle = "|                         |\n";

        String up1 = "";
        String up2 = "";
        String up3 = "";

        if(getVar1() == null && getVar2() == null && getPoint() == 0){
            up1 = "┌-------------------------┐\n";
            up2 = "|                         |\n";
            up3 = "|                         |\n";
        }

        if(getVar1() == null && getVar2() == null && getPoint() != 0){
            up1 = "┌-------------------------┐\n";
            up2 = "|            " + getPoint() + "            |\n";
            up3 = "|                         |\n";
        }

        if(getVar1() != null && getVar2() == null && getPoint() == 0){
            up1 = "┌---┐---------------------┐\n";
            up2 = "| " + makeCode(getVar1()) + "|                     |\n";
            up3 = "└---┘                     |\n";
        }

        if(getVar1()!= null && getVar2()==null && getPoint() != 0){
            up1 = "┌---┐---------------------┐\n";
            up2 = "| " + makeCode(getVar1()) + "|        " + getPoint() +"            |\n";
            up3 = "└---┘                     |\n";
        }

        if(getVar1()== null && getVar2()!=null && getPoint() == 0){
            up1 = "┌---------------------┌---┐\n";
            up2 = "|                     | " + makeCode(getVar2()) + "|\n";
            up3 = "|                     └---┘\n";
        }

        if(getVar1()== null && getVar2()!=null && getPoint() != 0){
            up1 = "┌---------------------┌---┐\n";
            up2 = "|            "  + getPoint() + "        | " +makeCode(getVar2()) + "|\n";
            up3 = "|                     └---┘\n";
        }

        if(getVar1() != null && getVar2()!=null && getPoint() == 0){
            up1 = "┌---┐-----------------┌---┐\n";
            up2 = "| " + makeCode(getVar1()) + "|                 | " +makeCode(getVar2()) + "|\n";
            up3 = "└---┘                 └---┘\n";
        }

        if(getVar1() != null && getVar2()!=null && getPoint() != 0){
            up1 = "┌---┐-----------------┌---┐\n";
            up2 = "| " + makeCode(getVar1()) + "|        " + getPoint() + "        | " +makeCode(getVar2()) + "|\n";
            up3 = "└---┘                 └---┘\n";
        }

        String down1 = "";
        String down2 = "";
        String down3 = "";

        if(getVar3() == null && getVar4() == null){
            down1 = "|                         |\n";
            down2 = "|                         |\n";
            down3 = "└-------------------------┘\n";
        }

        if(getVar3() != null && getVar4() == null){
            down1 = "┌---┐                     |\n";
            down2 = "| " + makeCode(getVar3()) + "|                     |\n";
            down3 = "└---┘---------------------┘\n";
        }

        if(getVar3() == null && getVar4() != null){
            down1 = "┌                     ┌---┐\n";
            down2 = "|                     | " + makeCode(getVar4()) + "|\n";
            down3 = "└---------------------└---┘\n";
        }

        if(getVar3() != null && getVar4() != null){
            down1 = "┌---┐                 ┌---┐\n";
            down2 = "| " + makeCode(getVar3()) + "|                 | " + makeCode(getVar4()) + "|\n";
            down3 = "└---┘-----------------└---┘\n";
        }

        return new StringBuilder()

                .append(up1)
                .append(up2)
                .append(up3)
                .append(middle)
                .append(middle)
                .append(middle)
                .append(down1)
                .append(down2)
                .append(down3)
                .toString();
    }

    @Override
    public String getType() {
        return "Resource";
    }

    public void prettyPrint() {
        System.out.print(constructPrettyPrint());
    }

    public String getPrettyPrint(){ return constructPrettyPrint(); }
    @Override
    public String toString() {
        return "ResourceFront{" +
                "var1=" + getVar1() +
                ", var2=" + getVar2() +
                ", var3=" + getVar3() +
                ", var4=" + getVar4() +
                ", kingdom=" + getKingdom() +
                ", point=" + getPoint() +
                '}';
    }
}