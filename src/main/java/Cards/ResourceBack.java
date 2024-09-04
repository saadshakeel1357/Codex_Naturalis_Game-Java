package Cards;

public class ResourceBack extends Resource {

    public ResourceBack(Object var1, Object var2, Object var3, Object var4, Object kingdom) {
        super("empty", "empty", "empty", "empty", kingdom, 0); 
    }

    // will modify this later
    // Override the setPoint method to prevent changing the point value
    @Override
    public void setPoint(int point) {
        super.setPoint(0); // Always set point to 0
    }

    @Override
    public String toString() {
        return "ResourceBack{" +
                "var1=" + getVar1() +
                ", var2=" + getVar2() +
                ", var3=" + getVar3() +
                ", var4=" + getVar4() +
                ", resource=" + getKingdom() +
                ", point=" + getPoint() +
                '}';
    }
}
