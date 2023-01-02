import java.util.ArrayList;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("@");
        System.out.println(System.getProperty("user.dir"));
        ArrayList<String> SongRootsList = new ArrayList<>(1);
        File_handeling getSongs = new File_handeling(SongRootsList);
        // Los Achivos deberian de mostarrse aqui con eso, porque el ArrayList Ya se actualizo
        
/*         for (int i = 0; i < SongRootsList.size(); i++) {
            System.out.println(SongRootsList.get(i));
        } */
    }
}