package com.koor.hello;
import java.io.*;

public class test {
	public static void main(String args[]) 
    {
        try {
  
            System.out.println(test.getContextPath()); 
            System.out.println("Chemin absolu: " + file.getAbsolutePath()); 
        }
        catch (Exception e) {
            System.err.println(e.getMessage()); 
        }
    }
}
