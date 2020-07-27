package filezugriff;

import java.io.*;

public class First {
    public static void main(String[] args) {
        //Hier muss man den Pfad zu den Files definieren
        String path = "src/main/java/filezugriff/files/irgendeinfile.txt";
        String outputpath = "src/main/java/filezugriff/files/outputfile.txt";

        //Hier werden die File Objekte erstellt
        File inputfile = new File(path);
        File outputfile = new File(outputpath);

        //Hier werden die Reader und Writer erstellt (gleiches Prinzip wie bei Sockets z.B.)
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputfile));
             PrintWriter printWriter = new PrintWriter(new FileWriter(outputfile),true)){

            //Hier wird einfach jede Zeile des InputFiles ausgelesen, solange es Zeilen gibt
            String fileInhalt;
            while((fileInhalt = bufferedReader.readLine())!=null){
                //Hier wird der Inhalt in das neue File geschrieben
                printWriter.println(fileInhalt);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
