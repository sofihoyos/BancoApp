package com.example.bancoapp;

public class CuentaBancaria {
    private String titular;
    private double saldo;

    public CuentaBancaria(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double monto) throws MontoInvalidoException {
        if (monto <= 0) {
            throw new MontoInvalidoException("El monto a depositar debe ser mayor que cero.");
        }
        saldo += monto;
        System.out.println("Se han depositado $" + monto + " en la cuenta de " + titular);
    }

    public void retirar(double monto) throws SaldoInsuficienteException, MontoInvalidoException {
        if (monto <= 0) {
            throw new MontoInvalidoException("El monto a retirar debe ser mayor que cero.");
        }
        if (saldo < monto) {
            throw new SaldoInsuficienteException("Saldo insuficiente para retirar $" + monto);
        }
        saldo -= monto;
        System.out.println("Se han retirado $" + monto + " de la cuenta de " + titular);
    }

    public void transferir(CuentaBancaria cuentaDestino, double monto) throws SaldoInsuficienteException, MontoInvalidoException {
        if (monto <= 0) {
            throw new MontoInvalidoException("El monto a transferir debe ser mayor que cero.");
        }
        if (saldo < monto) {
            throw new SaldoInsuficienteException("Saldo insuficiente para transferir $" + monto);
        }
        this.retirar(monto);
        cuentaDestino.depositar(monto);
        System.out.println("Se han transferido $" + monto + " de la cuenta de " + titular + " a la cuenta de " + cuentaDestino.getTitular());
    }
}