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




@seleniumTest1
Scenario Outline: Search for items and then move to checkout page
Given User is on Greencart Langing page2
When User seached for <vegetal> vegetable2
And Added items to cart
And User proceeded to Checkout page for purchase
Then verify selected <vegetal> items are displayed in check	out page

Examples: 
|vegetal  |
|Cucumber |
|Brinjal  |