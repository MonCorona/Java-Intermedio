import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        List<Pedido> pedidos = List.of(
                new Pedido("Luis", "domicilio", "568-1934"),
                new Pedido("Ana", "local", "754-9587"),
                new Pedido("Carlos", "domicilio", null),
                new Pedido("Elena", "domicilio", "555-5678"),
                new Pedido("Jorge", "local", null)
        );

        pedidos.stream()
                .filter(p -> p.getTipoEntrega().equalsIgnoreCase("domicilio"))
                .map(Pedido::getTelefono)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(tel -> "📞 Confirmación enviada al número: " + tel)
                .forEach(System.out::println);
    }
}