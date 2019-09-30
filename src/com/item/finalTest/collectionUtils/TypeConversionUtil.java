package com.item.finalTest.collectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TypeConversionUtil {
	//  listתmap
	public static <K, V> Map<K, V> list2Map(List<V> list, String keyField) {
		Map<K, V> result = new HashMap<>();
		if (list != null && list.size() > 0 && keyField != null && !"".equals(keyField)) {
			String firstLetter = keyField.substring(0, 1).toUpperCase();
			System.out.println(firstLetter);
			String getter = "get" + firstLetter + keyField.substring(1);
			System.out.println(getter);
			try {
				for (Object obj : list) {
					Method method = obj.getClass().getMethod(getter, null);
					K key = (K) method.invoke(obj, null);
					if (key != null) {
						result.put(key, (V) obj);
					}
				}
			} catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
}
