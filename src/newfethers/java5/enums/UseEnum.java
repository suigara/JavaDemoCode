package newfethers.java5.enums;

public enum UseEnum {
	TYPE1(0), TYPE2(3), TYPE3(8);

	private int myType;

	private UseEnum(int type) {
		myType = type;
	}

	public int getType() {
		return myType;
	}
}
