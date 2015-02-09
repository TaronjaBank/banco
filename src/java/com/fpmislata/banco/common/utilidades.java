package com.fpmislata.banco.common;

public abstract class utilidades {

    public static boolean comprobarDNI(String dni) {
        boolean valido;
        try {

            if (dni.length() == 9) {

                String juegoCaracteres = "TRWAGMYFPDXBNJZSQVHLCKET";

                Integer numeroDNI = Integer.parseInt(dni.substring(0,8));
                int modulo = numeroDNI % 23;

                char letraDNI = dni.charAt(8);
                char letra = juegoCaracteres.charAt(modulo);

                if (letraDNI == letra) {
                    valido = true;
                }else{
                    valido=false;
                }
            }else{
                valido=false;
            }

            }catch (NumberFormatException ex){
            valido=false;
        
        }
        return valido;
    }

}
