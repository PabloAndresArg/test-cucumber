Feature: bdg pruebas



@escenario1
Scenario Outline: ingresar con usuario y contraseña asignada
Given carga la pagina de bdg
When el usuario ingresa su user <user>  y su password <password>
And hace click en el boton de ingresar
Then ingresa a la pantalla principal 
Examples: 
|user       | password    |
|pargueta   | Root@7arg   |

@escenario2y3
Scenario Outline: ingresar con usuario inválido  y contraseña
Given carga la pagina de bdg
When el usuario ingresa su user <user>  y su password <password>
And hace click en el boton de ingresar
Then no deja entrar a  la pantalla principal
Examples: 
|user       | password    |
|pargueta   | INCORRECTA  |
|INVALIDO   | INCORRECTA  |



@escenario4
Scenario: selecciona un rol
Given carga la pagina de bdg en la pantalla principal
When selecciono un rol del combobox
And hace click en el boton de s7
Then ingresa al panel de bdg 





@escenario5
Scenario Outline: cambio de contraseña
Given carga el panel administrativo de bdg <passActual>
When hace click en desplegar menu
And hace click en administracion 
And hace click en configuracion de usuarios
And hace click en cambio de contraseña
And ingresa la contraseña  actual <passActual>
And ingresa la contraseña nueva  <newPass>
And verifica la contraseña nueva <newPass>
And click en aceptar
Then logearme con nueva contraseña <newPass>
Examples: 
|newPass  |passActual|
|Root$7arg|Root@7arg|
|Root@7arg|Root$7arg|


@escenario6 
Scenario: Reiniciar la contraseña de un usuario 
Given carga el panel administrativo de bdg2 "root@7arg"
When hace click en desplegar menu
And hace click en administracion 
And hace click en configuracion de usuarios
And hace click en administracion de usuarios
And busca el usuario "lmessi" presionando en buscar
And hace click en reiniciar contraseña
And se mueve a desplegar menu en la esquina derecha   Customer care mensajeria
Then observara la informacion en el ultimo mensaje de la contraseña que se asigno
































@escenario7
Scenario Outline: Crear una Persona
Given carga el panel administrativo de bdg2 "root@7arg"
When hace click en desplegar menu
And hace click en administracion 
And selecciona  persona la cual se encuentra en el apartado de catalogos basicos
And hace click en crear dentro del modulo de catalogos basicos persona
And llena el formulario de creacion de persona con los campos nombres <nombres> , apellidos <apellidos>  y sexo <sexo> cumpliendo asi los campos necesarios
Then hace click en guardar
And Aparezca en la consulta de personas con su nombre <nombres> y apellidos <apellidos>
Examples: 
|nombres     |apellidos     |sexo|
|t1          |t1            |M |

 

 
@escenario8
Scenario Outline: Convertir una persona en Empleado
Given carga el panel administrativo de bdg2 "root@7arg"
When hace click en desplegar menu
And hace click en administracion 
And selecciona  persona la cual se encuentra en el apartado de catalogos basicos
And busca a la persona de nombres <nombres> y apellidos <apellidos> llenando el formulario dandole click en buscar 
Then lo convierte en empleado 
And verifica si se convirtio en empleado mediante una busqueda por nombre <nombres> y apellido <apellidos>
Examples: 
|nombres     |apellidos     |
|t1          |t1            |



@escenario9
Scenario Outline: crear un usuario
Given carga el panel administrativo de bdg2 "root@7arg"
When hace click en desplegar menu
And hace click en administracion 
And hace click en configuracion de usuarios
And hace click en administracion de usuarios
And click en el boton para agrgar usuarios
And busca al empleado por medio de nombre <nombres> y apellido <apellidos>
And ingresa un nuevo usuario <username> ingresandolo en el textbox seguido presiona registar
And se mueve a desplegar menu en la esquina derecha   Customer care mensajeria
Then observara la informacion en el ultimo mensaje de la contraseña que se asigno
Examples: 
|nombres     |apellidos | username |
|t1          |t1        |	t1user   |

@escenario10
Scenario Outline: asignacion de Rol
Given carga el panel administrativo de bdg2 "root@7arg"
When hace click en desplegar menu
And hace click en administracion 
And hace click en configuracion de usuarios
And hace click en administracion de roles
And hace click en asignar usuarios
And busco el usuario por nombre <nombres> y apellido <apellidos> y su vez se selecciona
Then verifica que se pueda logear con el usuario <username> y su password <password>
And establecer una contraNueva <newPassword> quitando la antigua <password>
And logeo con user <username> y pass <contraNueva> para verificar la nueva contrasena 
Examples: 
|nombres     |apellidos | username | password  | newPassword |
|t1          |t1        |	t1user   |	t30ghxuo | Root@7arg   | 


