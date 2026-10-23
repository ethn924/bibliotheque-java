# Bibliothèque Java — AP2

Application de gestion de bibliothèque en Java/Swing, réalisée pour l'épreuve AP2 du BTS SIO SLAM.

![Java](https://img.shields.io/badge/Java-ED8B00?logo=openjdk&logoColor=white) ![Swing](https://img.shields.io/badge/UI-Swing-5382A1) ![JDBC](https://img.shields.io/badge/JDBC-007396) ![MySQL](https://img.shields.io/badge/MySQL-4479A1?logo=mysql&logoColor=white) ![BTS SIO](https://img.shields.io/badge/BTS_SIO-SLAM-0A66C2)

## Fonctionnalités

- Connexion d'un adhérent
- Catalogue des livres et fiche détaillée d'un livre
- Emprunt et liste des livres empruntés
- Espace « Mon compte »

## Architecture

Découpage MVC, avec l'accès aux données centralisé dans le modèle (JDBC + MySQL) :

```text
PROJET_ETHAN_AP2/src/
├── controller/  mainMVC.java (point d'entrée)
├── model/       ADHERENT, AUTEUR, LIVRE, model (accès BDD)
└── view/        View_Accueil, View_Connexion, View_Catalogue, View_Livre,
                 View_Emprunt, View_LivresEmpruntes, View_Compte
```

## Lancer le projet

1. Créer une base MySQL `ap2_ethan_2025` en local (identifiants dans `src/model/model.java`, `root`/`root` par défaut).
2. Importer le projet dans Eclipse ou IntelliJ, ajouter le connecteur MySQL (`mysql-connector-j`) au classpath.
3. Lancer `controller.mainMVC`.

## Documentation

La fiche de l'épreuve est dans `PROJET_ETHAN_AP2/Annexe7.1.B_AP2_LALIENNE.pdf`. Le projet est aussi présenté sur mon [portfolio](https://ethn924.github.io/Portfolio/projets/bibliotheque.html).
---

Réalisé par **Ethan Lalienne** · [GitHub](https://github.com/ethn924) · [Portfolio](https://ethn924.github.io/Portfolio/)
