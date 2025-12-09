public class Euro extends Moeda {

    public Euro(double valor) {
        super(valor);
    }

    @Override
    public void info() {
        System.out.println("Euro - Valor: €" + valor);
    }

    @Override
    public double converter() {
        // Exemplo de conversão para Real
        return valor * 6.10; // supondo 1 EUR = 6.10 BRL
    }
}

