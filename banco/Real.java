public class Real extends Moeda {

    public Real(double valor) {
        super(valor);
    }

    @Override
    public void info() {
        System.out.println("Real - Valor: R$" + valor);
    }

    @Override
    public double converter() {
        // Já está em Real, então retorna o mesmo valor
        return valor;
    }
}
