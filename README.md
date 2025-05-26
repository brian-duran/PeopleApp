# 👥 PeopleApp

Aplicación Android desarrollada con **Kotlin** y arquitectura **Clean Architecture**, que permite gestionar usuarios de forma local y remota. 💾🌐

## 🧠 Tecnologías y Arquitectura

- 🔹 **Kotlin**
- 🧱 **Clean Architecture**
- 🪄 **Jetpack Compose**
- ⚙️ **Hilt (Dependency Injection)**
- 💾 **Room Database**
- 🌍 **Retrofit (API Rest)**
- 🔄 **MVVM + LiveData**


## ✨ Funcionalidades

- Listado de usuarios generados aleatoriamente
- Edición de nombre, apellido y ciudad por usuario
- Persistencia local con Room
- Imágenes cargadas desde la web con Coil

![image](https://github.com/user-attachments/assets/f4e93fb6-39f5-46bd-bfff-e65c9b11ce40)  ![image](https://github.com/user-attachments/assets/fa5c2c2c-5bed-49fa-ae92-8a56be9d2835) ![image](https://github.com/user-attachments/assets/ebc63576-a846-4340-a372-a1af2b4e23ee) ![image](https://github.com/user-attachments/assets/b0f7b900-6116-4dd1-8369-e7fdb0ca5ac9)








## 📁 Estructura del Proyecto

📦 com.brian.duran.listapp
├── 📁 data                 # Fuente de datos (local y remota)
│   ├── 📁 local            # Base de datos local (Room)
│   │   ├── UserDao.kt
│   │   └── UserDB.kt
│   ├── 📁 network          # API remota (Retrofit)
│   │   └── UserApi.kt
│   └── 📁 repository       # Implementación de repositorio
│       └── UserRepositoryImpl.kt
│
├── 📁 di                   # Inyección de dependencias (Hilt)
│   ├── AppModule.kt
│   └── RepositoryModule.kt
│
├── 📁 domain              # Lógica de negocio
│   ├── 📁 model            # Modelos de dominio
│   │   ├── dto/
│   │   ├── ApiResponse.kt
│   │   └── User.kt
│   └── 📁 repository       # Definición de interfaces
│       └── UserRepository.kt
│
├── 📁 presentation        # Capa de UI
│   ├── 📁 home             # Pantalla principal
│   │   ├── components/
│   │   └── UserViewModel.kt
│   ├── 📁 edit             # Pantalla de edición
│   │   └── components/
│   ├── 📁 navigation       # Navegación entre pantallas
│   ├── 📁 ui.theme         # Estilos y temas
│   └── 📁 utils            # Utilidades generales
│       ├── Constants.kt
│   |── MainActivity.kt
│   └── MyApp.kt



