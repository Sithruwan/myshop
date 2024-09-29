package com.sith.ecom.myshop.utill;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.*;
import java.sql.Blob;
import java.sql.SQLException;

@Service
public class FileDataExtractor {

    public byte[] blobToByteArray(Blob blob) throws SQLException, IOException {
        if (blob == null) {
            return new byte[0];
        }
        try (InputStream inputStream = blob.getBinaryStream();
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[4096];
            int byteRead;
            while ((byteRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, byteRead);
            }
            return outputStream.toByteArray();
        }
    }

    public String extractActualFileName(InputStreamReader inputStreamReader) throws IOException {
        try {
            StringBuffer sb = new StringBuffer();
            String temp;
            BufferedReader reader = null;
            reader = new BufferedReader(inputStreamReader);
            while ((temp = reader.readLine()) != null) {
                sb.append(temp);
            }
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    public String blobToString(Blob blob) throws SQLException, IOException {
        if (blob == null) {
            return "";
        }
        try (InputStream inputStream = blob.getBinaryStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        }
    }

}
