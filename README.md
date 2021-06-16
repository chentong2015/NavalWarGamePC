# Projet LO23 - Bataille navale

## Fichier .gitconfig

A àjouter dans votre fichier de config:

[alias]

lg = log --graph --pretty=tformat:'%Cred%h%Creset -%C(auto)%d%Creset %s %Cgreen(%an %ar)%Creset'

[pull]

rebase = true


## Procédure sur Git :

Sur master :
```
git pull -r (on récupère la dernière version du dépôt)
git checkout -b ma-nouvelle-branche (on crée et on va sur une nouvelle branche pour travailler)
```

Sur ma-nouvelle-branche :
```
git commit (on fait ses commits)
git commit
...
(git rebase -i (si la branche n’est pas propre))
git push (si c'est le premier push il va vous afficher la commande à écrire)
ON ENVOIE UNE MERGE REQUEST SUR GITLAB à son responsable Qualité
Le responsable qualité doit alors s’assurer de la qualité du code et des commits
 -> S’il y a des modifications à faire
  -> le responsable qualité peut alors ajouter des commentaires aux lignes qui posent problème
  -> on fait ensuite les commits nécessaires pour corriger tout cela
  -> on refait une merge request
 -> Si tout va bien le responsable Qualité prend la suite

git checkout master (travail terminé et qui fonctionne, on retourne sur master)
```

Sur master :
```
git pull -r (on récupère les dernières modifs)
git checkout ma-nouvelle-branche (on retourne sur la branche)
```

Sur ma-nouvelle-branche :
```
git rebase master (pour rejouer nos commits après ceux de master pour plus de lisibilité dans l'historique)
git push -f (on force le push pour écraser l'ancien historique qui n'est plus bon)
git checkout master (on retourne sur master)
```

Sur master :
```
git merge --no-ff ma-nouvelle-branche (on fusionne notre branche sans la remettre à plat)
git push (on sauvegarde le tout)
```

## Computer games user interfaces 

![01](https://user-images.githubusercontent.com/23381494/122245101-b70e9f00-cec5-11eb-8087-699da64914fe.JPG)

![02](https://user-images.githubusercontent.com/23381494/122245113-baa22600-cec5-11eb-8677-7782d4c87a39.JPG)

![03](https://user-images.githubusercontent.com/23381494/122245126-bd048000-cec5-11eb-870f-c6fb6b3d6f95.JPG)

![04](https://user-images.githubusercontent.com/23381494/122245131-bf66da00-cec5-11eb-97dc-cdb27fb33709.JPG)

![05](https://user-images.githubusercontent.com/23381494/122245147-c392f780-cec5-11eb-8dcc-47c1e5c7bb78.JPG)

