package com.learncamel.file;

import java.io.*;

public class CopyFilesWithoutCamel {
    public static void main(String[] args) throws Exception {
        //step 1 create a file object to read the directory

        File inputDirectory = new File("data/input");
        File outputDirectory = new File("data/output");

        //step 2 read the file from the directory and iterate the files

        File[] files = inputDirectory.listFiles();


        for(File source:files){
            if(source.isFile()){
                File dest = new File(
                        outputDirectory.getPath()
                        + File.separator
                        + source.getName()
                );
                //step 3 write the out put stream and read the files
                OutputStream OStream = new FileOutputStream(dest);
                byte[] buffer = new byte[(int) source.length()];
                FileInputStream iStream = new FileInputStream(source);
                iStream.read(buffer);
                try {
                    OStream.write(buffer);
                } finally {
                    OStream.close();
                    iStream.close();
                }
            }
        }
        //step 4 close the streams
    }
}
