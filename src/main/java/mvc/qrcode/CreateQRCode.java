/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.qrcode.QRCodeWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ASUS
 */
public class CreateQRCode {
   public static void main(String[] args) {
       
        String fullName = "Le Minh Tuan";
        String position = "Manager";
        String phoneNumber = "0937-551-874";
        String email = "tuanqnbds@gmail.com";
        String filePath = "D:\\PROJECTS\\QRcode\\qrcode.png";
        int width = 300;
        int height = 300;

        String qrText = "Name: " + fullName + "\n" +
                        "Position: " + position + "\n" +
                        "Phone: " + phoneNumber + "\n" +
                        "Email: " + email;

        try {
            generateQRCode(qrText, filePath, width, height);
            System.out.println("QR Code generated successfully.");
        } catch (WriterException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void generateQRCode(String text, String filePath, int width, int height)
            throws WriterException, IOException {

        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        com.google.zxing.common.BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height, hints);

        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }
   } 

