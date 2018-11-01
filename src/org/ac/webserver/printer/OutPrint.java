package org.ac.webserver.printer;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutPrint {

    private DataOutputStream dataOutputStream;

    public OutPrint(OutputStream out){

        dataOutputStream = new DataOutputStream(out);

        dataOutputStream.se

    }

    private void doFlush(){
        try {
            dataOutputStream.flush();
        } catch (IOException e) {
            System.out.println("Error on flush the stream::" + e.getMessage());
        }
    }

    public void writeHeader(String printHeader){
        try {
            dataOutputStream.writeUTF(printHeader);
            doFlush();
        } catch (IOException e) {
            System.out.println("Error on write header::" + e.getMessage());
        }
    }

    public void writeFile(byte[] fileBytes){
        try {
            dataOutputStream.write( fileBytes,0, fileBytes.length );
            doFlush();
        } catch (IOException e) {
            System.out.println("Error on write the file::" + e.getMessage());
        }
    }


}
