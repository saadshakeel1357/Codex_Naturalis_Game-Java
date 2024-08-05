package Cards;

import java.util.Arrays;

public class GoldFront extends ResourceFront {
    private Object point; 
    private Object cond_point; 
    private Object[] req_resources;
    

    public GoldFront(Object var1, Object var2, Object var3, Object var4, Object kingdom, Object point, Object cond_point, Object[] req_resources) {
        super(var1, var2, var3, var4, kingdom, (point instanceof Integer ? (int) point : 0)); // Call the parent class (ResourceFront) parameterized constructor with point
        this.cond_point = cond_point;
        setPoint(point); 
        setReqResources(req_resources); 
    }


    public Object[] getReqResources() {
        return req_resources;
    }


    public void setReqResources(Object[] req_resources) {
        if (req_resources.length == 3 || req_resources.length == 4 || req_resources.length == 5) {
            this.req_resources = req_resources;
        } else {
            throw new IllegalArgumentException("req_resources must have either 3, 4, or 5 values");
        }
    }


    @Override
    public int getPoint() {
        if (point instanceof Integer) {
            return (int) point;
        } else {
            return 1; // If point is not an Integer, it must be the conditional case
        }
    }


    public void setPoint(Object point) {
        if (point instanceof Integer) {
            int intPoint = (int) point;
            if (cond_point == null) {
                if (intPoint == 1 || intPoint == 3 || intPoint == 5) {
                    this.point = intPoint;
                    if (intPoint == 1) {
                        this.cond_point = new Object[]{1, "cond"};
                    }
                } else {
                    throw new IllegalArgumentException("Point must be either 1, 3, or 5 when cond_point is null");
                }
            } else {
                if (intPoint == 1 || intPoint == 2) {
                    this.point = intPoint;
                } else {
                    throw new IllegalArgumentException("Point must be either 1 or 2 when cond_point is not null");
                }
            }
        } else if (point instanceof Object[]) {
            this.point = point; 
            this.cond_point = (Object[]) point;
        } else {
            throw new IllegalArgumentException("Point must be either an Integer (1, 2, 3, or 5) or an Object[] for conditional");
        }
    }

    // Getter for conditional point (if needed)
    public Object getConditionalPoint() {
        return cond_point;
    }


