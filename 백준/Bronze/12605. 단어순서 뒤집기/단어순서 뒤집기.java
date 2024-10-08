import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();
    Stack<String> stack = new Stack<>();
    
    int n = Integer.parseInt(sc.nextLine());
   
    for (int i = 1; i <= n; i++) {
      String str = sc.nextLine();
      String[] arr = str.split(" ");
      for(int j = 0; j < arr.length; j++) stack.push(arr[j]);
      sb.append("Case #" + i + ": ");
      while(!stack.isEmpty()) sb.append(stack.pop()+" ");
      sb.append("\n");
    }
    
    System.out.println(sb);
  }
}