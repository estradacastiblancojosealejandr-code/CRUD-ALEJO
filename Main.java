import java.util.Scanner;

public class Main {

    static Persona[] personas = new Persona[100];
    static int contador = 0;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===== MENU CRUD PERSONAS =====");
            System.out.println("1. Registrar persona");
            System.out.println("2. Consultar persona");
            System.out.println("3. Actualizar persona");
            System.out.println("4. Eliminar persona");
            System.out.println("5. Listar personas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = input.nextInt();

            switch (opcion) {
                case 1:
                    registrar(input);
                    break;
                case 2:
                    consultar(input);
                    break;
                case 3:
                    actualizar(input);
                    break;
                case 4:
                    eliminar(input);
                    break;
                case 5:
                    listar();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }

        } while (opcion != 0);
    }

    // 1. REGISTRAR
    public static void registrar(Scanner input) {
        if (contador >= 100) {
            System.out.println("Arreglo lleno");
            return;
        }

        input.nextLine(); // limpiar buffer

        System.out.print("Nombre: ");
        String nombre = input.nextLine();

        System.out.print("Edad: ");
        int edad = input.nextInt();

        System.out.print("Documento: ");
        int documento = input.nextInt();

        Persona p = new Persona(nombre, edad, documento);

        System.out.print("Sexo (M/F): ");
        char sexo = input.next().charAt(0);

        System.out.print("Sueldo: ");
        float sueldo = input.nextFloat();

        input.nextLine();

        System.out.print("Cargo: ");
        String cargo = input.nextLine();

        p.setSexo(sexo);
        p.setSueldo(sueldo);
        p.setCargo(cargo);

        personas[contador] = p;
        contador++;

        System.out.println("Persona registrada correctamente");
    }

    // 2. CONSULTAR
    public static void consultar(Scanner input) {
        System.out.print("Ingrese documento: ");
        int doc = input.nextInt();

        for (int i = 0; i < contador; i++) {
            if (personas[i] != null && personas[i].getDocumento() == doc) {
                mostrar(personas[i]);
                return;
            }
        }

        System.out.println("Persona no encontrada");
    }

    // 3. ACTUALIZAR
    public static void actualizar(Scanner input) {
        System.out.print("Ingrese documento: ");
        int doc = input.nextInt();

        for (int i = 0; i < contador; i++) {
            if (personas[i] != null && personas[i].getDocumento() == doc) {

                input.nextLine();

                System.out.print("Nuevo nombre: ");
                personas[i].setNombre(input.nextLine());

                System.out.print("Nueva edad: ");
                personas[i].setEdad(input.nextInt());

                System.out.print("Nuevo sexo: ");
                personas[i].setSexo(input.next().charAt(0));

                System.out.print("Nuevo sueldo: ");
                personas[i].setSueldo(input.nextFloat());

                input.nextLine();

                System.out.print("Nuevo cargo: ");
                personas[i].setCargo(input.nextLine());

                System.out.println("Persona actualizada");
                return;
            }
        }

        System.out.println("Persona no encontrada");
    }

    // 4. ELIMINAR
    public static void eliminar(Scanner input) {
        System.out.print("Ingrese documento: ");
        int doc = input.nextInt();

        for (int i = 0; i < contador; i++) {
            if (personas[i] != null && personas[i].getDocumento() == doc) {
                personas[i] = null;
                System.out.println("Persona eliminada");
                return;
            }
        }

        System.out.println("Persona no encontrada");
    }

    // 5. LISTAR
    public static void listar() {
        for (int i = 0; i < contador; i++) {
            if (personas[i] != null) {
                mostrar(personas[i]);
                System.out.println("-------------------");
            }
        }
    }

    // Mostrar datos
    public static void mostrar(Persona p) {
        System.out.println("Nombre: " + p.getNombre());
        System.out.println("Edad: " + p.getEdad());
        System.out.println("Documento: " + p.getDocumento());
        System.out.println("Sexo: " + p.getSexo());
        System.out.println("Sueldo: " + p.getSueldo());
        System.out.println("Cargo: " + p.getCargo());
    }
}
