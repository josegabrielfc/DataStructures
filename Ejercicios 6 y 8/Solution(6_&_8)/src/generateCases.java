
import java.util.*;

/**
 *
 * @author Jose Gabriel Fuentes - 1152085
 */
public class generateCases {

    public static void main(String[] args) {
        int t = 100;
        int cont = 0, cont2 = 0;
        PathExistsGraph path = new PathExistsGraph();
        Scanner sc = new Scanner(System.in);
        System.out.println("Cual de los 2 casos quiere generar:\nDigite 1 si quiere que menos de la mitad sean resultados 'True',\nDigite 2 si quiere que mas de la mitad sean resultados 'True'");
        int caseN = sc.nextInt();
        switch (caseN) {
            case 1:
                while (t-- > 0) {
                    int num = (int) (Math.random() * 12 + 4);
                    int fila = num - 1;
                    int source = (int) (Math.random() * fila), destination = (int) (Math.random() * 12);

                    boolean valid = path.validPath(num, generateMatriz(fila), source, destination);
                    if (valid) {
                        cont++;
                    } else {
                        cont2++;
                    }
                    System.out.println(valid);
                }

                System.out.println("True: " + cont);
                System.out.println("False: " + cont2);
                break;
            case 2:
                while (t-- > 0) {
                    int num = (int) (Math.random() * 8 + 4);
                    int fila = num - 1;
                    int source = (int) (Math.random() * fila), destination = (int) (Math.random() * 4);

                    boolean valid = path.validPath(num, generateMatriz(fila), source, destination);
                    if (valid) {
                        cont++;
                    } else {
                        cont2++;
                    }
                    System.out.println(valid);
                }

                System.out.println("True: " + cont);
                System.out.println("False: " + cont2);
                break;
        }

    }

    public static int[][] generateMatriz(int fila) {
        int matriz[][] = new int[fila][2];
        for (int x = 0; x < matriz.length; x++) {
            for (int y = 0; y < matriz[x].length; y++) {
                matriz[x][y] = (int) (Math.random() * 4);
                //System.out.print(matriz[x][y] + " ");
            }
            //System.out.println("");
        }
        return matriz;
    }

}
