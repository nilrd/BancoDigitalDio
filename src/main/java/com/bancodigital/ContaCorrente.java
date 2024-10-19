package com.bancodigital;

public class ContaCorrente extends Conta {
    private static final double TAXA_SAQUE = 1.00;

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void sacar(double valor) {
        if (valor + TAXA_SAQUE <= saldo) {
            saldo -= (valor + TAXA_SAQUE);
            transacoes.add(new Transacao("Saque", valor + TAXA_SAQUE));
        } else {
            System.out.println("Saldo insuficiente para saque com taxa.");
        }
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Corrente ===");
        super.imprimirExtrato();
        listarTransacoes();
    }
}
