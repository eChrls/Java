package GestionHospital6A;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

public class main {

    public static void main(String[] args) {

        System.out.println("*****************INICIANDO PRUEBAS BÁSICAS*************************");
        pruebaBasica();

        System.out.println("\n\n****************INICIANDO PRUEBAS COMPLEJAS*********************");
        pruebaCompleja();

    }
    //Prueba básica de crear Hospital con personal y pacientes y mostrar sus datos

    public static void pruebaBasica() {
        // Creamos las listas de empleados y pacientes
        ArrayList<Empleado> empleados = new ArrayList<>();
        ArrayList<Paciente> pacientes = new ArrayList<>();

        //Creamos el hospital
        Hospital hospital = new Hospital("Vithas Estepona", empleados, pacientes);
        System.out.println("------------CREATED ----------- Hospital : " + hospital.getNombre());

        //Creamos 5 médicos, 5 administrativos y 10 pacientes.
        crearMedicos(hospital);
        crearAdministrativos(hospital);
        crearPacientes(hospital);

        hospital.mostrarEmpleados();

        hospital.mostrarPacientes();

        System.out.println("------------------CALCULO IRPF-----------------------");
        mostrarCalculoIRPF(hospital);

    }

    //CREACION DE 5 MEDICOS
    private static void crearMedicos(Hospital hospital) {
        //Creamos 5 especialidades
        String[] especialidades = {"Cardiología", "Pediatría", "Traumatología", "Dermatología", "Neurología"};
        Grupo[] grupos = {Grupo.A, Grupo.A, Grupo.B, Grupo.B, Grupo.C}; // Asignamos grupos profesionales

        for (int i = 0; i < 5; i++) {
            //creamos el NIF simulado
            /*Se ejecuta 5 veces, porque i comienza en 0 y termina en 4 (i < 5).
               En cada iteración, crea un nuevo objeto NIF con un número diferente.*/
            NIF nif = new NIF("1234567" + i, 'A');

            //Creamos la lista de pacientes asignados (inicialmente vacía)
            ArrayList<Paciente> pacientesAsignados = new ArrayList<>();

            //Creamos el médico
            /*Nota creacion de fechas: LocalDate.of(año, mes, día) crea una fecha.
            2010 + i significa que:
            i = 0 → LocalDate.of(2010, 1, 1) → Año 2010
            i = 1 → LocalDate.of(2011, 1, 1) → Año 2011
            i = 2 → LocalDate.of(2012, 1, 1) → Año 2012 
            Igual ocurre en apellido
            i = 0 → "Dr. Apellido1"
            i = 1 → "Dr. Apellido2"
            i = 2 → "Dr. Apellido3"            */
            Medico medico = new Medico(
                    especialidades[i],
                    pacientesAsignados,
                    3000 + (i * 200), // Salario base + incremento)
                    LocalDate.of(2010 + i, 1, 1), //Fecha contratación
                    "Dr. Apellido" + (i + 1), //Nombre completo
                    nif,
                    LocalDate.of(1970 + i, 1, 1)
            );

            // Asignamos el grupo profesional
            medico.setGrupoProf(grupos[i]);

            hospital.agregarEmpleado(medico);

        }
    }

    //CREACION DE 5 ADMINISTRATIVOS
    private static void crearAdministrativos(Hospital hospital) {
        //creamos los 5 grupos
        Grupo[] grupos = {Grupo.A, Grupo.B, Grupo.C, Grupo.D, Grupo.E};

        for (int i = 0; i < 5; i++) {
            NIF nif = new NIF("7654321" + i, 'B');

            //Creamos el administrativo
            Administrativo admin = new Administrativo(
                    grupos[i],
                    0, //Num inicial de registros
                    2000.00 + (i * 100), // Salario base + incremento
                    LocalDate.of(2015 + i, 1, 1), //fecha contratacion
                    "Admin apellido" + (i + 1), //Nombre completo
                    nif,
                    LocalDate.of(1980 + i, 1, 1) //fecha nacimiento
            );

            hospital.agregarEmpleado(admin);
        }
    }

