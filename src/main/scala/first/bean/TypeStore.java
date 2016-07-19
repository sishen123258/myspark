package first.bean;


import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public class TypeStore {

	public static String getName(Enum<?> type) {
		String key = String.format("%s.%s", type.getClass().getSimpleName()
				.toLowerCase(), type.name().toLowerCase());

		return PropertyResources.getProperty(key, type.name());
	}

	@SuppressWarnings("rawtypes")
	static Map storeMap = new HashMap<>();

	@SuppressWarnings("unchecked")
	public static <E extends Enum<E>> E get(Class<E> elementType, int ordinal,
			E defaultVal) {
		Map<Integer, E> map = (Map<Integer, E>) storeMap.get(elementType);
		if (map == null) {
			map = new HashMap<>();
			for (E element : EnumSet.allOf(elementType)) {
				map.put(element.ordinal(), element);
			}
			storeMap.put(elementType, map);
		}

		E type = (E) map.get(ordinal);
		return type == null ? defaultVal : type;
	}

	public static <E extends Enum<E>> E get(Class<E> elementType, int ordinal) {
		return get(elementType, ordinal, null);
	}
}
