/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package daw_ed04;

/**
 *
 * @author alumno
 */
public class CCuenta {

    private String titular;
    private String numero_cuenta;
    private String contrasenia; //contraseña del acceso web
    private double saldo;
    private double tipoInteres;
    private int contador; //El contador me va a llevar los intentos de contraseña
    
    /**
     * Constructor vacío.
     */
    public CCuenta() {
    }

    /**
     * Constructor con parámetros
     * @param nom titular de la cuenta
     * @param cue número de cuenta
     * @param sal saldo de la cuenta
     */
    public CCuenta(String nom, String cue, double sal) {
        titular = nom;
        numero_cuenta = cue;
        saldo = sal;
        this.contador = 0;
    }

    /**
     * @return the numero_cuenta
     */
    public String getNumero_cuenta() {
        return numero_cuenta;
    }

    /**
     * @param numero_cuenta the numero_cuenta to set
     */
    public void setNumero_cuenta(String numero_cuenta) {
        this.numero_cuenta = numero_cuenta;
    }

    /**
     * @param antigua la contraseña antigua
     * @param nueva la contraseña nueva.
     * @throws java.lang.Exception
     */
    public void setContrasenia(String antigua, String nueva)throws Exception{
        if(contador == 3) throw new Exception ("Ha superado el número de intentos.");
        if(!antigua.equals(this.contrasenia)) contador++;
        this.contrasenia = nueva;
        this.contador = 0;
    }

    /**
     * @return the tipoInteres
     */
    public double getTipoInteres() {
        return tipoInteres;
    }

    /**
     * @param tipoInteres the tipoInteres to set
     */
    public void setTipoInteres(double tipoInteres) {
        this.tipoInteres = tipoInteres;
    }
    
    /**
     *
     * @param nom
     */
    public void setTitular(String nom) {
        titular = nom;
    }

    /**
     *
     * @return
     */
    public String getTitular() {
        return titular;
    }

    /**
     *
     * @return
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     *
     * @param cantidad
     * @throws Exception
     */
    public void ing(double cantidad) throws Exception {
        compruebaCantidad(cantidad);
        saldo = saldo + cantidad;
    }

    /**
     *
     * @param cantidad
     * @throws Exception
     */
    public void compruebaCantidad(double cantidad) throws Exception {
        if (cantidad < 0) {
            throw new Exception("No se puede ingresar una cantidad negativa");
        }
    }

    /**
     *
     * @param cantidad
     * @throws Exception
     */
    public void ret(double cantidad) throws Exception {
        compruebaCantidad(cantidad);
        if (getSaldo() < cantidad) {
            throw new Exception("No se hay suficiente saldo");
        }
        saldo = saldo - cantidad;
    }

    /**
     *
     * @param tantoPorCiento
     * @return
     */
    public double porcentaje(double tantoPorCiento) {
        return saldo * tantoPorCiento / 100;

    }
    
    /**
     * Imprime los datos que nos interesa visualizar.
     * @param a
     */
    public static void imprimirDatos(CCuenta a) {
        System.out.println("Datos de la cuenta: " + a.getTitular() + a.getNumero_cuenta() + a.getSaldo() + a.getTipoInteres());
    }
}
