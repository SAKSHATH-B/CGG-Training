package cgg.defaultandstaticmethods;

import java.util.Collections;
import java.util.List;

public class MyClass implements MyInterface {

	@Override
	public Integer getMaxNum(List<Integer> intList) {
		Integer max = Collections.max(intList);
		return max;
	}

}
