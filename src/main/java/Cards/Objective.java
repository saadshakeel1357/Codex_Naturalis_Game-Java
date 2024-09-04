package Cards;

public class Objective implements Cards {
    private int point;
    private Object[] objective;
    private String type;
    private String description;

    public Objective(int point, String type, Object[] objective, String description) {
        this.point = point;
        this.type = type;
        this.objective = objective;
        setObjective(objective);
    }

    @Override
    public int getPoint() {
        return point;
    }

    @Override
    public void setPoint(int point) {
        this.point = point;
    }

    public Object[] getObjective() {
        return objective;
    }

    public void setObjective(Object[] objective) {
        if (objective.length == 1 || objective.length == 2 || objective.length == 3) {
            this.objective = objective;
        } else {
            throw new IllegalArgumentException("Objective must have either 1, 2, or 3 values");
        }
    }

    @Override
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Object getVar1() {
        throw new UnsupportedOperationException("Operation not supported");
    }

    @Override
    public void setVar1(Object var1) {
        throw new UnsupportedOperationException("Operation not supported");
    }

    @Override
    public Object getVar2() {
        throw new UnsupportedOperationException("Operation not supported");
    }

    @Override
    public void setVar2(Object var2) {
        throw new UnsupportedOperationException("Operation not supported");
    }

    @Override
    public Object getVar3() {
        throw new UnsupportedOperationException("Operation not supported");
    }

    @Override
    public void setVar3(Object var3) {
        throw new UnsupportedOperationException("Operation not supported");
    }

    @Override
    public Object getVar4() {
        throw new UnsupportedOperationException("Operation not supported");
    }

    @Override
    public void setVar4(Object var4) {
        throw new UnsupportedOperationException("Operation not supported");
    }

    @Override
    public Object getKingdom() {
        throw new UnsupportedOperationException("Operation not supported");
    }

    @Override
    public void setKingdom(Object kingdom) {
        throw new UnsupportedOperationException("Operation not supported");
    }

