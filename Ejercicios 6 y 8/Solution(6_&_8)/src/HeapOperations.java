
import java.util.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jose Gabriel Fuentes
 */
public class HeapOperations {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());
        Queue<Integer> Q = new PriorityQueue<>();
        StringBuilder ans = new StringBuilder();
        int count = 0;
        while (t > 0) {
            String str = sc.nextLine();
            String[] input = str.split(" ");
            String cmd = input[0];
            int num = 0;
            if (input.length > 1) {
                num = Integer.parseInt(input[1]);
            }
            switch (cmd) {
                case "insert":
                    Q.add(num);
                    break;
                case "removeMin":
                    if (Q.isEmpty()) {
                        ans.append("insert 0\n");
                        count++;
                    } else {
                        Q.remove();
                    }
                    break;
                default:
                    if (Q.isEmpty()) {
                        ans.append("insert ").append(num).append("\n");
                        count++;
                        Q.add(num);
                    } else {
                        int x = Q.peek();
                        while (x < num) {
                            Q.remove();
                            ans.append("removeMin\n");
                            count++;
                            if (Q.isEmpty()) {
                                break;
                            } else {
                                x = Q.peek();
                            }
                        }
                        if (Q.isEmpty() || Q.peek() > num) {
                            ans.append("insert ").append(num).append("\n");
                            Q.add(num);
                            count++;
                        }
                    }
                    break;
            }
            ans.append(str).append("\n");
            count++;
            t--;
        }
        System.out.println(count);
        System.out.println(ans);
    }
}
