public class PermutacionMain {

    public static void main(String[] args) {
        Dataset dataset = new Dataset();
        realizarOperaciones(dataset);
    }

    private static void realizarOperaciones(Dataset dataset) {
        OperacionesPermutacion operaciones = new OperacionesPermutacion(dataset.conjunto());

        System.out.println("Permutaciones sin repetición:");
        int permutacionesImprimidas = operaciones.mostrarPermutaciones();
        System.out.println("Número de permutaciones impresas: " + permutacionesImprimidas);

        double probabilidad = operaciones.calcularProbabilidadPrimeraPermutacion(permutacionesImprimidas);
        System.out.println("Probabilidad de que salga la primera permutación: " + probabilidad + "%");
    }
}