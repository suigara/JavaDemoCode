package newfethers.java5.enums;


public final class OldConsts {

    public static final OldConsts TYPE1 = new OldConsts(0);
    public static final OldConsts TYPE2 = new OldConsts(3);
    public static final OldConsts TYPE3 = new OldConsts(8);

    private int myType;

    private OldConsts(int type) {
        myType = type;
    }

    public int getType() {
        return myType;
    }

}
