package contas;

import java.math.BigDecimal;

public abstract class Conta {
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    private int numeroConta;
    private int agencia;
    private String nomeCliente;
    private BigDecimal saldo;
    // private DecimalFormat df = new DecimalFormat("#.###,00");
    
    public Conta() {
    }

    public Conta(String nomeCliente) {
        this.numeroConta = SEQUENCIAL;
        this.agencia = AGENCIA_PADRAO;
        this.nomeCliente = nomeCliente;
    }

    public void sacar(BigDecimal saque){
        if ( saque.compareTo(BigDecimal.ZERO) > 0 && saque.compareTo(this.getSaldo()) <= 0) {
            this.saldo = this.saldo.subtract(saque);
        } else {
            System.out.println("Valor invalido");

        }
    }

    public void depositar(BigDecimal deposito){
        if ( deposito.compareTo(BigDecimal.ZERO) > 0) {
            this.saldo = this.saldo.add(deposito);
        } else {
            System.out.println("Valor invalido");

        }
    }

    public void transferir(BigDecimal transferencia, Conta contaDestino){
        if ( transferencia.compareTo(BigDecimal.ZERO) > 0 && transferencia.compareTo(this.getSaldo()) <= 0) {
            this.sacar(transferencia);
            contaDestino.depositar(transferencia);
        } else {
            System.out.println("Valor invalido");

        }
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public int getAgencia() {
        return agencia;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

}
