# Examen coppel

Requerimientos del examen

Se requiere una aplicación móvil que cuente con los siguientes apartados:
    1.-Ventana de autenticación que haga uso del recurso: Firebase Authentication
    2.-Ventana de búsqueda, que a partir de un cuadro de búsqueda, muestre un listado
        de superhéroes de Marvel cuyo nombre inicie con el criterio de búsqueda.
    3.-Ventana con información e imagen del héroe seleccionado desde la lista previa.

Criterios a evaluar
El proyecto será calificado a partir de los siguientes criterios optativos:
    ● Uso de arquitectura de código
    ● Aplicación de patrón de diseño
    ● Uso de inyección de dependencias
    ● Uso de repository pattern
    ● Uso de control de versiones git (confirmando por Feat agregado)
    ● Aplicación de buenas prácticas

API
https://developer.marvel.com/

-----------------------------------------------------------------------------------------
Se utilizo la ultima version del entorno de desarrollo de androi stududio 2021.3.1

El proyecto esta realizado con la arquitectura MVVM + Clean arquitec

Se requieren de las siguientes depdencias para realizar el proyecto:

    implementation 'androidx.core:core-ktx:1.9.0'
    implementation 'androidx.appcompat:appcompat:1.5.1'
    implementation 'com.google.android.material:material:1.7.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.3'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'

    //ViewModel
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1"

    //LiveData
    implementation "androidx.lifecycle:lifecycle-livedata-ktx:2.5.1"

    //Fragment
    implementation "androidx.fragment:fragment-ktx:1.5.4"

    //Activity
    implementation "androidx.activity:activity-ktx:1.6.1"

    //Dagger hilt
    implementation "com.google.dagger:hilt-android:2.42"
    kapt "com.google.dagger:hilt-android-compiler:2.42"

    //Retrofil
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'

    //Room
    implementation "androidx.room:room-ktx:2.4.3"
    kapt "androidx.room:room-compiler:2.4.3"

    //Corrutinas
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4'

    //Glide
    implementation 'com.github.bumptech.glide:glide:4.14.2'
    kapt 'com.github.bumptech.glide:compiler:4.14.2'

    //Firebase
    implementation platform('com.google.firebase:firebase-bom:31.0.2')
    implementation 'com.google.firebase:firebase-analytics:'
    implementation 'com.google.firebase:firebase-auth-ktx:21.1.0'

    //AuthGoogle
    implementation 'com.google.android.gms:play-services-auth:20.3.0'

    //Servicios de google
    implementation 'com.google.android.gms:play-services-tasks:18.0.2'

    //Navigation
    implementation "androidx.navigation:navigation-fragment-ktx:2.5.3"
    implementation "androidx.navigation:navigation-ui-ktx:2.5.3"

-------------------------------------------------------------------------------------------------------    
NOTA:
1.-Adicional se creo una opcion para registrar un usuario a firebase
    *Pueden registrarce con culquier correo y poner cualquier contraseña
    *Una vez reqgistrados pueden iniciar sesion

2.-Dejo las credenciales en caso de que no quieran registrarse
    Email: jegoel02@gmail.com
    password: 123456

3.-Todas la librerias deberia de estar actualizados.

4.-Por cuestiones de tiempo me faltaron algunos detalles de validaciones en el login.