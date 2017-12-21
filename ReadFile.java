/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordscount;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author vsakin
 */
public class ReadFile {

    private String fileIn;

    public Scanner scannerFile;

    public ReadFile() throws IOException {
        this.scannerFile = null;
//        this.fileIn = "/Users/vsakin/tmp/sherlock.txt";
        this.fileIn = "/Users/vsakin/tmp/test.txt";
        try {
            scannerFile = new Scanner(new File(this.fileIn));
        } catch (FileNotFoundException e) {
        }
    }

}
