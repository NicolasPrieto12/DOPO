package com.inventario;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.*;

public class Inventario {

    private final HashMap<Integer, Producto> productos = new HashMap<>();

    private static final Logger expectedLog = Logger.getLogger("expected_errors_log");
    private static final Logger inventarioLog = Logger.getLogger("inventario_log");

    static {
        configurarLogger(expectedLog, "logs/expected_errors_log.txt");
        configurarLogger(inventarioLog, "logs/inventario_log.txt");
    }

    private static void configurarLogger(Logger logger, String ruta) {
        logger.setUseParentHandlers(false);
        try {
            FileHandler handler = new FileHandler(ruta, true);
            handler.setFormatter(new SimpleFormatter());
            logger.addHandler(handler);
        } catch (IOException e) {
            Logger.getGlobal().warning("No se pudo crear el archivo de log: " + ruta);
        }
    }

    public void agregarProducto(Producto p) {
        productos.put(p.getId(), p);
    }

    public Producto buscarProducto(int id) throws InventarioException {
        try {
            if (!productos.containsKey(id)) throw InventarioException.productoNoEncontrado(id);
            return productos.get(id);
        } catch (InventarioException e) {
            expectedLog.warning(e.getMessage());
            throw e;
        } catch (Exception e) {
            inventarioLog.severe("Error inesperado en buscarProducto: " + e.getMessage());
            throw e;
        }
    }

    public void eliminarProducto(int id) throws InventarioException {
        try {
            if (productos.isEmpty()) throw InventarioException.inventarioVacio();
            if (!productos.containsKey(id)) throw InventarioException.productoNoEncontrado(id);
            productos.remove(id);
        } catch (InventarioException e) {
            expectedLog.warning(e.getMessage());
            throw e;
        } catch (Exception e) {
            inventarioLog.severe("Error inesperado en eliminarProducto: " + e.getMessage());
            throw e;
        }
    }
}
