import java.util.Scanner;

public class InicioSesion {
    private boolean inicio;
    private CuentaBancaria cuenta_bancaria;


    public InicioSesion() {
        inicio = true;
        cuenta_bancaria = new CuentaBancaria();
    }

    public void iniciosesion() {
        Scanner sc = new Scanner(System.in);
        while (inicio) {
            System.out.println("\nSeleccione una opción: ");
            System.out.println("1. Ver saldo,\n2. Depositar efectivo,\n3. Retirar efectivo,\n4. Cerrar sesion");
            int opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Este es el saldo de la cuenta " + cuenta_bancaria.getNumero_cuenta_bancaria() + " es: " + cuenta_bancaria.getSaldo_cuenta_bancaria());
                    break;
                case 2:
                    System.out.println("Cuanto efectivo desea depositar (el monto minimo para depositar es 100)");
                    double depositar = sc.nextInt();
                    if(depositar >= 100){
                    cuenta_bancaria.setSaldo_cuenta_bancaria(cuenta_bancaria.getSaldo_cuenta_bancaria()+ depositar);}
                    else {System.out.println("El deposito debe ser mayor que 100");
                        break;}
                    break;
                case 3:
                    System.out.println("Cuanto dinero desea retirar");
                    double retiro = sc.nextInt();
                    if(retiro < cuenta_bancaria.getSaldo_cuenta_bancaria()){
                    cuenta_bancaria.setSaldo_cuenta_bancaria(cuenta_bancaria.getSaldo_cuenta_bancaria() - retiro);
                    }
                    else {System.out.println("El retiro no puede ser mayor que el saldo de la cuenta");
                    break;}
                    break;
                case 4:
                    System.out.println("Cerrando sesion");
                    inicio = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
                }

            }
        }
    }

