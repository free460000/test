import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
	static long times = 100000;

	public static void main(String[] args) {
		testSingle();
		testFull();
		testSingle();
		testFull();
		testSingle();
		testFull();
		testSingle();
		testFull();
		testSingle();
		testFull();
		testSingle();
		testSingle();
		testFull();
		testSingle();
		testFull();
		testSingle();
		testFull();
		testSingle();
		testFull();
		testSingle();
		testFull();
		testSingle();
		System.out.println(getDBFieldList(TestModel.class).size());

		Class<?> c = TestModel.class;
		// 测试中文
		for (Field field : c.getDeclaredFields()) {
			Annotation[] anns = field.getDeclaredAnnotations();
			for (Annotation annotation : anns) {
				TestAnnotation testAnnotation = (TestAnnotation) annotation;
				System.out.println(annotation.toString() + "="
						+ testAnnotation.test_test() + "="
						+ testAnnotation.value_test() + "==" + field.getName());
			}
		}

	}

	private static void testFull() {
		long start = System.currentTimeMillis();

		for (int i = 0; i < times; i++) {
			getDBFieldList(TestModel.class);
		}
		System.out.println("Full:" + (System.currentTimeMillis() - start));
	}

	private static void testSingle() {
		long start = System.currentTimeMillis();

		for (int i = 0; i < times; i++) {
			getDBFieldListSmall(TestModel.class);
		}
		System.out.println("Single:" + (System.currentTimeMillis() - start));
	}

	public static List<Field> getDBFieldListSmall(Class<?> modelClass) {
		List<Field> allList = Arrays.asList(modelClass.getFields());
		return allList;
	}

	public static List<Field> getDBFieldList(Class<?> modelClass) {
		List<Field> list = new ArrayList<Field>();
		List<Field> allList = new ArrayList<Field>();
		for (; modelClass != Object.class; modelClass = modelClass
				.getSuperclass()) {
			try {
				for (Field f : modelClass.getDeclaredFields()) {
					allList.add(f);
				}
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
		return allList;
	}

}
