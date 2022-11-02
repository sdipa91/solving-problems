
public class PowerOf2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		powerOf2(5);
	}
	
	 /*
	 * int powerOf2(int n) {
	 * 
	 * int i=0; int power=0; while(power <= n) {
	 * 
	 * }
	 * 
	 * return 0;
	 * 
	 * }
	 */
	
	static int powerOf2(int n) {
		if(n < 1) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			int prev = powerOf2(n/2);
			int curr = prev * 2;
			System.out.println(curr);
			return curr;
		}
	}

}
