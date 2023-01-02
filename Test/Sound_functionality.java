import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

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

    Sound_functionality(ArrayList<String> arr) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        this.SongRoots = arr;
        this.songs = new File[SongRoots.size()];
        this.audioStreamList = new AudioInputStream[songs.length];

        for (int index = 0; index < SongRoots.size(); index++) {    // *Seria mas prudente quizas mandar un ArrayList de Files directamente en vez de uno de Strings para crearlos aqui
            songs[index] = new File(SongRoots.get(index));          // *Para crear los "File" con todas las direcciones de las canciones
            audioStreamList[index] = AudioSystem.getAudioInputStream(songs[index]);
            clipList[index] = AudioSystem.getClip();
        }
//! Usar mejor lo de abajo en futuro, asi el sort se puede usar tambien
//! Iniciar(SongRoots, songs[], audioStreamList[], clipList[])


        
    }

    public void Iniciar(ArrayList<String> this_SongRoots, File[] this_songs, AudioInputStream[] this_audioStreamList, Clip[] this_clipList) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        sort(this_SongRoots);
        for (int index = 0; index < this_SongRoots.size(); index++) {    // Seria mas prudente quizas mandar un ArrayList de Files directamente en vez de uno de Strings para crearlos aqui
            this_songs[index] = new File(this_SongRoots.get(index)); // Para crear los "File" con todas las direcciones de las canciones
            this_audioStreamList[index] = AudioSystem.getAudioInputStream(this_songs[index]);
            this_clipList[index] = AudioSystem.getClip();
        }
    }

    public void sort(ArrayList<String> arr){
        arr.sort(Comparator.naturalOrder());
    }

    public void reverseSort(ArrayList<String> arr){
        arr.sort(Comparator.reverseOrder());
    }


}
