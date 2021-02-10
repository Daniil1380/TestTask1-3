import javafx.util.Pair;

import java.util.*;

public class Tasks {
    public static List<Pair<Integer, Integer>> task1(int[] array){
        //Так или иначе я 1-3 задания в своей жизни уже видел, так что подумал их решить
        //какими-нибудь нетривиальными способами. Кажется с 1 и 3 интересно вышло)
        Map<Integer,Integer> map = new HashMap<>();
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        Arrays.stream(array).forEach(x -> map.put(x , map.getOrDefault(x, 0) + 1));
        map.forEach((key, value) -> list.add(new Pair<>(key, value)));
        list.sort((first, second) -> {
            if (first.getValue() > second.getValue()) return -1;
            else if (first.getValue() < second.getValue()) return 1;
            else return first.getKey() - second.getKey();
        });
        return list;
    }

    public static boolean task2(String regex){
        //скучное, зато рабочее
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < regex.length(); i++) {
            char c = regex.charAt(i);
            if (c == '(' || c == '['){
                stack.push(c);
            }
            else if ((c == ')' && stack.peek() == '(') || (c == ']' && stack.peek() == '[')) {
                stack.pop();
            }
            else return false;
        }
        return true;
    }

    public static int task3(int number){
        //постарался придумать что-то веселое
        String str = String.valueOf(number);
        str = new StringBuilder(str).reverse().toString().replaceFirst("0", "1");
        str = new StringBuilder(str).reverse().toString();
        return Integer.parseInt(str);
    }
}
