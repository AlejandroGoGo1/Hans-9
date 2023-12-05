import java.util.*;

public class OperacionesPermutacion {
    private final List<Integer> conjunto;
    private final List<Integer> indicesUtilizados;
    private int permutacionesImpresas;

    public OperacionesPermutacion(List<Integer> conjunto) {
        this.conjunto = conjunto;
        this.indicesUtilizados = new ArrayList<>();
        this.permutacionesImpresas = 0;
    }

    public int mostrarPermutaciones() {
        List<Integer> indices = new ArrayList<>(Collections.nCopies(conjunto.size(), -1));
        generarPermutaciones(0, indices);
        return permutacionesImpresas;
    }

    public double calcularProbabilidadPrimeraPermutacion(int permutacionesRealizadas) {
        return (permutacionesRealizadas > 0) ? 1.0 / permutacionesRealizadas * 1 : 0.0;
    }

    private void generarPermutaciones(int nivel, List<Integer> indices) {
        if (nivel == conjunto.size()) {
            imprimirPermutacion(indices);
            permutacionesImpresas++;
        }

        List<Integer> utilizadosEnEsteNivel = new ArrayList<>();
        for (int i = 0; i < conjunto.size(); i++) {
            if (!yaUsado(i) && !utilizadosEnEsteNivel.contains(conjunto.get(i))) {
                indices.set(nivel, i);
                indicesUtilizados.add(i);
                utilizadosEnEsteNivel.add(conjunto.get(i));
                generarPermutaciones(nivel + 1, indices);
                indicesUtilizados.remove(indicesUtilizados.size() - 1);
            }
        }
    }

    private void imprimirPermutacion(List<Integer> indices) {
        System.out.print("(");
        for (int i = 0; i < indices.size(); i++) {
            System.out.print(conjunto.get(indices.get(i)));
            if (i < indices.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(")");
    }

    private boolean yaUsado(int indice) {
        return indicesUtilizados.contains(indice);
    }
}