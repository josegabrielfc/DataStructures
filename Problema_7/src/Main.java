/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author ANDRES
 */
public class Main {

    public static String[] findRelativeRanks(int[] nums) {
        String[] result = new String[nums.length];
        Map<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        int index = 1;
        for (Integer value : map.values()) {
            result[value] = String.valueOf(index);
            index++;
        }

        for (int i = 0; i < result.length; i++) {
            if (result[i].equals("1")) {
                result[i] = "Gold Medal";
            }
            if (result[i].equals("2")) {
                result[i] = "Silver Medal";
            }
            if (result[i].equals("3")) {
                result[i] = "Bronze Medal";
            }
        }
        return result;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int casos = 0;
        int pass = 0;
        GenerarDatos gd = new GenerarDatos();
        if (args.length == 1) {
            casos = Integer.parseInt(args[0]);
            pass = 1;
        } else if (args.length > 1) { //java Main "archivo txt a leer" "numero de pruebas"
            System.out.println("");
            int tam = Integer.parseInt(args[1]);
            int arr[] = new int[tam];
            String resultado = "";
            for (int i = 0; i < tam; i++) {
                gd.llenarArregloTxt(arr, i, args[0]);
                resultado += Arrays.toString(findRelativeRanks(gd.llenarArregloTxt(arr, i, args[0]))) + "\n";
                System.out.println(Arrays.toString(findRelativeRanks(gd.llenarArregloTxt(arr, i, args[0]))));
            }
            gd.Resultado(resultado);
        } else {
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese la cantidad de pruebas que desea realizar:");
            casos = sc.nextInt();
            pass = 1;
        }
        if (pass == 1) {
            int num[] = new int[casos];
            String resultado = "";

            //System.out.println(Arrays.toString(findRelativeRanks(num))); 
            gd.generarDatosSinRepetir(num.length, casos);
            for (int i = 0; i < casos; i++) {
                //System.out.println(i);
                resultado += Arrays.toString(findRelativeRanks(gd.llenarArregloNuevo(num, i))) + "\n";
                System.out.println(Arrays.toString(findRelativeRanks(gd.llenarArregloNuevo(num, i))));
            }
            gd.Resultado(resultado);
        }

    }

}
