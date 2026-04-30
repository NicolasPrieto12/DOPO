package com.inventario;

public class Main {

    public static void main(String[] args) {
        Inventario inventario = new Inventario();

        // --- Caso 1: Agregar productos ---
        System.out.println("=== Agregando productos ===");
        inventario.agregarProducto(new Producto(1, "Laptop", 10));
        inventario.agregarProducto(new Producto(2, "Mouse", 25));
        inventario.agregarProducto(new Producto(3, "Teclado", 15));
        System.out.println("Productos agregados correctamente.");

        // --- Caso 2: Buscar producto existente ---
        System.out.println("\n=== Buscando producto existente (id=1) ===");
        try {
            Producto p = inventario.buscarProducto(1);
            System.out.println("Encontrado: " + p);
        } catch (InventarioException e) {
            System.out.println("Error esperado: " + e.getMessage());
        }

        // --- Caso 3: Buscar producto que NO existe (PRODUCT_NOT_FOUND) ---
        System.out.println("\n=== Buscando producto inexistente (id=99) ===");
        try {
            inventario.buscarProducto(99);
        } catch (InventarioException e) {
            System.out.println("Error esperado [" + e.getTipoError() + "]: " + e.getMessage());
        }

        // --- Caso 4: Eliminar producto existente ---
        System.out.println("\n=== Eliminando producto existente (id=2) ===");
        try {
            inventario.eliminarProducto(2);
            System.out.println("Producto con id=2 eliminado correctamente.");
        } catch (InventarioException e) {
            System.out.println("Error esperado: " + e.getMessage());
        }

        // --- Caso 5: Eliminar producto que NO existe (PRODUCT_NOT_FOUND) ---
        System.out.println("\n=== Eliminando producto inexistente (id=99) ===");
        try {
            inventario.eliminarProducto(99);
        } catch (InventarioException e) {
            System.out.println("Error esperado [" + e.getTipoError() + "]: " + e.getMessage());
        }

        // --- Caso 6: Eliminar con inventario vacío (EMPTY_INVENTORY) ---
        System.out.println("\n=== Vaciando inventario y eliminando ===");
        try {
            Inventario vacio = new Inventario();
            vacio.eliminarProducto(1);
        } catch (InventarioException e) {
            System.out.println("Error esperado [" + e.getTipoError() + "]: " + e.getMessage());
        }

        System.out.println("\n=== Fin de pruebas. Revisa la carpeta logs/ ===");
    }
}
