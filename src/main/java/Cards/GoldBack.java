package Cards;

public class GoldBack extends ResourceBack {


    public GoldBack(Object var1, Object var2, Object var3, Object var4, Object kingdom) {
        super(var1, var2, var3, var4, kingdom); 
    }

    @Override
    public String toString() {
        return "GoldBack{" +
                "var1=" + getVar1() +
                ", var2=" + getVar2() +
                ", var3=" + getVar3() +
                ", var4=" + getVar4() +
                ", resource=" + getKingdom() +
                ", point=" + getPoint() +
                '}';
    }

}