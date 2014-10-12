public class TestModel extends Base {
	@TestAnnotation(value_test = "value")
	private String hasAnnotation;
	@TestAnnotation(test_test = "value2")
	public String hasAnnotation2;
	public String noAnnotation;

}
