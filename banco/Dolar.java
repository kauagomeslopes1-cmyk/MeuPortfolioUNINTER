public class Dolar extends Moeda {

    public Dolar(double valor) {
        super(valor);
    }

    @Override
    public void info() {
        System.out.println("Dólar - Valor: $" + valor);
    }

    @Override
    public double converter() {
        // Exemplo de conversão para Real
        return valor * 5.60; // supondo 1 USD = 5.60 BRL
    }
}

