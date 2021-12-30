public class HungryMan {

    private HungryMan() {}

    public static final HungryMan HUNGRY_MAN = new HungryMan();

    public static HungryMan getHungryMan() {
        return HUNGRY_MAN;
    }
}
