package org.ac.webserver;

import org.ac.webserver.filemanager.FileManager;
import org.ac.webserver.filemanager.FileType;
import org.ac.webserver.printer.OutPrint;
import org.ac.webserver.request.Request;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8080);

        while (true) {

            Socket clientSocket = serverSocket.accept();

            BufferedReader readerHeader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String request = fileType(readerHeader.readLine());

            System.out.println(request);

            try {

                FileManager fileManager = new FileManager(request);

                String fileType = Request.getOutWrite(fileManager.getFileExtension(), fileManager.getFileLength());

                OutPrint outPrint = new OutPrint(clientSocket.getOutputStream());
                outPrint.writeHeader(fileType);
                outPrint.writeFile(fileManager.getFileBytes());


            } catch (FileNotFoundException e) {
                // print on the server file not found
                System.out.println("File not Found!!");

                FileManager fileManager = new FileManager("/notfound.html");

                String headerType = Request.getOutWrite(fileManager.getFileExtension(), fileManager.getFileLength());
                System.out.println(headerType);

                OutPrint outPrint = new OutPrint(clientSocket.getOutputStream());
                outPrint.writeHeader(headerType);
                outPrint.writeFile(fileManager.getFileBytes());

            }

        }

    }


    private static String fileType(String file) {

        String[] words = file.split(" ");

        return words[1];

    }


}
