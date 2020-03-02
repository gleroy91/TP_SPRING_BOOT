Avant tout chose,s'assurer que mysql est installé sur votre ordinateur. Ensuite executer les commandes suivantes

`sudo mysql`
`create database tp_spring_leroy;`
`create user 'user'@'%' identified by 'password';`
`grant all on tp_spring_leroy.* to 'user'@'%';`

Lancer ensuite le projet depuis votre IDE favori. Prenez bien garde à ce que votre port 8080 soit bien libre.


