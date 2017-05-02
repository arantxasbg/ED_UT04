/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package daw_ed04;

public class Main {
    public static void main(String[] args) {
        CCuenta a;
        a = new CCuenta("Felipe Segundo","2222-2222-22-1230456789", 2222);
        double cantidad = 2300;
        int operacion = 1; 
        operacion = 2;
        a = menuOperaciones(a,operacion, cantidad);
        cantidad = 600;
        operacion = 3;
        a= menuOperaciones(a, operacion, cantidad);
        CCuenta.imprimirDatos(a);
    }

    public static CCuenta menuOperaciones(CCuenta a, int operacion, double cantidad) {
        switch (operacion) {
            case 1://Ver el saldo
                System.out.println("El saldo actual es" + a.getSaldo());
                break;
            case 2: //Retiro en cuenta
                try {
                    System.out.println("Retiro en cuenta");
                    a.ret(cantidad);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 3:
                try {

                    System.out.println("Ingreso en cuenta");
                    cantidad = 600;
                    a.ing(cantidad);
                } catch (Exception e) {
                    System.out.print(e.getMessage());
                }
                break;

        }

        return a;
    }

}
