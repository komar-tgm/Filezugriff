package filezugriff;

import java.io.*;

public class Filezerfetzung {
    public static void main(String[] args) {
        //Hier muss man den Pfad zu den Files definieren
        String path = "src/main/java/filezugriff/files/irgendeinfile.txt";
        String outputpath = "src/main/java/filezugriff/files/outputfile.txt";
        String secondfile = "src/main/java/filezugriff/files/ka.txt";

        //Hier werden die File Objekte erstellt
        File inputfile = new File(path);
        File outputfile = new File(outputpath);
        File anzahlzeilen = new File(secondfile);

        //Anzahl der Zeilen
        int zeilen = 0;

        //Hier werden die Reader und Writer erstellt (gleiches Prinzip wie bei Sockets z.B.)
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputfile));
             PrintWriter printWriter = new PrintWriter(new FileWriter(outputfile),true);
             PrintWriter secondWriter = new PrintWriter(new FileWriter(anzahlzeilen),true)){

            //Hier wird einfach jede Zeile des InputFiles ausgelesen, solange es Zeilen gibt
            String fileInhalt;
            while((fileInhalt = bufferedReader.readLine())!=null){
                zeilen++;
                //Hier wird der Inhalt in das neue File geschrieben
                printWriter.println(fileInhalt);
            }
            secondWriter.println("Anzahl der Zeilen: "+zeilen);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
