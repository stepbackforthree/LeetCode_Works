import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        String line = sc.nextLine();

        for (int i = 0; i < line.length(); ++i) {
            if (line.charAt(i) == '[' || line.charAt(i) == ']' || line.charAt(i) == ',') {
                continue;
            }
            list.add(Integer.parseInt(Character.toString(line.charAt(i))));
        }

        int[] inputs = new int[list.size()];
        int idx = 0;

        for (Integer i : list) {
            inputs[idx++] = i;
        }

        Arrays.sort(inputs);


        int layer = 1;
        int result = 0;
        if (inputs.length < 3) {
            for (int i = 0; i < inputs.length; i++) {
                result += inputs[i];
            }
        } else {
            for (int i = inputs.length - 1; i >= 0; i--) {
                if (i == 1) {
                    result += inputs[1] * layer + inputs[0] * layer;
                    break;
                }

                result += inputs[i] * layer;
                layer++;
            }
        }

        System.out.println(result);
    }
}
