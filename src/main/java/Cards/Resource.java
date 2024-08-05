package Cards;

public class Resource implements Cards {
    private Object var1;
    private Object var2;
    private Object var3;
    private Object var4;
    private Object kingdom;
    private int point;


    public Resource(Object var1, Object var2, Object var3, Object var4, Object kingdom, int point) {
        this.var1 = var1;
        this.var2 = var2;
        this.var3 = var3;
        this.var4 = var4;
        this.kingdom = kingdom;
        this.point = point;
    }

    @Override
    public Object getVar1() {
        return var1;
    }

    @Override
    public void setVar1(Object var1) {
        this.var1 = var1;
    }

    @Override
    public Object getVar2() {
        return var2;
    }

    @Override
    public void setVar2(Object var2) {
        this.var2 = var2;
    }

    @Override
    public Object getVar3() {
        return var3;
    }

    @Override
    public void setVar3(Object var3) {
        this.var3 = var3;
    }

    @Override
    public Object getVar4() {
        return var4;
    }

    @Override
    public void setVar4(Object var4) {
        this.var4 = var4;
    }

    @Override
    public int getPoint() {
        return point;
    }

    @Override
    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public Object getKingdom() {
        return kingdom;
    }

    @Override
    public void setKingdom(Object kingdom) {
        this.kingdom = kingdom;
    }

    // Method to generate unicode representations of symbols/emojis on cards
    public static String makeCode(Object var) {
        String unicode = "  ";

        if(var.equals("empty")){
            unicode = "  ";
            return unicode;
        }
        if (var.equals("leaf")) {
            unicode = "\uD83C\uDF43";
            return unicode;
        }
        if (var.equals("animal")) {
            unicode = "\uD83E\uDD81";
            return unicode;
        }
        if (var.equals("mushroom")) {
            unicode = "\uD83C\uDF44";
            return unicode;
        }
        if (var.equals("insect")) {
            unicode = "\uD83E\uDD8B";
            return unicode;
        }
        if (var.equals("paper")) {
            unicode = "\uD83D\uDCDC";
            return unicode;
        }
        if (var.equals("feather")) {
            unicode = "\uD83D\uDD8B";
            return unicode;
        }
        if (var.equals("bottle")) {
            unicode = "\uD83E\uDDEA";
            return unicode;
        }



        return unicode;
    }

    protected String constructPrettyPrint() {
        return new StringBuilder()
                .append("┌---┐-----------------┌---┐\n")
                .append("| " + makeCode(getVar1()) + "|                 | " + makeCode(getVar2()) + "|\n")
                .append("└---┘                 └---┘\n")
                .append("|          ┌---┐          |\n")
                .append("|          | " + makeCode(getKingdom()) + "|          |\n")
                .append("|          └---┘          |\n")
                .append("┌---┐                 ┌---┐\n")
                .append("| " + makeCode(getVar3()) + "|                 | " + makeCode(getVar4()) + "|\n")
                .append("└---┘-----------------└---┘\n")
                .toString();
    }

    public void prettyPrint() {
        System.out.print(constructPrettyPrint());
    }


    // Method to get the type of the card, to be overwritten in subclasses
    public String getType() {
        return "resource";
    }
}