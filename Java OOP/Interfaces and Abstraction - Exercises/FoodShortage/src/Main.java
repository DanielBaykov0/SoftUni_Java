import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Buyer> peoples = new HashMap<>();

        int numberOfPeople = Integer.parseInt(reader.readLine());
        fillPeopleDB(reader, peoples, numberOfPeople);

        String name;
        while (!"End".equals(name = reader.readLine())) {
            if (peoples.containsKey(name)) {
                peoples.get(name).buyFood();
            }
        }

        System.out.println(Food.TOTAL_FOOD_AMOUNT_PURCHASED);
    }

    private static void fillPeopleDB(BufferedReader reader, Map<String, Buyer> peoples, int numberOfPeople) throws IOException {
        for (int i = 0; i < numberOfPeople; i++) {
            String[] tokens = reader.readLine().split("\\s+");

            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            Buyer buyer = null;
            switch (tokens.length) {
                case 4:
                    String id = tokens[2];
                    String birth = tokens[3];
                    buyer = new Citizen(name, age, id, birth);
                    break;
                case 3:
                    String group = tokens[2];
                    buyer = new Rebel(name, age, group);
                    break;
            }
            peoples.putIfAbsent(name, buyer);
        }
    }
}