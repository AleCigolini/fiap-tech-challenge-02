package br.com.fiap.techchallenge01.cliente.utils.validadores.cpf;

public enum DigitoCpfEnum {
    PRIMEIRO_DIGITO(10, 0, 9),
    SEGUNDO_DIGITO(11, 0, 10);

    private final int pesoInicial;
    private final int indiceInicial;
    private final int numerosValidados;

    DigitoCpfEnum(int pesoInicial, int indiceInicial, int numerosValidados) {
        this.pesoInicial = pesoInicial;
        this.indiceInicial = indiceInicial;
        this.numerosValidados = numerosValidados;
    }

    public int getPesoInicial() {
        return pesoInicial;
    }

    public int getIndiceInicial() {
        return indiceInicial;
    }

    public int getNumerosValidados() {
        return numerosValidados;
    }

}