    protected String constructPrettyPrint() {
        String up1 = "";
        String up2 = "";
        String up3 = "";
        String middle1 = "";
        String middle2 = "";
        String middle3 = "";
        String down1 = "";
        String down2 = "";
        String down3 = "";

        if (getType().equals("objects") && getObjective().length == 2) {
            up1 = "┌-------------------------┐\n";
            up2 = "|                         |\n";
            up3 = "|         " + getPoint() + " points        |\n";
            middle1 = "|                         |\n";
            middle2 = "|          " + Resource.makeCode(getObjective()[0]) + " " + Resource.makeCode(getObjective()[1]) + "          |" + "     2 points per pair of " + getObjective()[0] + "\n";
            middle3 = "|                         |     visible in the play area of the player.\n";
            down1 = "|                         |\n";
            down2 = "|                         |\n";
            down3 = "└-------------------------┘\n";
        }

        if (getType().equals("objects") && getObjective().length == 3) {
            up1 = "┌-------------------------┐\n";
            up2 = "|                         |\n";
            up3 = "|         " + getPoint() + " points        |\n";
            middle1 = "|                         |\n";
            middle2 = "|        " + Resource.makeCode(getObjective()[0]) + " " + Resource.makeCode(getObjective()[1]) + " " + Resource.makeCode(getObjective()[2]) + "        |     3 points per set of 3 different objects\n";
            middle3 = "|                         |     visible in the play area of the player.\n";
            down1 = "|                         |\n";
            down2 = "|                         |\n";
            down3 = "└-------------------------┘\n";
        }

        if (getType().equals("resources")) {
            up1 = "┌-------------------------┐\n";
            up2 = "|                         |\n";
            up3 = "|         " + getPoint() + " points        |\n";
            middle1 = "|                         |\n";
            middle2 = "|            " + Resource.makeCode(getObjective()[0]) + "           |     2 points per set of 3 " + getObjective()[0] + "\n";
            middle3 = "|         " + Resource.makeCode(getObjective()[0]) + "   " + Resource.makeCode(getObjective()[0]) + "         |     visible in the play area of the player.\n";
            down1 = "|                         |\n";
            down2 = "|                         |\n";
            down3 = "└-------------------------┘\n";
        }

        if (getType().equals("vertical pattern") && getObjective()[0].equals("insect")) {
            up1 = "┌-------------------------┐\n";
            up2 = "|         " + getPoint() + " points        |\n";
            up3 = "|       ┌-----┐           |\n";
            middle1 = "|       |  " + Resource.makeCode("animal") + "┌-----┐      |     3 points for each matching of the following pattern:\n";
            middle2 = "|       └----|  " + Resource.makeCode("insect") + " |      |     2 vertical insect cards, the upper one should be\n";
            middle3 = "|            |-----|      |     connected to an animal card on the upper left corner.\n";
            down1 = "|            |  " + Resource.makeCode("insect") + " |      |\n";
            down2 = "|            └-----┘      |\n";
            down3 = "└-------------------------┘\n";
        }

        if (getType().equals("vertical pattern") && getObjective()[0].equals("animal")) {
            up1 = "┌-------------------------┐\n";
            up2 = "|         " + getPoint() + " points        |\n";
            up3 = "|            ┌-----┐      |\n";
            middle1 = "|       ┌-----┐ " + Resource.makeCode("mushroom") + " |      |     3 points for each matching of the following pattern:\n";
            middle2 = "|       |  " + Resource.makeCode("animal") + " |----┘      |     2 vertical animal cards, the upper one should be \n";
            middle3 = "|       |-----|           |     connected to a mushroom card on the upper right corner.\n";
            down1 = "|       |  " + Resource.makeCode("animal") + " |           |\n";
            down2 = "|       └-----┘           |\n";
            down3 = "└-------------------------┘\n";
        }

        if (getType().equals("vertical pattern") && getObjective()[0].equals("leaf")) {
            up1 = "┌-------------------------┐\n";
            up2 = "|         " + getPoint() + " points        |\n";
            up3 = "|                         |\n";
            up3 = "|            ┌-----┐      |\n";
            middle1 = "|            |  " + Resource.makeCode("leaf") + " |      |     3 points for each matching of the following pattern:\n";
            middle2 = "|            |-----|      |     2 vertical leaf cards, the lower one should\n";
            middle3 = "|       ┌----|  " + Resource.makeCode("leaf") + " |      |     be connected to an insect card on the lower left corner.\n";
            down1 = "|       |  " + Resource.makeCode("insect") + "└-----┘      |\n";
            down2 = "|       └-----┘           |\n";
            down3 = "└-------------------------┘\n";
        }

        if (getType().equals("vertical pattern") && getObjective()[0].equals("mushroom")) {
            up1 = "┌-------------------------┐\n";
            up2 = "|         " + getPoint() + " points        |\n";
            up3 = "|       ┌-----┐           |\n";
            middle1 = "|       |  " + Resource.makeCode("mushroom") + " |           |     3 points for each matching of the following pattern:\n";
            middle2 = "|       |-----|           |     2 vertical mushroom cards, the lower one should be\n";
            middle3 = "|       |  " + Resource.makeCode("mushroom") + " |----┐      |     connected to a leaf card on the lower right corner.\n";
            down1 = "|       └-----┘ " + Resource.makeCode("leaf") + " |      |\n";
            down2 = "|            └-----┘      |\n";
            down3 = "└-------------------------┘\n";
        }

        if (getType().equals("diagonal pattern") && (getObjective()[0].equals("leaf") || getObjective()[0].equals("insect"))) {
            up1 = "┌-------------------------┐\n";
            up2 = "|         " + getPoint() + " points        |\n";
            up3 = "|    ┌-----┐              |\n";
            middle1 = "|    |  " + Resource.makeCode(getObjective()[0]) + "┌-----┐         |     2 points for each matching of the following pattern:\n";
            middle2 = "|    └----|  " + Resource.makeCode(getObjective()[0]) + "┌-----┐    |     3 " + getObjective()[0] + " cards following a diagonal between top left and bottom right.\n";
            middle3 = "|         └----|  " + Resource.makeCode(getObjective()[0]) + " |    |\n";
            down1 = "|              └-----┘    |\n";
            down2 = "|                         |\n";
            down3 = "└-------------------------┘\n";
        }

        if (getType().equals("diagonal pattern") && (getObjective()[0].equals("mushroom") || getObjective()[0].equals("animal"))) {
            up1 = "┌-------------------------┐\n";
            up2 = "|         " + getPoint() + " points        |\n";
            up3 = "|              ┌-----┐    |\n";
            middle1 = "|         ┌-----┐ " + Resource.makeCode(getObjective()[0]) + " |    |     2 points for each matching of the following pattern:\n";
            middle2 = "|    ┌-----┐ " + Resource.makeCode(getObjective()[0]) + " |----┘    |     3 " + getObjective()[0] + " cards following a diagonal between top right and bottom left.\n";
            middle3 = "|    |  " + Resource.makeCode(getObjective()[0]) + " |----┘         |\n";
            down1 = "|    └-----┘              |\n";
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

    @Override
    public void prettyPrint() {
        System.out.print(constructPrettyPrint());
    }

    public String printBackFront(Cards card){ return constructPrettyPrint(); }
    
    
    @Override
    public String getPrettyPrint() { 
        return constructPrettyPrint(); 
    }


}
