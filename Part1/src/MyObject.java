import java.util.*;
import java.util.stream.Collectors;

public class MyObject {

    String name;
    int value;
    boolean bool;

    public MyObject(String inputName, int inputValue, boolean inputBool) {
        this.name = inputName;
        this.bool = inputBool;
        this.value = inputValue;
    }

    public String getName() {
        return this.name;
    }

    public int getValue() {
        return this.value;
    }

    public boolean getBool() {
        return this.bool;
    }

    public void setValues(String inputName, int inputValue, boolean inputBool) {
        this.name = inputName;
        this.bool = inputBool;
        this.value = inputValue;
    }
    public void setName(String inputName) {
        this.name = inputName;
    }

    public String toString() {
        return this.name + ", " + this.value + ", " + this.bool;
    }

    public static void main(String[] args) {

        MyObject[] instanceOf = new MyObject[50];

        for (int i = 0; i < instanceOf.length; i++) {
            instanceOf[i] = new MyObject(randomName(), randomNr(1, 50), randomBool());
        }

        System.out.println("3.0) The values of the random array: ");
        for (int i = 0; i < instanceOf.length; i++) {

            System.out.print((i + 1) + ". ");
            System.out.println(instanceOf[i]);
        }

        System.out.println("\nNext: ");


        part31(instanceOf);
        part32(instanceOf);
        part33(instanceOf);

    }

    public static int randomNr(int minValue, int maxValue) {
        return (int) (Math.random() * (maxValue - minValue + 1) + minValue);
    }

    public static boolean randomBool() {
        Random random = new Random();

        return random.nextBoolean();
    }

    public static String randomName() {

        StringBuilder bWord = new StringBuilder();
        Random random = new Random();


        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        int wordLength = 7;

        for (int i = 0; i < wordLength; i++) {
            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            bWord.append(randomChar);
        }
        return bWord.toString();
    }

    static void part31(MyObject[] inputObjectArray) {

        List<MyObject> resultList = Arrays.asList(inputObjectArray);

        System.out.println("3.1) All objects whose values are above 20 are: " + resultList
                .stream()
                .filter(x -> x.getValue() > 20)
                .sorted(Comparator.comparingInt(MyObject::getValue))
                .collect(Collectors.toList())

        );
    }
    static void part32(MyObject[] inputObjectArray) {

        List<MyObject> resultList = Arrays.asList(inputObjectArray);

        System.out.println("3.2) Average of all values are: " + resultList
                .stream()
                .mapToInt(o -> o.getValue())
                .average()
                .getAsDouble()

        );
    }
    static void part33(MyObject[] inputObjectArray) {

        List<MyObject> resultList = Arrays.asList(inputObjectArray);

        System.out.println("3.3) These are all the true boolean objects: " + resultList
                .stream()
                .filter(MyObject::getBool)
                .peek(e -> e.setName("this is true"))
                .collect(Collectors.toList())
        );
    }


}

