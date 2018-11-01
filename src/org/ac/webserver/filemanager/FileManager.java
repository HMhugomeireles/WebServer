package org.ac.webserver.filemanager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileManager {

    private File file;
    private String fileExtension;
    private FileInputStream fileInputStream;
    private byte[] fileBytes;

    public FileManager(String file) throws FileNotFoundException {

        init(file);

    }

    public String getFileExtension() {
        return fileExtension;
    }

    public int getFileLength() {
        return fileBytes.length;
    }

    public byte[] getFileBytes() {
        return fileBytes;
    }

    private void init(String file) throws FileNotFoundException {


        if (isRoot(file)) {
            this.file = new File("/index.html");
        } else {
            this.file = new File(file);
        }

        fileInputStream = new FileInputStream("resources" + this.file);

        try {
            getFileAllBytes();
        } catch (IOException e) {
            System.out.println("Error on stream read all bytes::" + e.getMessage());
        }

        getFileExtension(file);

    }

    private boolean isRoot(String path) {
        if (path.equals("/")) {
            return true;
        }
        return false;
    }

    private void getFileAllBytes() throws IOException {
        this.fileBytes = fileInputStream.readAllBytes();
    }

    private void getFileExtension(String path) {

        int index = path.lastIndexOf(".");
        fileExtension = path.substring(index + 1);

    }


}
