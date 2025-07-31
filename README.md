# 🧱 Microservicio de Productos e Inventario - Spring Boot + Docker

Este proyecto contiene dos microservicios desarrollados con Spring Boot:

- **Product Service**: Gestiona productos (nombre, descripción, precio).
- **Inventory Service**: Administra el inventario asociado a los productos y consulta información del producto usando Feign.

---

## 📁 Estructura del Proyecto


---

## ⚙️ Tecnologías usadas

- Java 17
- Spring Boot
- Spring Web, JPA, H2
- OpenFeign
- Docker y Docker Compose
- Lombok
- Maven

---


## 🚀 ¿Cómo ejecutar el proyecto?

### 1. Clona el repositorio

```bash
git clone https://github.com/tu-usuario/tu-repo.git
cd tu-repo

Desde la raíz de cada microservicio:

bash
Copiar
Editar
cd product-service
./mvnw clean package -DskipTests

cd ../inventory-service
./mvnw clean package -DskipTests

3. Ejecuta con Docker Compose
bash
Copiar
Editar
docker-compose up --build
Esto construirá las imágenes y levantará ambos microservicios.

🌐 Endpoints
🔹 Product Service
GET http://localhost:9057/api/products

POST http://localhost:9057/api/products

json
Copiar
Editar
{
  "nombre": "Producto A",
  "descripcion": "Un producto de prueba",
  "precio": 100
}
🔹 Inventory Service
GET http://localhost:9058/api/inventory

POST http://localhost:9058/api/inventory

json
Copiar
Editar
{
  "productId": 1,
  "quantity": 10
}
GET http://localhost:9058/api/inventory/details/{productId}

para ver las url y probar desde swagger peude acceder a las url
http://localhost:9057/swagger-ui/index.html#
http://localhost:8080/swagger-ui/index.html#

📝 Autor
Brayan David Espitia Orjuela
Ingeniero de Sistemas