    //CREACION DE 10 PACIENTES
    private static void crearPacientes(Hospital hospital) {
        /*Explicacion del for para nif pacientes
                i = 0 → "3333555" + 0 → "33335550"
                i = 1 → "3333555" + 1 → "33335551"
            'A' + i % 26 genera letras de la A a la Z:
            i = 0 → 'A' + (0 % 26) → 'A' + 0 = 'A'
            i = 1 → 'A' + (1 % 26) → 'A' + 1 = 'B'
            i = 2 → 'A' + (2 % 26) → 'A' + 2 = 'C'
            i = 26 → 'A' + (26 % 26) → 'A' + 0 = 'A'  ✅ *Reinicio*
            i = 27 → 'A' + (27 % 26) → 'A' + 1 = 'B'*/
        for (int i = 0; i < 10; i++) {
            //creacion del nif
            char letra = (char) ('A' + i % 26); //Letras de A a Z
            NIF nif = new NIF("3333555" + i, letra);

            //Creamos la lista de tratamientos vacía
            ArrayList<String> tratamientos = new ArrayList<>();

            //Creamos el paciente
            Paciente paciente = new Paciente(
                    "EXP - " + (1000 + i), //nº de expediente medico
                    tratamientos,
                    "Paciente apellido" + (i + 1), //nombre completo
                    nif,
                    LocalDate.of(1990 + i % 30, 1 + i % 12, 1 + i % 28) //fecha de nacimiento
            );
            hospital.agregarPaciente(paciente);
        }
    }

    //ASIGNACION DE TRATAMIENTOS
    private static void asignarTratamientos(Hospital hospital) {
        //Obtenemos pacientes y empleados
        ArrayList<Empleado> empleados = hospital.getEmpleados();
        ArrayList<Paciente> pacientes = hospital.getPacientes();

        // Asignamos tratamientos (asumimos que los primeros 5 empleados son médicos)
        /*Nota ¿Qué hace instanceof?instanceof se usa para comprobar si un objeto pertenece a una clase específica. 
        Se evalúa como true si el objeto es una instancia de la clase indicada o de una subclase de ella.
        Toma un objeto de la lista empleados con empleados.get(i).
        Comprueba si ese objeto es de tipo Medico con instanceof Medico.
        Si lo es, lo convierte (cast) a Medico, permitiendo acceder a sus métodos específicos.*/
        for (int i = 0; i < 5 && i < empleados.size(); i++) {
            if (empleados.get(i) instanceof Medico) {
                Medico medico = (Medico) empleados.get(i);

                //Cada medico tratará a 2 pacientes
                /*Nota ¿Cómo funciona (i * 2 + j) % pacientes.size();?
                i * 2 + j genera un número basado en el médico y su posición.
                % pacientes.size() asegura que no se salga del tamaño de la lista.
                    j	i * 2 + j               % pacientes.size()	Índice final
                   0	1 * 2 + 0 = 2               2 % 10 = 2                             2
                   1               1 * 2 + 1 = 3               3 % 10 = 3                             3*/
                for (int j = 0; j < pacientes.size(); j++) {
                    int pacientesIndex = (i * 2 + j) % pacientes.size();
                    Paciente paciente = pacientes.get(pacientesIndex);

                    String tratamiento = "Tratamiento de " + medico.getEspecialidad() + " - Dosis : " + (j + 1);
                    System.out.println("El Dr. " + medico.getNombreCompleto()
                            + " aplica tratamiento a " + paciente.getNombreCompleto() + " : " + tratamiento);

                    medico.tratarPaciente(paciente, tratamiento);
                }
            }
        }
    }

    //SIMULACION DE REGISTROS ADMINISTRATIVOS
    private static void realizarRegistrosAdministrativos(Hospital hospital) {
        ArrayList<Empleado> empleados = hospital.getEmpleados();
        String[] tiposDocumentos = {"Factura", "Historia clinica", "Análisis", "Radiografía", "Receta"};

        //Asumimos que los admins vienen despues de los medicos
        for (int i = 5; i < empleados.size(); i++) {
            if (empleados.get(i) instanceof Administrativo) {
                Administrativo admin = (Administrativo) empleados.get(i);

                // Cada administrativo registra 3 documentos
                for (int j = 0; j < 3; j++) {
                    String tipoDoc = tiposDocumentos[(i - 5 + j) % tiposDocumentos.length];
                    admin.registrarDoc(tipoDoc);
                }
            }
        }
    }

