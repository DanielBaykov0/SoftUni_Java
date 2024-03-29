package Animals;

public class Mouse extends Mammal {

    private static final String DEFAULT_SOUND = "SQUEEEAAAK!";

    public Mouse(String name, double weight, String livingRegion) {
        super(name, weight, livingRegion);
    }

    @Override
    public String makeSound() {
        return DEFAULT_SOUND;
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Meat) {
            throw new IllegalArgumentException(ConfigExMessage.WRONG_TYPE_FOOD_MOUSE_EX_MESSAGE);
        }
        super.eat(food);
    }
}
