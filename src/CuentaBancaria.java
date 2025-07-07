import java.util.Random;
import java.util.Scanner;

public class CuentaBancaria {
    private String nombre_titular;
    private String contra_cuenta_bancaria;
    private int numero_cuenta;
    private double saldo_cuenta_bancaria;

    public CuentaBancaria() {
        Random rand = new Random();
        numero_cuenta = rand.nextInt(1000);
    }
    public String getNombre_titular() {
        return nombre_titular;
    }

    public void setNombre_titular(String nombre_titular) {
        this.nombre_titular = nombre_titular;
    }

    public String getContra_cuenta_bancaria() {
        return contra_cuenta_bancaria;
    }

    public void setContra_cuenta_bancaria(String contra_cuenta_bancaria) {
        this.contra_cuenta_bancaria = contra_cuenta_bancaria;
    }

    public int getNumero_cuenta_bancaria() {
        return numero_cuenta;
    }

    public double getSaldo_cuenta_bancaria() {
        return saldo_cuenta_bancaria;
    }

    public void setSaldo_cuenta_bancaria(double saldo_cuenta_bancaria) {
        this.saldo_cuenta_bancaria = saldo_cuenta_bancaria;
    }
    public void menu_inicial() {
        Scanner sc = new Scanner(System.in);
        CuentaBancaria cuentaBancaria = new CuentaBancaria();
        boolean iniciar = true;
        while (iniciar) {
            System.out.println("\nSeleccione una opción: ");
            System.out.println("1. Iniciar Sesion,\n2. Crear Cuenta, \n0. Salir");
            int opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del titular de la cuenta: ");
                    String nombre = sc.nextLine();
                    if (nombre.equals(cuentaBancaria.getNombre_titular())) {
                        System.out.print("Ingrese su contraseña: ");
                        String contra = sc.nextLine();
                        if (contra.equals(cuentaBancaria.getContra_cuenta_bancaria())) {
                            System.out.println("Se inicio sesion correctamente");
                            InicioSesion inicioSesion = new InicioSesion();
                            inicioSesion.iniciosesion();
                            break;
                        } else {
                            System.out.println("Contraseña incorrecta");
                            break;
                        }
                    } else {
                        System.out.println("Titular no existe");
                        break;
                    }
                case 2:
                    System.out.println("Ingrese el nombre del titular de la cuenta: ");
                    String nombre_titular = sc.nextLine();
                    setNombre_titular(nombre_titular);
                    System.out.print("Ingrese una contreseña: ");
                    String contresena = sc.nextLine();
                    if (contresena.length() >= 8){
                    setContra_cuenta_bancaria(contresena);
                    System.out.println("Cuenta creada con exito, su numero de cuenta es: " + getNumero_cuenta_bancaria());
                    break;}
                    else {
                        System.out.println("La contraseña tiene que tener mas de 8 caracteres");
                    }
                    break;
                case 0:
                    System.out.println("Terminando proceso");
                    iniciar = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}
