# Implementación de un Log de Errores


## Autores

- Daniel Barrera
- Nicolás Prieto

---

## Descripción

En este mini sistema de gestión de inventario desarrolado en BlueJ en lenguaje java que permite agregar, buscar y eliminar productos. El proyecto implementa un manejo de excepciones centralizado y un sistema de registro de errores en archivos de log.

---

## Clases

### Producto
Representa un producto del inventario con los atributos `id`, `nombre` y `cantidad`.

### Inventario
Contiene un `HashMap<Integer, Producto>` y expone tres métodos:
- `agregarProducto(Producto p)` — agrega un producto al inventario
- `buscarProducto(int id)` — retorna el producto con el id dado
- `eliminarProducto(int id)` — elimina el producto con el id dado

### InventarioException
Clase única de excepciones del sistema. Usa un `enum TipoError` para distinguir los tipos de error y métodos de fábrica estáticos para crearlas:
- `productoNoEncontrado(int id)` — lanzada cuando se busca o elimina un producto que no existe
- `inventarioVacio()` — lanzada cuando se intenta eliminar de un inventario vacío

---

## Sistema de logs

Se manejan dos archivos de log generados automáticamente en la carpeta `logs/` al ejecutar el programa:

- `expected_errors_log.txt` — registra las excepciones esperadas, es decir, los errores de tipo `PRODUCT_NOT_FOUND` y `EMPTY_INVENTORY`
- `inventario_log.txt` — registra cualquier error inesperado que ocurra en tiempo de ejecución

---

## Casos de prueba (Main)

La clase `Main` cubre los siguientes escenarios:

1. Agregar productos al inventario
2. Buscar un producto existente
3. Buscar un producto que no existe — genera `PRODUCT_NOT_FOUND`
4. Eliminar un producto existente
5. Eliminar un producto que no existe — genera `PRODUCT_NOT_FOUND`
6. Eliminar un producto de un inventario vacío — genera `EMPTY_INVENTORY`
