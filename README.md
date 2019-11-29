# java_studies

Estudos em Java

## Cursos

- [Full Stack](https://github.com/thomaserick/java_studies/tree/master/curso-Jdev)
- [Curso em Video](https://github.com/thomaserick/java_studies/tree/master/poo)

## Programadores Java
- JDK (Java Development KIT)
    - JRE
    - JavaLang
    - JavaTools
      - JavaC
      - Debugger
      - APIs

## Usuários Java

- JRE (Java runtime Enviroment)
 - JVM
  - Loader
  - Verificador
  - Interpretador
  - Gerenciador
  - Compilador JIT (Just in Time)
- Bibliotecas

# Instalação Ubuntu

- 1
~$ sudo Nautilus

- 2 Criar uma pasta chamada jvm em /usr/lib

- 3 Dentro da pasta jvm crie uma subpasta chamada java-8-oracle

- 4 Extrair os arquivos baixado para dentro da pasta java-8-oracle

- 5 Criar um arquivo chamado jdk.sh em /etc/profile.d
Obs: dentro da pasta abra o terminal clicando com o botão direito do mouse,
em seguida no menu contextual clique na opção abrir no terminal ou abrir terminal aqui.
use o comando ~$ echo "" (coloque sinal de maior aqui, o YT não permite o uso do sinal na descrição) jdk.sh

- 6 copiar as seguintes variaveis e colar no arquivo jdk.sh criado no passo 5
  - J2SDKDIR="/usr/lib/jvm/java-8-oracle"
  - J2REDIR="/usr/lib/jvm/java-8-oracle/jre"
  - JAVA_HOME="/usr/lib/jvm/java-8-oracle"
  - DERBY_HOME="/usr/lib/jvm/java-8-oracle/db"

source /etc/profile.d/jdk.sh

Obs: Após ter colado e salvado o arquivo, clique com o botão direito do mouse sobre o mesmo,
em seguida no menu contextual vá até propriedades, na aba Permissões marque a caixa onde diz:
Permitir execução de arquivo como um programa.

- 7 criar links do java e javac em /usr/bin
Obs: Prestem bem a atenção nessa parte, o gerenciador de arquivos precisa estar aberto como
root, assim como foi feito no passo 1. Selecione o arquivo java e javac contidos em /usr/lib/jvm/java-8-oracle  após selecionados
segure CTRL+SHIFT e arraste para dentro de /usr/bin para copiar como links.


sudo update-alternatives --install /usr/bin/java java /usr/lib/jvm/jdk1.8.0_221/bin/java 1

### Set Default Java Version

sudo update-alternatives --config java

Creditos : https://www.itzgeek.com/how-tos/linux/ubuntu-how-tos/how-to-install-oracle-java-jdk-10-8-on-ubuntu-18-04-ubuntu-17-10.html
