/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import java.security.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 *
 * @author DAMAR
 */
public class HashUtil {

    public static String hashPassword(String password) {
        try {
            // 1. Dapatkan instance dari algoritma hashing SHA-256
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            
            // 2. Lakukan hashing pada password yang sudah diubah ke format byte
            byte[] hash = md.digest(password.getBytes(StandardCharsets.UTF_8));
            
            // 3. Ubah hasil hashing dari byte menjadi String hexadecimal
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                // String.format("%02x", b) akan mengubah byte menjadi 2 digit hex (misal: a -> 0a)
                hexString.append(String.format("%02x", b));
            }
            
            // 4. Kembalikan hasilnya
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            // Ini adalah blok 'catch' untuk menangani error
            // Error ini terjadi jika algoritma SHA-256 tidak ditemukan (sangat jarang)
            // Cara terbaik adalah menghentikan program dengan error yang jelas.
            throw new RuntimeException(e);
        }
    }
}
