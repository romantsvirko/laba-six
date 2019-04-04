package lab6;

import java.util.Scanner;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;


public class EqualTo24 {
	
	final int N = 24;	       
	
	public boolean canBeEqualTo24(int[] nums) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        
        int a, b, c, d;
         
        char e, f, g; 
 
        int[] number = nums;
 
        char[] chars = new char[4];
        chars[0] = '*';
        chars[1] = '/';
        chars[2] = '+';
        chars[3] = '-';
 
        String[] solution = new String[7];
        for (int i = 0; i < 7; i++) {
        	solution[i] = "";
        }
        
        String annotation = "Пояснение: из данного набора чисел невозможно составить выражение, равное 24.";
        boolean equalTo24 = false;
        Object result = engine.eval("0");
 
        for (int i = 0; i < 4 && !equalTo24; i++) {
            a = number[i];
            for (int j = 0; j < 4 && !equalTo24; j++) {
                if (j != i) {
                    b = number[j];
                    for (int k = 0; k < 4 && !equalTo24; k++) {
                        if (k != i && k != j) {
                            c = number[k];
                            for (int l = 0; l < 4 && !equalTo24; l++) {
                                if (l != i && l != j && l != k) {
                                    d = number[l];
                                    
                                    for (int m = 0; m < 4 && !equalTo24; m++) {
                                        e = chars[m];
                                        for (int n = 0; n < 4 && !equalTo24; n++) {
                                            f = chars[n];
                                            for (int o = 0; o < 4 && !equalTo24; o++) {
                                                g = chars[o];
                                                
                                                solution[0] = "" + a + e + b + f + c + g + d;
                                                solution[1] = "(" + a + e + b + ")" + f + c + g + d;
                                                solution[2] = "(" + a + e + b + f + c + ")" + g + d;
                                                solution[3] = "" + a + e + "(" + b + f + c + ")" + g + d;
                                                solution[4] = "" + a + e + "(" + b + f + c + g + d + ")";
                                                solution[5] = "" + a + e + b + f + "(" + c + g + d + ")";
                                                solution[6] = "(" + a + e + b + ")" + f + "(" + c + g + d + ")";
 
                                                for (int p = 0; p < 7; p++) {
                                                    result = engine.eval(solution[p]);
                                                    if (result.equals(N)) {
                                                        annotation = "Пояснение: " + solution[p] + " равно 24";
                                                        equalTo24 = true;
                                                        break;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        System.out.println(annotation);
        return equalTo24;
   }
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
        System.out.print("Введите число 1 от 1 до 9  ");
        int a = input.nextInt();
        System.out.print("Введите число 2 от 1 до  ");
        int b = input.nextInt();
        System.out.print("Введите число 3 от 1 до 9  ");
        int c = input.nextInt();
        System.out.print("Введите число 4 от 1 до to 9  ");
        int d = input.nextInt();
		canBeEqualTo24(int[i] =  a, b, c, d);
    }
}