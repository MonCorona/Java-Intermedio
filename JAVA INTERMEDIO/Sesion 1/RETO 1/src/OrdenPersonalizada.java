public class OrdenPersonalizada extends OrdenProduccion {
    private String cliente;

    public OrdenPersonalizada(String codigo, int cantidad, String cliente){
        super(codigo,cantidad);
        this.cliente=cliente;
    }

    @Override // metodo de la clase  ORDENPRODUCCION para mostar informacion
    public void mostrarResumen() {
        System.out.println("🛠️ OrdenPersonalizada - Código: " + codigo + " - Cantidad: " + cantidad+" - Cliente: " +cliente);
    }


}