    protected String constructPrettyPrint() {

        String middle = "|                         |\n";

        String up1 = "";
        String up2 = "";
        String up3 = "" ;

        if(getVar1()==null && getVar2()==null && getConditionalPoint() == null){
            up1 = "┌-------------------------┐\n";
            up2 = "|            " + getPoint() + "            |\n";
            up3 = "|                         |\n";
        }

        if(getVar1()==null && getVar2()==null && getConditionalPoint() != null){
            up1 = "┌-------------------------┐\n";
            up2 = "|           " + getPoint() + " " + makeCode(getConditionalPoint()) +"          |\n";
            up3 = "|                         |\n";
        }

        if(getVar1()!= null && getVar2()==null && getConditionalPoint() == null){
            up1 = "┌---┐---------------------┐\n";
            up2 = "| " + makeCode(getVar1()) + "|        " + getPoint() +"            |\n";
            up3 = "└---┘                     |\n";
        }

        if(getVar1()!= null && getVar2()==null && getConditionalPoint() != null){
            up1 = "┌---┐---------------------┐\n";
            up2 = "| " + makeCode(getVar1()) + "|       " + getPoint() + " " + makeCode(getConditionalPoint()) +"          |\n";
            up3 = "└---┘                     |\n";
        }

        if(getVar1()== null && getVar2()!=null && getConditionalPoint() == null){
            up1 = "┌---------------------┌---┐\n";
            up2 = "|            "  + getPoint() + "        | " + makeCode(getVar2()) + "|\n";
            up3 = "|                     └---┘\n";
        }

        if(getVar1()== null && getVar2()!=null && getConditionalPoint() != null){
            up1 = "┌---------------------┌---┐\n";
            up2 = "|           "  + getPoint() + " " + makeCode(getConditionalPoint()) + "      | " +makeCode(getVar2()) + "|\n";
            up3 = "|                     └---┘\n";
        }

        if(getVar1() != null && getVar2()!=null && getConditionalPoint() == null){
            up1 = "┌---┐-----------------┌---┐\n";
            up2 = "| " + makeCode(getVar1()) + "|        " + getPoint() + "        | " +makeCode(getVar2()) + "|\n";
            up3 = "└---┘                 └---┘\n";
        }

        if(getVar1() != null && getVar2()!=null && getConditionalPoint() != null){
            up1 = "┌---┐-----------------┌---┐\n";
            up2 = "| " + makeCode(getVar1()) + "|       " + getPoint() + " " + makeCode(getConditionalPoint()) + "      | " +makeCode(getVar2()) + "|\n";
            up3 = "└---┘                 └---┘\n";
        }

        String down1 = "";
        String down2 = "";
        String down3 = "";


        //for 5 resources
        if(getVar3() == null && getVar4() == null && getReqResources().length == 5){
            down1 = "|                         |\n";
            down2 = "|        " + makeCode(getReqResources()[0]) + makeCode(getReqResources()[1]) + makeCode(getReqResources()[2]) + makeCode(getReqResources()[3]) + makeCode(getReqResources()[4]) + "      |\n";
            down3 = "└-------------------------┘\n";
        }

        if(getVar3() != null && getVar4() == null && getReqResources().length == 5){
            down1 = "┌---┐                     |\n";
            down2 = "| " + makeCode(getVar3()) + "|   " + makeCode(getReqResources()[0]) + makeCode(getReqResources()[1]) + makeCode(getReqResources()[2]) + makeCode(getReqResources()[3]) + makeCode(getReqResources()[4]) + "       |\n";
            down3 = "└---┘---------------------┘\n";

        }

        if(getVar3() == null && getVar4() != null && getReqResources().length == 5){
            down1 = "┌                     ┌---┐\n";
            down2 = "|       " + makeCode(getReqResources()[0]) + makeCode(getReqResources()[1]) + makeCode(getReqResources()[2]) + makeCode(getReqResources()[3]) + makeCode(getReqResources()[4]) +"   | " + makeCode(getVar4()) + "|\n";
            down3 = "└---------------------└---┘\n";

        }

        if(getVar3() != null && getVar4() != null && getReqResources().length == 5){
            down1 = "┌---┐                 ┌---┐\n";
            down2 = "| " + makeCode(getVar3()) + "|   " + makeCode(getReqResources()[0]) + makeCode(getReqResources()[1]) + makeCode(getReqResources()[2]) + makeCode(getReqResources()[3]) + makeCode(getReqResources()[4]) + "   | " + makeCode(getVar4()) + "|\n";
            down3 = "└---┘-----------------└---┘\n";

        }


        //for 4 resources
        if(getVar3() == null && getVar4() == null && getReqResources().length == 4){
            down1 = "|                         |\n";
            down2 = "|          " + makeCode(getReqResources()[0]) + makeCode(getReqResources()[1]) + makeCode(getReqResources()[2]) + makeCode(getReqResources()[3]) + "      |\n";
            down3 = "└-------------------------┘\n";
        }

        if(getVar3() != null && getVar4() == null && getReqResources().length == 4){
            down1 = "┌---┐                     |\n";
            down2 = "| " + makeCode(getVar3()) + "|    " + makeCode(getReqResources()[0]) + makeCode(getReqResources()[1]) + makeCode(getReqResources()[2]) + makeCode(getReqResources()[3]) + "        |\n";
            down3 = "└---┘---------------------┘\n";

        }

        if(getVar3() == null && getVar4() != null && getReqResources().length == 4){
            down1 = "┌                     ┌---┐\n";
            down2 = "|        " + makeCode(getReqResources()[0]) + makeCode(getReqResources()[1]) + makeCode(getReqResources()[2]) + makeCode(getReqResources()[3]) + "    | " + makeCode(getVar4()) + "|\n";
            down3 = "└---------------------└---┘\n";

        }

        if(getVar3() != null && getVar4() != null && getReqResources().length == 4){
            down1 = "┌---┐                 ┌---┐\n";
            down2 = "| " + makeCode(getVar3()) + "|    " + makeCode(getReqResources()[0]) + makeCode(getReqResources()[1]) + makeCode(getReqResources()[2]) + makeCode(getReqResources()[3]) + "    | " + makeCode(getVar4()) + "|\n";
            down3 = "└---┘-----------------└---┘\n";

        }


        //for 3 resources
        if(getVar3() == null && getVar4() == null && getReqResources().length == 3){
            down1 = "|                         |\n";
            down2 = "|          " + makeCode(getReqResources()[0]) + makeCode(getReqResources()[1]) + makeCode(getReqResources()[2]) + "         |\n";
            down3 = "└-------------------------┘\n";
        }

        if(getVar3() != null && getVar4() == null && getReqResources().length == 3){
            down1 = "┌---┐                     |\n";
            down2 = "| " + makeCode(getVar3()) + "|      " + makeCode(getReqResources()[0]) + makeCode(getReqResources()[1]) + makeCode(getReqResources()[2]) + "         |\n";
            down3 = "└---┘---------------------┘\n";

        }

        if(getVar3() == null && getVar4() != null && getReqResources().length == 3){
            down1 = "┌                     ┌---┐\n";
            down2 = "|          " + makeCode(getReqResources()[0]) + makeCode(getReqResources()[1]) + makeCode(getReqResources()[2]) +"    | " + makeCode(getVar4()) + "|\n";
            down3 = "└---------------------└---┘\n";

        }

        if(getVar3() != null && getVar4() != null && getReqResources().length == 3){
            down1 = "┌---┐                 ┌---┐\n";
            down2 = "| " + makeCode(getVar3()) + "|      " + makeCode(getReqResources()[0]) + makeCode(getReqResources()[1]) + makeCode(getReqResources()[2]) +"    | " + makeCode(getVar4()) + "|\n";
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


    public void prettyPrint() {
        System.out.print(constructPrettyPrint());
    }


    @Override
    public String getType() {
        return "Gold";
    }

    @Override
    public String toString() {
        return "GoldFront{" +
                "var1=" + getVar1() +
                ", var2=" + getVar2() +
                ", var3=" + getVar3() +
                ", var4=" + getVar4() +
                ", kingdom=" + getKingdom() +
                ", point=" + (point instanceof Integer ? point : Arrays.toString((Object[]) point)) +
                ", cond_point=" + (cond_point != null ? cond_point : "null") +
                ", req_resources=" + Arrays.toString(req_resources) +
                '}';
    }
}