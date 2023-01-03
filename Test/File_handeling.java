import java.io.File;
import java.util.ArrayList;
import java.io.FilenameFilter;

/**
 * Main
 */
public class File_handeling {
// http://www.avajava.com/tutorials/lessons/how-do-i-use-a-filenamefilter-to-display-a-subset-of-files-in-a-directory.html#:~:text=FilenameFilter%20is%20an%20interface%20in,File%20objects%20in%20a%20directory.
ArrayList<String> SongRoots;
    
                    /* Try to make everithing from this class happen just when instancuiated, maybe */
    File_handeling(){}
    File_handeling(ArrayList<String> arr){
                    // Si el File se crea con " File(".") " entonces lo agarra como el directorio actual
        File fileObj = new File(System.getProperty("user.dir"));
        File dirParent = fileObj.getParentFile();
        this.SongRoots = arr;

        
                    // Se necesita un Filter de todas formas, esto es como hacr uno, se instanciua y reemplaza la funcion accept
        FilenameFilter wavFilter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                String lowercaseName = name.toLowerCase();
                if (lowercaseName.endsWith(".wav")) {
                    return true;
                } else {
                    return false;
                }
            }
        };

                    /* la Idea es que estamos en un directorio, del cual queremos salir a su "Padre" para luego verificar todas las carpetas, e
                    ir añadiendo todas las canciones en el rango de 1 Carpeta, o si no, directamente aqui */    

        if(dirParent.isDirectory()){
            File[] dir = dirParent.listFiles();
            Massive_Dir_Music_add(dir, wavFilter, SongRoots);
        } else{
            Music_add(SongRoots, fileObj, wavFilter);
        }

    }



    private void Music_add(ArrayList<String> arrayL, File Fobj, FilenameFilter wavF){
                    /* Basicamentene para ir añadiendo todas las canciones, suponiendo que ya estamos en la carpeta para ello */
        String[] SongList = Fobj.list(wavF);
        for (String str : SongList) {
            arrayL.add(Fobj.getAbsolutePath() + "\\" + str);    //!No habia colocado el Path antes, ahora con el absoluto si se crean los File, teoricamente
        }
    };
    
    private void Massive_Dir_Music_add(File[] dir, FilenameFilter wavF, ArrayList<String> arrayL){
        ArrayList<String> options = new ArrayList<>(dir.length);
        for (File str : dir) {
            if(str.isDirectory()){
                options.add(str.getPath());
            }
                    /* Asi en teoria se verifico la direccion de todas las carpetas y se guardo en opciones, para luego hacer el array list
                    * con todas las direcciones de canciones, tons que retorne el array List
                    */
        };

        for (int i = 0; i < options.size(); i++) {
            File Individual_Directory = new File(options.get(i));
            Music_add(arrayL, Individual_Directory, wavF);
        }
                    /* Usar la funcion de mas arriba para careptas individuales, y por cada carpeta sumar musica, teoricamente*/
    }

    public ArrayList<String> getArrayList(){
        return SongRoots;
    }
}