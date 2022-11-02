import java.util.*;
public class Main
{
	  public static void main(String[] args) {
      Scanner in = new Scanner(System. in);
      String s = in.nextLine();
        int[] hash_table = new int[256];
        int n = s.length();
        for (int i = 0; i < n; i++)
        {
            hash_table[s.charAt(i)]++;
        }
        int max_count = 0;
        char ans='a';
        for (int i = 0; i < 256; i++)
        {
            if (hash_table[i] > max_count)
            {
                max_count = hash_table[i];
                ans = (char)i;
            }
        }
    System.out.println("Maximum occurring character is "+ans);
  }
}