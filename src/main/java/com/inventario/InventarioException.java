package com.inventario;

public class InventarioException extends Exception {

    public enum TipoError {
        PRODUCT_NOT_FOUND,
        EMPTY_INVENTORY
    }

    private final TipoError tipoError;

    private InventarioException(TipoError tipoError, String mensaje) {
        super(mensaje);
        this.tipoError = tipoError;
    }

    public TipoError getTipoError() { return tipoError; }

    // Fábricas estáticas — una por cada excepción esperada
    public static InventarioException productoNoEncontrado(int id) {
        return new InventarioException(
                TipoError.PRODUCT_NOT_FOUND,
                "Producto con id " + id + " no encontrado."
        );
    }

    public static InventarioException inventarioVacio() {
        return new InventarioException(
                TipoError.EMPTY_INVENTORY,
                "No se puede eliminar: el inventario está vacío."
        );
    }
}
