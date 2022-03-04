package com.koor.hello;

import java.io.*;

public class GenereHtpsswd {
    public static void main(String[] args) {
        String fileName = "/Users/pierre-richardpascal/eclipse-workspace/helloworld/src/main/java/com/koor/hello/.htpasswd";
        String encoding = "UTF-8";
        File repertoire = new File("/Users/pierre-richardpascal/eclipse-workspace/helloworld/src/main/java/com/koor/hello/FicheAgent");
        String liste[] = repertoire.list(); 
        int i;
        String line = new String();

        try{
        PrintWriter writer = new PrintWriter(fileName, encoding);
        if (liste != null) {         
            for (int iFichier = 0; iFichier < liste.length; iFichier++) {
                //On recupere le nom des fichiers
                FileReader file = new FileReader("/Users/pierre-richardpascal/eclipse-workspace/helloworld/src/main/java/com/koor/hello/FicheAgent/" + liste[iFichier]);
                BufferedReader buffer = new BufferedReader(file);

                for (i = 1; i < 10; i++) {
                    // Si le numéro de la ligne = 4 récupérer la ligne car c'est la qu'on obtient le mdp
                    if (i == 4){
                        line = buffer.readLine();
                    }
                    else{
                        buffer.readLine();
                    }
                  }
                //on ecrit dans le fichier le login et password dans htpasswd
                writer.println(liste[iFichier].replace(".txt","")+ ":" + line);
            }
            System.out.println("Le .htpasswd a bien été généré");
            writer.close();
        } else {
            System.err.println("Nom de repertoire invalide");
        }

        }
        catch (IOException e){
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
        
}}