    //CALCULO IRPF
    private static void mostrarCalculoIRPF(Hospital hospital) {
        ArrayList<Empleado> empleados = hospital.getEmpleados();

        for (Empleado emp : empleados) {
            System.out.println("---------------------------------------------");
            System.out.println("Empleado : " + emp.getNombreCompleto());
            System.out.println("Salario : " + emp.getSalario() + "  €");
            System.out.println("---------------------------------------------");

            double irpf = emp.calcularIRPF(); //metodo abstracto de la clase empleado

            if (emp instanceof Medico) {
                Medico medico = (Medico) emp;
                System.out.println("Tipo: Médico - Especialidad: " + medico.getEspecialidad());
                System.out.println("Grupo profesional: " + medico.getGrupoProf());
                System.out.println("Porcentaje IRPF: " + (medico.getGrupoProf().getPorcentajeIRPF() * 100) + "%"); //metodo de la clase grupo
            } else if (emp instanceof Administrativo) {
                Administrativo admin = (Administrativo) emp;
                System.out.println("Tipo: Administrativo - Número de registros: " + admin.getNumRegistros());
                System.out.println("Grupo: " + admin.getGrupo());
                System.out.println("Porcentaje IRPF: " + (admin.getGrupo().getPorcentajeIRPF() * 100) + "%");
            }
            System.out.println("---------------------------------------------");
            System.out.println("IRPF a pagar: " + irpf + " €");
            System.out.println("---------------------------------------------");
            System.out.println("Salario neto: " + (emp.getSalario() - irpf) + " €");
            System.out.println("---------------------------------------------");
        }
    }

    /**
     * Busca un paciente por NIF y muestra sus datos Funcion de busqueda binaria
     * en clase hospital
     */
    private static void buscarPaciente(Hospital hospital, String numero, char letra) {
        System.out.println("Buscando paciente con NIF: " + numero + letra);
        Paciente pacienteEncontrado = hospital.buscarPacientePorNif(numero, letra);

        if (pacienteEncontrado != null) {
            System.out.println("Paciente encontrado: " + pacienteEncontrado.toString());
            System.out.println("Número de tratamientos: " + pacienteEncontrado.getTratamientos().size());
        } else {
            System.out.println("Paciente no encontrado.");
        }
    }

    /**
     * Prueba compleja que incluye operaciones avanzadas como tratamientos,
     * registros de documentos, búsquedas y ordenaciones
     */
    public static void pruebaCompleja() {
        // Creamos las listas para almacenar empleados y pacientes
        ArrayList<Empleado> empleados = new ArrayList<>();
        ArrayList<Paciente> pacientes = new ArrayList<>();

        // Creamos el hospital
        Hospital hospital = new Hospital("Vithas Estepona", empleados, pacientes);

        // Creamos médicos, administrativos y pacientes
        crearMedicos(hospital);
        crearAdministrativos(hospital);
        crearPacientes(hospital);

        // Simulamos tratamientos médicos
        System.out.println("\n== Tratamientos médicos ==");
        asignarTratamientos(hospital);

        // Simulamos registros administrativos
        System.out.println("\n== Registros administrativos ==");
        realizarRegistrosAdministrativos(hospital);

        // Ordenamos empleados por salario
        System.out.println("\n== Ordenando empleados por salario ==");
        hospital.ordenarEmpleadosPorSalario();
        hospital.mostrarEmpleados();

        // Mostramos explícitamente el cálculo de IRPF para cada empleado
        System.out.println("\n== Cálculo detallado de IRPF ==");
        mostrarCalculoIRPF(hospital);

        // Buscamos un paciente por NIF
        System.out.println("\n== Buscando paciente por NIF ==");
        buscarPaciente(hospital, "33335555", 'Z'); // Paciente que no existe
        buscarPaciente(hospital, "33335550", 'A');

        // Validamos un NIF
        System.out.println("\n== Validando NIF ==");
        NIF nifValido = new NIF("12345678", 'Z');
        System.out.println("NIF: " + nifValido.toString() + " - Válido: " + nifValido.validar());
    }

}
