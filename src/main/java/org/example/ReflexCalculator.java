package org.example;

import java.lang.reflect.InvocationTargetException;


public class ReflexCalculator {
    /**
     *
     * @param inp
     * @throws ClassNotFoundException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public ReflexCalculator(Double[] inp) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException{
        quicksort(inp);


    }

    /**
     * llama al metodo quicksort y separa el double
     * @param inp
     * @return
     */
    public static String quic(Double[] inp){

        return ("resp:"+ quicksort(inp, new Double[]{inp[0]},new Double[]{inp[inp.length]}));
    }

    /**
     *recibe un arreglo de elementos desordenados y los ordena
     * @param inp
     * @param ini
     * @param fin
     * @return
     */
    public static Double[] quicksort(Double[] inp, Double[] ini, Double[] fin) {
        if(ini <= fin){

            Object p = particion(inp,ini,fin);
            String quicksort = quicksort(inp, ini, p - 1);
            String quicksort1 = quicksort(inp, p + 1, fin);
        }
        return ("resp:"+ result);
    }

    /**
     * realiza el ordenamiento de los menores y mayores al pivote
     * @param inp
     * @param ini
     * @param fin
     * @return
     */
    private static Object particion(Double[] inp, Double[] ini, Double[] fin) {
        Double[] pivote = fin;
        int i=0;
        while(inp !=null){
            if(inp[i]< pivote){
                i= i+1;
            }else{
                pivote = inp[i];
                i=i+1;
            }


        }

    }


}

