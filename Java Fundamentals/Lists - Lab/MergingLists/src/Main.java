import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        List<Integer> numbers1 = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> numbers2 = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < Math.min(numbers1.size(), numbers2.size()); i++) {
            result.add(numbers1.get(i));
            result.add(numbers2.get(i));
        }

        if (numbers1.size() > numbers2.size()) {
            result.addAll(getRemainingElements(numbers1, numbers2));
        } else if (numbers2.size() > numbers1.size()) {
            result.addAll(getRemainingElements(numbers2, numbers1));
        }

        System.out.println(result.toString().replaceAll("[\\[\\],]", ""));
    }

    public static List<Integer> getRemainingElements(List<Integer> longerList, List<Integer> shorterList) {

        List<Integer> nums = new ArrayList<>();

        for (int i = shorterList.size(); i < longerList.size(); i++) {
            nums.add(longerList.get(i));
        }

        return nums;
    }
}