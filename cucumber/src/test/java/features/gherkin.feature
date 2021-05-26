Feature: bdg pruebas



@escenario1
Scenario Outline: ingresar con usuario y contraseña asignada
Given carga la pagina de bdg
When el usuario ingresa su user <user>  y su password <password>
And hace click en el boton de ingresar
Then ingresa a la pantalla principal 
Examples: 
|user       | password    |
|pargueta   | 123   |

@escenario2
Scenario Outline: ingresar con usuario inválido  y contraseña
Given carga la pagina de bdg
When el usuario ingresa su user <user>  y su password <password>
And hace click en el boton de ingresar
Then no deja entrar a  la pantalla principal
Examples: 
|user       | password    |
|pargueta   | INCORRECTA  |
|INVALIDO   | INCORRECTA  |


 
 
 
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