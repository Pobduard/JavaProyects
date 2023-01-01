import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/* 
 * Aqui se va a suponer que ya creamos el archivo y demas, osea que con la otra clase que ya se creo y uso "Teoricamente"
 * Entonces ya tenemos el ArrayList con la direccion de las canciones, los paths ya en Strings dentro de dicho array
 * Entonces la idea de esta clase es crear funciones con las "opciones" a usar de todo lo relaionado a sonicdos, tons si se usan interfaces Graficas
 * o como sea despues, solo usemos dichas funciones, en teoria almenos, segramente para entonces lo tenga que cambiar pero ya veremos.
 */
public class Sound_functionality {
    ArrayList<String> SongRoots;
    File[] songs;
    AudioInputStream[] audioStreamList;
    Clip[] clipList;

    Sound_functionality(){}

    Sound_functionality(ArrayList arr) throws UnsupportedAudioFileException, IOException{
        this.SongRoots = arr;
        songs = new File[SongRoots.size()];
        audioStreamList = new AudioInputStream[songs.length];

        for (int index = 0; index < SongRoots.size(); index++) {    // Seria mas prudente quizas mandar un ArrayList de Files directamente en vez de uno de Strings para crearlos aqui
            songs[index] = new File(SongRoots.get(index)); // Para crear los "File" con todas las direcciones de las canciones
            audioStreamList[index] = AudioSystem.getAudioInputStream(songs[index]);
            clipList[index] = AudioSystem.getClip();
        }


        
    }


}
