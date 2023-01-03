package funtest;

import java.util.Random;
public class Test {
    public String random_name(){
        Random random = new Random();
        int char_int = random.nextInt(7);
        String result = switch (char_int) {
            case 1 -> "Yessica";
            case 2 -> "Nora";
            case 3 -> "Momon";
            case 4 -> "Francisco";
            case 5 -> "Yara";
            case 6 -> "Yocelin";
            case 7 -> "Hugo";
            default -> "Jaiber";  
        };
        return result;
    }
    public String random_last_name(){
        Random random = new Random();
        int char_int = random.nextInt(4);
        String result = switch (char_int) {
            case 1 -> "Yenova";
            case 2 -> "Nullverto";
            case 3 -> "Mora";
            case 4 -> "Feniberto";
            case 5 -> "Fuentes";
            case 6 -> "Carrero";
            case 7 -> "Flores";
            default -> "Arellano";  
        };
        return result;
    }
    public int random_age(){
        Random random = new Random();
        int age = random.nextInt(25);
        return age;
    }
    public float random_height(){
        Random random = new Random();
        float height = (150+random.nextInt(50) + random.nextFloat());
        return height;
    }
    public double random_weight(){
        Random random = new Random();
        double weight = (30+random.nextInt(60)+random.nextDouble());
        return weight;
    }
    public char random_char(){
        Random random = new Random();
        int char_int = random.nextInt(4);
        char result = switch (char_int) {
            case 1 -> 'Y';  case 2 -> 'N';  case 3 -> 'M';  case 4 -> 'F';
            default -> '0';  
        };
        return result;
    }
    public void enlarge_arr_test(func[] arr){
        func[] auxiliar = new func[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            auxiliar[i] = arr[i];
        }
        arr = auxiliar;
    }

    public static void main(String[] args) {
    Test testObj = new Test();
    Random random = new Random();
    String name = testObj.random_name();
    String last_name = testObj.random_last_name();
    System.out.println("The number are random\n age: 0~25\nheight: 150~200cm\nweight: 30~90kg");
    
    func funcObj = new func();

    func[] array = new func[4+random.nextInt(5)];

    for (int i = 0; i < array.length; i++) {
        array[i] = new func(testObj.random_name(), testObj.random_last_name(), testObj.random_age(), 
            testObj.random_height(),testObj.random_weight(), testObj.random_char());
    }

    for (func a : array) {
        System.out.println("\n\n");
        System.out.println("Data del " + a + "es: ");
        System.out.println("Name: "+ a.name +"\nLast Name: "+ a.last_name +"\nAge: "+ a.age +
            "\nHeight: "+ a.height +"\nWeight: "+ a.weight +"\nSex: "+ a.sex);
    }
    System.out.println("\n\nEl Tamaño del Array es: " + array.length);
    System.out.println(".\n.\n[Intentar llamar a ver si 13.]\n.\n.");

    testObj.enlarge_arr_test(array);
    System.out.println("\n\nEl Tamaño del Array es: " + array.length);
}
}