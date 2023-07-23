package Utils;

public class MyUtil {

	/* Color */
	
	public static String BLACK = "\033[90m";
	public static String RED = "\033[91m";
	public static String GREEN = "\033[92m";
	public static String YELLOW = "\033[93m";
	public /*final*/ static String BLUE = "\033[94m";
	public static String MAGENTA = "\033[95m";
	public static String CYAN = "\033[96m";
	public static String WHITE = "\033[97m";
	public static String END = "\033[0m";
	
	
	public static String REDBG = "\033[101m";
	public static String GREENBG = "\033[102m";
	
	/* Effect */
	
	public static String BOLD = "\033[1m";
	public static String INTENSITY = "\033[2m";
	public static String ITALIC= "\033[3m";
	public static String UNDERLINE = "\033[4m";
	public static String NEGATIVE = "\033[7m";
	public static String CROSSEDOUT = "\033[9m";
	public static String DOUBLEUNDERLINE = "\033[21m";
	
	
	public static void p(String str) {
		System.out.println(str); 
	}
	
	public static void p(int num) {
		System.out.println(num); 
	
	}
}
