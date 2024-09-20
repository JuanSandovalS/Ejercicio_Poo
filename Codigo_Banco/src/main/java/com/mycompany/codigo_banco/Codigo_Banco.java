/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.codigo_banco;

import java.util.Scanner;

/**
 *
 * @author JUAN
 */
public class Codigo_Banco {
private double saldoCuenta1;
    private double saldoCuenta2;
    
    // Constructor 
    public Codigo_Banco(double saldoInicialCuenta1, double saldoInicialCuenta2) {
        this.saldoCuenta1 = saldoInicialCuenta1;
        this.saldoCuenta2 = saldoInicialCuenta2;
    }
    
    // Metodo para ingresar
    public void ingresar(int cuenta, double cantidad) {
        if (cuenta == 1) {
            saldoCuenta1 += cantidad;
        } else if (cuenta == 2) {
            saldoCuenta2 += cantidad;
        }
    }
    
    // Metodo para retirar
    public void debitar(int cuenta, double cantidad) {
        if (cuenta == 1 && saldoCuenta1 >= cantidad) {
            saldoCuenta1 -= cantidad;
        } else if (cuenta == 2 && saldoCuenta2 >= cantidad) {
            saldoCuenta2 -= cantidad;
        } else {
            System.out.println("Fondos insuficientes en la cuenta seleccionada.");
        }
    }
    
    // Metodo para consultar los saldos de ambas cuentas
    public void mostrarSaldos() {
        System.out.println("Saldo de la Cuenta No. 1: " + saldoCuenta1);
        System.out.println("Saldo de la Cuenta No. 2: " + saldoCuenta2);
    }

    // Metodo principal para interactuar con el usuario
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Inicializar el saldo inicial de las cuentas
        Codigo_Banco banco = new Codigo_Banco(500, 800);  
        
        int opcion;
        do {
            System.out.println("-------------------------------");
            System.out.println("--   Seleccione una opción:  --");
            System.out.println("--   1. Ingresar dinero      --");
            System.out.println("--   2. Retirar dinero       --");
            System.out.println("--   3. Consultar saldos     --");
            System.out.println("--   4. Salir                --");
            System.out.println("-------------------------------");
            opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    System.out.println("Seleccione la cuenta (1 o 2): ");
                    int cuentaIngreso = scanner.nextInt();
                    System.out.println("Ingrese la cantidad a depositar: ");
                    double cantidadIngreso = scanner.nextDouble();
                    banco.ingresar(cuentaIngreso, cantidadIngreso);
                    break;
                case 2:
                    System.out.println("Seleccione la cuenta (1 o 2): ");
                    int cuentaDebito = scanner.nextInt();
                    System.out.println("Ingrese la cantidad a debitar: ");
                    double cantidadDebito = scanner.nextDouble();
                    banco.debitar(cuentaDebito, cantidadDebito);
                    break;
                case 3:
                    banco.mostrarSaldos();
                    break;
                case 4:
                    System.out.println("Gracias por usar el sistema.");
                    break;
                default:
                    System.out.println("Opción no valida. Intente de nuevo.");
            }
        } while (opcion != 4);
        
        scanner.close();
    }
}
