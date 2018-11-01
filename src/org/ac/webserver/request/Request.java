package org.ac.webserver.request;

import java.io.File;

public class Request {

    public static String getOutWrite(String typeFile, int fileLength) {
        System.out.println("getOut " + typeFile);
        String outPut = "HTTP/1.0 200 Document Follows\n";

        typeFile = typeFile.toUpperCase();

        System.out.println(typeFile);

        switch (typeFile) {
            case "TXT":
                outPut += "Content-Type: text/html; charset=UTF-8\r\n";
                break;
            case "HTML":
                outPut += "Content-Type: text/html; charset=UTF-8\r\n";
                break;
            case "JPG":
                outPut += "Content-Type: image/" + typeFile.toLowerCase() + "\r\n";
                break;
            case "ICO":
                outPut += "Content-Type: image/" + typeFile.toLowerCase() + "\r\n";
                break;
            case "JS":
                outPut += "Content-Type: application/javascript\r\n";
                break;
            case "MP4":
                outPut += "Content-Type: video/mp4\r\n";
                break;
            default:
                outPut += "Content-Type: text/html; charset=UTF-8\r\n";
                break;

        }

        outPut += "Content-Length: " + fileLength + "\r\n"
                + "\r\n";

        return outPut;
    }

}
