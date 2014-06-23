geektic2014
===========

Ceci constitue le point de départ de l'évaluation des formations Java EE et Architecture N-Tiers

Créez une application web **geektic** permettant de trouver l'âme soeur parmi un ensemble de geeks.

L'application proposera un formulaire de recherche permettant de choisir le sexe (homme, femme) des geeks recherchés,
et de saisir un centre d'intérêt (Java, C#, TDD, JUnit, PHP, etc.). La recherche affichera les geeks correspondants
aux critères.

Pour chaque geek, on pourra afficher son profil détaillé en cliquant dessus. Le profil détaillé contiendra toutes les
informations sur ce geek (nom, prénom, adresse e-mail, centres d'intérêts, gravatar, etc.).

Bonus : chaque fois qu'un profil détaillé est consulté, un compteur de consultation du geek sera augmenté, et une
ligne sera ajoutée à une table d'audit contenant l'instant précis de la consultation, l'adresse IP du visiteur, et bien
sûr le geek consulté.

L'aspect graphique de l'application est laissé à votre bon goût. Un script SQL permettant de créer le schéma,
et un autre permettant de le peupler avec des données permettant d'utiliser l'application, devront être fournis.

# Consignes techniques

Cette application devra bien sûr utiliser les technologies et l'architecture vue en cours :

 - Base de données relationnelle HSQLDB
 - Déploiement de l'application sur Tomcat
 - Spring MVC pour implémenter les services REST
 - Spring pour l'injection de dépendances
 - JPA/Hibernate pour l'implémentation des DAOs et des entités persistances
 - JUnit et Mockito pour l'écriture des tests unitaires
 - HTML5 et AngularJS pour construire l'interface graphique
 - Gradle pour construire l'application
 - Git pour versionner vos sources

Pour démarrer, vous commencerez par forker le repo Github https://github.com/Ninja-Squad/geektic2014. Vous pousserez
ensuite votre travail dans votre fork sur Github.

# Critères d'évaluation

 - Respect des consignes
 - Fonctionnement de l'application, et absence de bugs
 - Qualité de la conception
 - Respect des conventions de nommage Java
 - Qualité du code (indentation, nommage des classes, variables et méthodes, choix de types approprié, absence de
   répétitions, commentaires, bonnes pratiques de codage, etc.). Astuce: Gradle fournit des plugins PMD, Checkstyle,
   Findbugs, qui peuvent vous aider à vérifier la qualité de votre code. Un bonus sera accordé si vous mettez en place
   ces plugins
 - Présence et couverture des tests unitaires
 - Ergonomie, originalité et créativité de l'interface graphique
 - Présence de plusieurs commits successifs dans Github, montrant l'approche incrémentale de votre travail
 - Un bonus sera accordé si l'incrémentation du compteur de consultation et le remplissage de la table d'audit sont implémentés.

# Description du squelette du projet

Le répertoire `database` contient la base de données, ainsi que deux scripts (`.bat` ou `.sh` selon votre OS) permettant
respectivement de démarrer la base de données et de lancr un outil permettant de s'y connecter et d'exécuter des requêtes SQL.

Un fichier de build gradle vous est fourni. A vous d'y ajouter les plugins que vous voudriez utiliser en plus et de les
configurer. Les dépendances nécessaires à l'application sont pré-configurées.

L'application est constructible et déployable en l'état, et contient déjà une service REST et une page d'accueil
utilisant angular, affichant simplement un message d'accueil. A vous bien sûr de compléter l'application.

Une classe de base `BaseDaoTest`, et un exemple d'utilisation de cette classe de base `ExampleDaoTest` vous sont fournis
pour vous aider à implémenter vos tests de DAO.

# Environnement de travail

Comme d'habitude, si vous travaillez sur les machines de l'IUT, il vous faudra ajouter la ligne suivante au début du
fichier `gradlew.bat` :

    @set GRADLE_USER_HOME=F:\gradle_home

où, bien sûr, F:\gradle_home est le chemin du répertoire gradle_home sur votre machine.

Ensuite, vous pourrez générer le projet eclipse en lançant la commande

    gradlew eclipse

Vous importerez ensuite le projet dans Eclipse, et vous vous assurerez que dans la vue "Servers" de Eclipse, un serveur
Tomcat est configuré. Vous double-cliquerez sur le serveur tomcat, et dans l'onglet "Modules", vous derez en sorte que la
liste des modules contienne uniquement l'élément suivant:

Path  | Document Base | Module      | Auto Reload
----- | ------------- | ----------- | -----------
/     | geektic2014   | geektic2014 | Enabled
