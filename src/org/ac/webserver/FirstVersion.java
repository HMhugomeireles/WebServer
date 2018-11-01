package org.ac.webserver;

import java.io.File;
import java.io.FileInputStream;
/*
public class FirstVersion {

   try {

        String firstLineHead = readerHeader.readLine();
        System.out.println(firstLineHead);
        String[] cleanFileName = fileNameAndType(firstLineHead);

        if (cleanFileName[0] != null || cleanFileName[1] != null) {

            File file = new File("resources/" + cleanFileName[0] + cleanFileName[1]);
            FileInputStream fileInputStream = null;

            //System.out.println(cleanFileName[0]);

            byte[] fileBytes = null;

            if (file.exists()) {

                fileInputStream = new FileInputStream(file);

                fileBytes = fileInputStream.readAllBytes();


                out.print("HTTP/1.0 200 Document Follows\r\n"
                        + "Content-Type: image/" + cleanFileName[1] + "\r\n"
                        + "Content-Length: " + fileBytes.length + "\r\n"
                        + "\r\n");

                        out.flush()

                clientSocket.getOutputStream().write(fileBytes, 0, fileBytes.length);


            } else {

                fileInputStream = new FileInputStream("resources/notfound.html");

                fileBytes = fileInputStream.readAllBytes();

                out.println("HTTP/1.0 200 Document Follows\r\n"
                        + "Content-Type: text/html; charset=UTF-8\r\n"
                        + "Content-Length: " + fileBytes.length + "\r\n"
                        + "\r\n");

                clientSocket.getOutputStream().write(fileBytes, 0, fileBytes.length);

            }

        }

    } catch (ArrayIndexOutOfBoundsException e) {

        // the request don't have arguments default request
        File file = new File("resources/robots.txt");

        FileInputStream fileInputStream = new FileInputStream(file);

        byte[] fileBytes = fileInputStream.readAllBytes();

        out.println("HTTP/1.0 200 Document Follows\r\n"
                + "Content-Type: text/html; charset=UTF-8\r\n"
                + "Content-Length: " + fileBytes.length + "\r\n"
                + "\r\n");

        clientSocket.getOutputStream().write(fileBytes, 0, fileBytes.length);


    }finally {

        clientSocket.close();

    }

}
}

/*
        String body = "<h1>Web Server</h1>";

        byte[] bytesBody = body.getBytes();

        out.println("HTTP/1.0 200 Document Follows\r\n"
                    + "Content-Type: text/html; charset=UTF-8\r\n"
                    + "Content-Length: " + bytesBody.length + "\r\n"
                    + "\r\n");

        System.out.println(bytesBody.length);

        clientSocket.getOutputStream().write(bytesBody);
        */








