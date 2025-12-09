import java.util.ArrayList;

public class Cofrinho {
    private ArrayList<Moeda> listaMoedas = new ArrayList<>();

    public void adicionar(Moeda moeda) {
        listaMoedas.add(moeda);
    }

    public void remover(Moeda moeda) {
        listaMoedas.remove(moeda);
    }

    public void listagemMoedas() {
        if (listaMoedas.isEmpty()) {
            System.out.println("O cofrinho está vazio.");
            return;
        }
        System.out.println("Moedas no cofrinho:");
        for (Moeda m : listaMoedas) {
            m.info();
        }
    }

    public double totalConvertido() {
        double total = 0;
        for (Moeda m : listaMoedas) {
            total += m.converter();
        }
        return total;
    }
}
