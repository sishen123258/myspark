package first.bean;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.EnumSet;

public enum Events {

	IMPRESSION, CLICK, CONVERSION,

	// default
	ATTRIBUTION, ATTRIBUTION_IMP, ATTRIBUTION_CLK,

	IMP_ATTR_FREQUENCY, IMP_CLK_FREQUENCY, CLK_ATTR_FREQUENCY, CLK_FREQUENCY;

	public static EnumSet<Events> CORE = EnumSet.of(IMPRESSION, CLICK,
			CONVERSION);

	public static EnumSet<Events> IMP_CLK_FREQUENCY_EVENTS = EnumSet.of(
			IMPRESSION, CLICK);

	public static EnumSet<Events> IMP_ATTR_FREQUENCY_EVENTS = EnumSet.of(
			IMPRESSION, ATTRIBUTION);

	public static EnumSet<Events> FREQUENCY_EVENTS = EnumSet.of(IMPRESSION, CLICK,
			ATTRIBUTION);

	static EnumSet<Events> CONVERSION_SET = EnumSet.of(CONVERSION, ATTRIBUTION,
			ATTRIBUTION_IMP, ATTRIBUTION_CLK);

	static EnumSet<Events> ATTRIBUTION_SET = EnumSet.of(ATTRIBUTION,
			ATTRIBUTION_IMP, ATTRIBUTION_CLK);

	public static EnumSet<Events> FREQUENCY_SET = EnumSet.of(IMP_ATTR_FREQUENCY,
			IMP_CLK_FREQUENCY, CLK_ATTR_FREQUENCY, CLK_FREQUENCY);

	public static boolean isConversion(Events event) {
		return CONVERSION_SET.contains(event);
	}

	public static boolean isAttribution(Events event) {
		return ATTRIBUTION_SET.contains(event);
	}

	@JsonValue
	public int getValue() {
		return this.ordinal();
	}

	@JsonCreator
	public static Events formValue(int i) {
		return Events.values()[i];
	}
}
