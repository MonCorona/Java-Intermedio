import java.util.*;


public class Main {
    public static void mostrarMateriales(List<? extends MaterialCurso> lista) {
        System.out.println("📚 Materiales del curso:");
        for (MaterialCurso material : lista) {
            material.mostrarDetalle();
        }
        System.out.println();
    }

    public static void contarDuracionVideos(List<? extends video> lista) {
        int total = 0;
        for (video video : lista) {
            total += video.getDuracion();
        }
        System.out.println("🎥 Duración total de videos: " + total + " minutos\n");
    }

    public static void marcarEjerciciosRevisados(List<? super Ejercicio> lista) {
        for (Object obj : lista) {
            if (obj instanceof Ejercicio ejercicio) {
                ejercicio.setRevisado(true);
                System.out.println("✅ Ejercicio '" + ejercicio.titulo + "' marcado como revisado.");
            }
        }
        System.out.println();
    }


    public static void main(String[] args) {
        List<MaterialCurso> materiales = new ArrayList<>();



        // Crear la lista de los videos
        List<video> videos = List.of(
                new video("Introducción a Java", "Mario", 15),
                new video("POO en Java", "Carlos", 20) );



        // Crear la lista de los articulos
        List<Articulo> articulos=List.of(
                new Articulo("Historia de Java", "Ana", 1200),
                new Articulo("Tipos de datos", "Luis", 800));

        // Crear la lista de los ejercicios
        List<Ejercicio> ejercicios=List.of(
                new Ejercicio("Variables y tipos", "Luis"),
                new Ejercicio("Condicionales", "Mario"));

        //Agregar todo a la lista de materiales
        materiales.addAll(videos);
        materiales.addAll(articulos);
        materiales.addAll(ejercicios);


        // Mostrar materiales
        mostrarMateriales(materiales);
        // Contar duración de videos
        contarDuracionVideos(videos);
        // Marcar ejercicios como revisados
        marcarEjerciciosRevisados(ejercicios);



    }
}