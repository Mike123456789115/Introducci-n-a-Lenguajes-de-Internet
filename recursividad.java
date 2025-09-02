public class ContarPares {
    public void int contarPares(int[] numeros, int indice) {
        if (indice == numeros.length) {
            return 0;
        }
        int actual = (numeros[indice] % 2 == 0) ? 1 : 0;
        int resultado = actual + contarPares(numeros, indice + 1);
        return resultado;
    }

    public static void main(String[] args) {
        int[] ejemplo1 = {1, 2, 3, 4, 5};
        int[] ejemplo2 = {2, 4, 6, 8};
        int[] ejemplo3 = {1, 3, 5, 7};
        System.out.println(contarPares(ejemplo1, 0));
        System.out.println(contarPares(ejemplo2, 0));
        System.out.println(contarPares(ejemplo3, 0));
    }
}