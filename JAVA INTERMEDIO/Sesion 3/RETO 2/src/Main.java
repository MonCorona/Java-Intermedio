import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        // Crear encuestas por sucursal
        List<Encuesta> encuestasCentro = List.of(
                new Encuesta("Annie", "El tiempo de espera fue largo", 2),
                new Encuesta("Lusia", null, 3),
                new Encuesta("Lidia", "El trato al paciente no me gustó", 2),
                new Encuesta("Carmen", "Todo bien", 5)
        );

        List<Encuesta> encuestasNorte = List.of(
                new Encuesta("Marco", "La atención fue buena, pero la limpieza puede mejorar", 3),
                new Encuesta("José", null, 4),
                new Encuesta("Lucas", "Falta personal en recepción", 2),
                new Encuesta("Sergio", "Me encanto todo", 5)
        );

        // Crear sucursales
        List<Sucursal> sucursales = List.of(
                new Sucursal("Centro", encuestasCentro),
                new Sucursal("Norte", encuestasNorte)
        );

        // Procesar encuestas
        List<String> mensajes = sucursales.stream()
                // flatMap nos permite desanidar las encuestas de cada sucursal
                .flatMap(sucursal -> sucursal.getEncuestas().stream()
                        // Filtrar solo encuestas con calificación 3 o menor
                        .filter(encuesta -> encuesta.getCalificacion() <= 3)
                        // Obtener solo las que tienen comentario presente
                        .map(encuesta -> encuesta.getComentario()
                                .map(comentario ->
                                        "Sucursal " + sucursal.getNombre() +
                                                ": Seguimiento a paciente con comentario: \"" + comentario + "\"")
                        )
                        .flatMap(Optional::stream)
                )
                // Convertir a lista de mensajes
                .collect(Collectors.toList());

        // Mostrar los mensajes en consola
        mensajes.forEach(System.out::println);
    }
}