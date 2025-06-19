public class OrdenMasa extends OrdenProduccion{

    public OrdenMasa(String codigo, int cantidad){
        super(codigo,cantidad);
    }
    @Override
    public void mostrarResumen() {
        System.out.println("🔧 Orden Masa - Código: " + codigo + " - Cantidad: " + cantidad );
    }


}