/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.octa.invocetransform.Utils;

import java.awt.FileDialog;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 *
 * @author dskat
 */
public class FileUtils {

    public static String selectPath() {

        String path = "";

        JFileChooser f = new JFileChooser();
        f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        f.showSaveDialog(null);
        
        path = f.getSelectedFile().getPath();

        return path;
    }

    //Function to get a list of files opening the Java FileManager
    public static ArrayList<File> openFileManager(JFrame jFrame) {

        ArrayList<File> listOfFiles = new ArrayList<>();

        //Open java file dialog
        //Just allow xml files
        FileDialog fd = new FileDialog(jFrame, "Seleccione los archivos a transformar.", FileDialog.LOAD);
        fd.setMultipleMode(true);
        fd.setDirectory(Constants.PROGRAM_FILES_PATH);
        fd.setFile("*.xml");
        fd.setVisible(true);
        File[] selectedFiles = fd.getFiles();

        if (selectedFiles == null || selectedFiles.length == 0) {
            System.out.println("User cancelled file selecction. ");
        } else {
            for (int x = 0; x < selectedFiles.length; x++) {
                listOfFiles.add(selectedFiles[x]);
                System.out.println("File: " + selectedFiles[x].getName() + " added.");
            }
        }

        return listOfFiles;

    }

}
