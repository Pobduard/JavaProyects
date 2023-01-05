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
    File[] songs_file;
    AudioInputStream[] audioStreamList;
    Clip[] clipList;
    Long microSecAtribute;
    Integer posicion;

    Sound_functionality(){}

    Sound_functionality(ArrayList<String> arr) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        this.SongRoots = arr;
        this.songs_file = new File[SongRoots.size()];
        this.audioStreamList = new AudioInputStream[songs_file.length];
        this.clipList = new Clip[songs_file.length];

        for (int index = 0; index < SongRoots.size(); index++) {    // *Seria mas prudente quizas mandar un ArrayList de Files directamente en vez de uno de Strings para crearlos aqui
            songs_file[index] = new File(SongRoots.get(index));          // *Para crear los "File" con todas las direcciones de las canciones
            audioStreamList[index] = AudioSystem.getAudioInputStream(songs_file[index]);
            clipList[index] = AudioSystem.getClip();
            clipList[index].open(audioStreamList[index]);
            //System.out.println("\n\n\n" + this.clipList[index]);  //! Si se crean los clips diferentes, logrado
        }
//! Usar mejor lo de abajo en futuro, asi el sort se puede usar tambien
//! Iniciar(SongRoots, songs_file[], audioStreamList[], clipList[])
    }

    public void Iniciar(ArrayList<String> this_SongRoots, File[] this_songs_file, AudioInputStream[] this_audioStreamList, Clip[] this_clipList) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        sort(this_SongRoots);
        for (int index = 0; index < this_SongRoots.size(); index++) {    // Seria mas prudente quizas mandar un ArrayList de Files directamente en vez de uno de Strings para crearlos aqui
            this_songs_file[index] = new File(this_SongRoots.get(index)); // Para crear los "File" con todas las direcciones de las canciones
            this_audioStreamList[index] = AudioSystem.getAudioInputStream(this_songs_file[index]);
            this_clipList[index] = AudioSystem.getClip();
        }
    }

    public void sort(ArrayList<String> arr){
        arr.sort(Comparator.naturalOrder());
    }

    public void reverseSort(ArrayList<String> arr){
        arr.sort(Comparator.reverseOrder());
    }

    public void start(Clip[] this_clip, Integer posicion){
        this_clip[posicion].start();
    }

    public void startAt(Clip[] this_clip, Integer posicion, Long at){
        this_clip[posicion].setMicrosecondPosition(at);
        this_clip[posicion].start();
    }

    public void stop(Clip[] this_clip, Integer posicion){
        this_clip[posicion].stop();
    }

    public void jumpTo(Clip[] this_clip, Integer posicion, Long this_jumpto){
        this_clip[posicion].setMicrosecondPosition(this_jumpto);
        this_clip[posicion].start();
    }

    public long getMicroSecPosition(Clip[] this_clip, Integer posicion){
        return this_clip[posicion].getMicrosecondPosition();
    }

    public long getMicroSecLength(Clip[] this_clip, Integer posicion){
        return this_clip[posicion].getMicrosecondLength();
    }

    public void setMicroSecAtribute(Clip[] this_clip, Integer posicion){
        this.microSecAtribute = this_clip[posicion].getMicrosecondPosition();
    }

    public void setMicroSecPorcentage(Clip[] this_clip, Integer posicion, Integer porciento){
        Long new_microsec = porciento * (getMicroSecLength(this_clip, posicion)/100);   //% * total/100%
        this_clip[posicion].setMicrosecondPosition(new_microsec);
        setMicroSecAtribute(this_clip, posicion);
    }
}
