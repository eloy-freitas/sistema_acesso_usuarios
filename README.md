# Sistema de acesso de usuários
Trabalho final da disciplina de padrões de projetos de software

## Instalar o JAR de validadorsenha no repositório local do Maven
```
mvn install:install-file \
 -Dfile=libs/ValidadorSenha-1.08-SNAPSHOT-jar-with-dependencies.jar \
 -DgroupId=com.pss.senha.validacao \
 -DartifactId=ValidadorSenha \
 -Dversion=1.08-SNAPSHOT \
 -Dpackaging=jar
```

### A especificação do trabalho está no diretório docs/