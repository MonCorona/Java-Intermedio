import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        System.out.println("🏥 Iniciando acceso a la Sala de cirugía...\n");

        RecursoMedico salaCirugia = new RecursoMedico("Sala de cirugía");

        ExecutorService executor = Executors.newFixedThreadPool(4);

        executor.submit(() -> salaCirugia.usar("Dra. Martinez"));
        executor.submit(() -> salaCirugia.usar("Dr. Ramirez"));
        executor.submit(() -> salaCirugia.usar("Enfermero Alberto"));
        executor.submit(() -> salaCirugia.usar("Enfermera Martha"));
        executor.submit(() -> salaCirugia.usar("Dra. Garcia"));
        executor.submit(() -> salaCirugia.usar("Dra. Gonzales"));

        executor.shutdown();
    }
}