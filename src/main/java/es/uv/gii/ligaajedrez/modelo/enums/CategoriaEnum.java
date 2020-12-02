/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uv.gii.ligaajedrez.modelo.enums;

/**
 *
 * @author jbeltran
 */
public enum CategoriaEnum {
    Infantil(0),
    Junior(1),
    Senior(2);

    private final int value;
    
    private CategoriaEnum(int value) {
        this.value = value;
    }
    
    public static String[] names() {
        CategoriaEnum[] categories = values();
        String[] names = new String[categories.length];

        for (int i = 0; i < categories.length; i++) {
            names[i] = categories[i].name();
        }

        return names;
    }

    public int getValue() {
        return value;
    }
}
