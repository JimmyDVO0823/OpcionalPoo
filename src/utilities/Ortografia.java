/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import java.text.Normalizer;

/**
 *
 * @author LENOVO LOQ
 */
public final class Ortografia {
    public static String quitarTildes(String texto) {
        if (texto == null) {
            return null;
        }

        String textoNormalizado = Normalizer.normalize(texto, Normalizer.Form.NFD);

        textoNormalizado = textoNormalizado.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");

        return textoNormalizado;
    }
}
