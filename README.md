# **Puissance 4** 
![Puissance 4](http://www.android-mt.com/wp-content/uploads/fgp/post/Puissance4LOGO.png)

Le but de se projet est de mettre en place un jeu de puissance 4 en Java. Le jeu pourra être joueur de 1 à 2 joueurs. La date final du projet est le 9 Juin 2017.

----------

## <i class="icon-book">Cahier des charges
### Itérations
Lot 1 : Jeu fonctionnelle avec comme adversaire Humain contre Humain.

Lot 2 : Possibilité de jouer contre la machine (IA).

Lot 3 : Interface de jeu graphique.

Idée : Inscription avec classement sauvegardé.

### Technologies
Java sur eclipse.
Partie graphique : Swing.
Partie inscription : Json ou bien texte (bdd).

### Diagramme UML

![enter image description here](https://github.com/Bleuh/Puissance4/blob/master/Puissance4.png "Diagramme de classe java puissance 4.png")

----------

## Avancement du projet

Les 3 lots sont terminés

Un joueur peut jouer contre un autre joueur ou bien un ordinateur.
L'ia de l'ordinateur n'est pas très avancé mais suffisant pour jouer convenablement.
En effet, une ia parfaite gagnerait à tous les coups.

Suite au précédant projet, j'ai décidé de faire une interface graphique plus simpliste pour ne pas perdre de temps sur le développement de l'application.
La partie inscription n'est pas encore faite mais ne comporte pas d'utilisation de techniques apprise en cours. Je vais peut-être le laisser de côté.

Technique du cours : synchronized.
J'utilise un synchronized sur l'événement du clic avec un wait.
Lorsque le clic est effectué, il notify le synchronized.