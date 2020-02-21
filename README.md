# MapReducer

## Sujet
Mettre le CSV en PJ dans un répertoire hdfs puis écrire trois mappers et deux reducers (en script ou java) pour obtenir par une combinaison adéquate :
- Montant des locations par client (mail)
- Montant des locations par rating
- Film le + loué par rating

## Compétences
- Concevoir un traitement MapReduce
- Coder un mapper et un reducer en java (ou autre langage)

## Livrable
Zip des scripts/sources java ou Fichier contenant une url GitHub

## Utilisation
Pour réaliser correctement le TP il faut utiliser les commandes suivantes:

### Le dossier input

- Créer le dossier d'input : `hdfs dfs -mkdir /input`
- Placer les données dans le dossier input `hdfs dfs -put <File.csv> /input`
- Vérifier le contenue du dossier input `hdfs dfs -ls /input`

### Le dossier output
- Vérifier le contenue du dossier output `hdfs dfs -ls /output`
- Supprimer le dossier output `hdfs dfs -rm -r /output`
- Afficher le résultat du reducer `hdfs dfs -cat /output/<ResultFilename>`

### La création du jar
Dans eclipse, Assurez-vous d'abord que le jar n'est pas déjà créé (si existant, supprimer le depuis eclipse via la fenêtre de hiérarchie.
- Cliquez sur File > Export...
- Sélectionnez java/JAR file et cliquez sur "Next"
- Dans "Select the ressources to export", cochez le dossier de votre projet. Puis, dans "Select the export destination", nommez votre jar et donner lui une destination.
Cliquez sur "Next"
- Cliquez sur "Next"
- Dans "Select the class of the application entry point", cliquez sur "Browse..." puis sélectionner le bon fichier java ou se trouve votre main.
Cliquez sur "OK" puis "Finish"

### Lancement de hadoop
Afin de lancer le programe, exécutez la commande suivante :
`hadoop jar <VotreJar.jar> -D mapred.reduce.task=10 /input /output`

## Rendu
Adresse du dépôt : https://github.com/maximecohen2/management_deploiment_solution_big_data_i2_mapreducer
