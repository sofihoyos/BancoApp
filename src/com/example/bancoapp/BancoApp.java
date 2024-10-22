package com.example.bancoapp;

public class BancoApp {
    public static void main(String[] args) {
        // Crear dos cuentas bancarias
        CuentaBancaria cuenta1 = new CuentaBancaria("Sofia", 1000);
        CuentaBancaria cuenta2 = new CuentaBancaria("Maria", 500);

        try {
            // Intentar retirar más dinero del saldo disponible
            cuenta1.retirar(1500);
        } catch (SaldoInsuficienteException | MontoInvalidoException e) {
            System.out.println(e.getMessage());
        }

        try {
            // Depositar un monto negativo
            cuenta2.depositar(-100);
        } catch (MontoInvalidoException e) {
            System.out.println(e.getMessage());
        }

        try {
            // Transferir dinero entre cuentas
            cuenta1.transferir(cuenta2, 300);
        } catch (SaldoInsuficienteException | MontoInvalidoException e) {
            System.out.println(e.getMessage());
        }

        // Mostrar saldos finales
        System.out.println("\nSaldo final de " + cuenta1.getTitular() + ": $" + cuenta1.getSaldo());
        System.out.println("Saldo final de " + cuenta2.getTitular() + ": $" + cuenta2.getSaldo());
    }
}
