import java.util.Random;
import java.util.Scanner;

public class CuentaBancaria {
    private String nombre_titular;
    private String contra_cuenta_bancaria;
    private int numero_cuenta;
    private double saldo_cuenta_bancaria;

    public CuentaBancaria() {}

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

    public int getNumero_cuenta() {
        return numero_cuenta;
    }

    public void setNumero_cuenta(int numero_cuenta) {
        this.numero_cuenta = numero_cuenta;
    }

    public double getSaldo_cuenta_bancaria() {
        return saldo_cuenta_bancaria;
    }

    public void setSaldo_cuenta_bancaria(double saldo_cuenta_bancaria) {
        this.saldo_cuenta_bancaria = saldo_cuenta_bancaria;
    }

    public void menu_inicial() {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        boolean iniciar = true;

        while (iniciar) {
            System.out.println("\nSeleccione una opción: ");
            System.out.println("1. Iniciar Sesión");
            System.out.println("2. Crear Cuenta");
            System.out.println("0. Salir");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del titular de la cuenta: ");
                    String nombre = sc.nextLine();
                    if (nombre.equals(getNombre_titular())) {
                        System.out.print("Ingrese su número de cuenta: ");
                        int numero_cuenta_ingresado = sc.nextInt();
                        sc.nextLine();
                        if (numero_cuenta_ingresado == getNumero_cuenta()) {
                            System.out.print("Ingrese su contraseña: ");
                            String contra = sc.nextLine();
                            if (contra.equals(getContra_cuenta_bancaria())) {
                                System.out.println("Se inició sesión correctamente.");
                                InicioSesion inicioSesion = new InicioSesion(this);
                                inicioSesion.iniciosesion();
                            } else {
                                System.out.println("Contraseña incorrecta.");
                            }
                        } else {
                            System.out.println("Número de cuenta incorrecto.");
                        }
                    } else {
                        System.out.println("Titular no existe.");
                    }
                    break;

                case 2:
                    System.out.print("Ingrese el nombre del titular de la cuenta: ");
                    String nombre_titular = sc.nextLine();
                    setNombre_titular(nombre_titular);

                    System.out.print("Ingrese una contraseña (mínimo 8 caracteres): ");
                    String contrasena = sc.nextLine();

                    if (contrasena.length() >= 8) {
                        setContra_cuenta_bancaria(contrasena);
                        int nuevoNumeroCuenta = rand.nextInt(9000) + 1000;
                        setNumero_cuenta(nuevoNumeroCuenta);
                        System.out.println("Cuenta creada con éxito. Su número de cuenta es: " + getNumero_cuenta());
                    } else {
                        System.out.println("La contraseña debe tener al menos 8 caracteres.");
                    }
                    break;

                case 0:
                    System.out.println("Terminando proceso...");
                    iniciar = false;
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
        sc.close();
    }
}

