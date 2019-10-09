package dd_12_01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.management.RuntimeErrorException;

public class Test4 {
	public static void main(String[] args) {
		f();
	}

	private static void f() {
		List<String> list = new ArrayList<>();
		Collections.addAll(
				list, 
				"2018-7-9",
				"2018-7-23",
				"2018-7-3",
				"2018-7-21",
				"2018-7-30",
				"2018-7-4");
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date d1 = sdf.parse(o1);
				Date d2 = sdf.parse(o2);
				return d1.compareTo(d2);
				} catch (ParseException e) {
					//包装成能抛出的类型,在抛
					throw new RuntimeException(e);
				}
			}
		});
		System.out.println(list);
	}
}
