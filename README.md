# 📊 Generador de Credenciales de Evento

**Estudiante(s):**
* Eugenio Vergara – Patrones de Diseño (Sección 1)

## 🎯 Objetivo del Proyecto

Este sistema permite emitir credenciales personalizadas para un evento, a partir de una plantilla clonable. Se aplican los patrones de diseño **Prototype** (para clonar credenciales) y **Singleton** (para configuración global del evento).

## 🚀 Cómo ejecutar

1. Clonar el repositorio:

```bash
git clone https://github.com/EAVSX/GestorDeCredenciales.git
cd GestorDeCredenciales
```

2. Compilar y ejecutar

```bash
# Compilar todas las clases
javac -d bin src/datos/*.java src/negocio/*.java src/presentacion/*.java

# Ejecutar el programa
java -cp bin presentacion.DemoEvento
```

O alternativamente, usando NetBeans:

* Abre el proyecto en NetBeans
* Ejecuta la clase principal DemoEvento

## 🧬 Patrón Prototype – Aplicación

* Credencial implementa Cloneable.
* La plantilla se clona para crear nuevas credenciales:
```bash
  // Crear nueva credencial clonando la plantilla
    Credencial nuevaCredencial = plantilla.clone();
    nuevaCredencial.setNombre("Juan Pérez");
    nuevaCredencial.setRol("EXPOSITOR");
```

## 🔒 Patrón Singleton – Aplicación

* ConfiguracionEvento implementa el patrón Singleton
* Contiene la configuración global del evento
* Se accede con getInstancia():
 ```bash
    ConfiguracionEvento config = ConfiguracionEvento.getInstancia();
    String nombreEvento = config.getNombreEvento();
```
## 🖥️ Menú por consola
![Menu](https://github.com/user-attachments/assets/c84c37b6-26e4-4374-b577-1731e9b5f55b)

## 📊 Diagrama de Clases (UML)

![Sistema de credenciales](https://github.com/user-attachments/assets/105391b2-6ed1-434a-8806-d435d88788f5)

## 📸 Captura del sistema funcionando

![Opcion1](https://github.com/user-attachments/assets/c9990f28-308e-4250-bdb9-f470eb40b8e2)
---
![Opcion 2](https://github.com/user-attachments/assets/e4f4637e-484c-405f-a1f2-8d0566a9948b)
---
![Opcion 3](https://github.com/user-attachments/assets/24935fc1-32ae-4944-83ae-8b9f43c65b73)


## 👨‍💻 Autor

Eugenio Vergara - Estudiante de Programación  
Instituto Santo Tomás

## 📄 Licencia

Este proyecto fue desarrollado como parte del curso de Patrones de Diseño en el Instituto Santo Tomás.

## 📞 Contacto

* Eugenio Vergara
* Email: [e.vergara29@alumnos.santotomas.cl]
* GitHub: @EAVSX

