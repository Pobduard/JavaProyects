import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        Scanner scan = new Scanner(System.in);
        System.out.println("@");
        System.out.println(System.getProperty("user.dir"));
        ArrayList<String> SongRootsList = new ArrayList<>(1);
        File_handeling getSongs = new File_handeling(SongRootsList);    // * lo hice que se actualicen las canciones al instanciar el objeto, entonces realmente no lo uso pa mas, quizas sirve de algo dejarlo ahi, tipo
                                                                        // * Revolver las canciones desde aquio o asi y hacer todo lo de abajo denuevo pero en su respectiva posicion entonces
                                                                        
                                                                        // *Los Achivos deberian de mostarse aqui con eso, porque el ArrayList Ya se actualizo
        for (int i = 0; i < SongRootsList.size(); i++) {
            System.out.println("Song #" + i + ": " + SongRootsList.get(i));
        }
        
        Sound_functionality play = new Sound_functionality(SongRootsList);
        play.sort(SongRootsList);


        Integer quitDesicion = 0;

        do {
            System.out.println("Enter the position of the Song ya wanna play");
            Integer posicion = 0;
                    try {
                        posicion = scan.nextInt();      
                        scan.nextLine();
                    } catch (Exception InputMismatchException) {
                        continue;
                    }
                    play.start(play.clipList, posicion);

            System.out.println("Wanna change the song? if so give a number");
                try {
                    posicion = scan.nextInt();      
                    scan.nextLine();
                    play.stop(play.clipList, posicion);
                    play.start(play.clipList, posicion);
                } catch (Exception InputMismatchException) {
                    System.out.println("So ya dont wanna, respect");
                }


            System.out.println("Wanna Quit? Yes (1) no (0)");
            try {
                quitDesicion = scan.nextInt();
                scan.nextLine();
            } catch (Exception InputMismatchException) {
                continue;
            }
                    if(quitDesicion == 1){
                        play.stop(play.clipList, posicion);
                    }} while(quitDesicion != 1);

                    
            scan.close();
    }
}