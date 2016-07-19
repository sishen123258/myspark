package first.bean;

import java.util.EnumSet;

public enum ATRBModel {

	DEFAULT, LAST, FIRST, LINEAR, RANKING, TIME_DECAY;

	static EnumSet<ATRBModel> SIMPLE_SET = EnumSet.of(DEFAULT, LAST, FIRST);

	static EnumSet<ATRBModel> COMPLEX_SET = EnumSet.of(LINEAR, RANKING,
			TIME_DECAY);

	public static boolean isDefault(ATRBModel atrb) {
		return DEFAULT.equals(atrb);
	}

	public static boolean isSimple(ATRBModel atrb) {
		return SIMPLE_SET.contains(atrb);
	}

	public static boolean isComplex(ATRBModel atrb) {
		return COMPLEX_SET.contains(atrb);
	}
}
