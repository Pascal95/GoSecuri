package com.koor.hello;
import java.io.*;
public class listefichier {
	public static void main(String[] args) throws IOException 
    { 
		  File dir  = new File("/Users/pierre-richardpascal/eclipse-workspace/helloworld/src/main/java/com/koor/hello/photoAgent");
		  File[] liste = dir.listFiles();
		  for(File item : liste){
			  if(item.isFile())
			  { 
			  	System.out.format("Nom du fichier: %s%n", item.getName()); 
			  } 
			  else if(item.isDirectory())
			  {
				  System.out.format("Nom du répertoire: %s%n", item.getName()); 
			  } 
		  }
    }
}
