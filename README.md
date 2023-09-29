# ChallengeXPandIT

## Passos para Compilar e Executar o Aplicativo:
### 1. Preparar o Banco de Dados:
#### 1.1. Certifique-se de que o MySQL está em execução.
#### 1.2. Abra o MySQL Workbench, que foi o que eu utilizei mas pode abrir noutro aplicativo semelhante, e execute o arquivo geraDB.sql para criar o esquema do banco de dados.
#### 1.3. Em seguida, execute o arquivo populaDB.sql para inserir dados iniciais no banco de dados.
### 2. Executar o Aplicativo:
#### 2.1. Abra o Visual Studio Code (ou outro editor).
#### 2.2. Abra a pasta que contém o seu projeto.
#### 2.3. Abra um terminal no Visual Studio Code.
#### 2.4. Certifique-se de estar na raiz do projeto.
#### 2.5. Execute o seguinte comando para iniciar o aplicativo Spring Boot "./mvnw spring-boot:run".
### 3. Testar o Aplicativo:
#### 3.1. Abra o Postman (ou outra ferramenta de teste de API).
#### 3.2. Faça solicitações HTTP para as rotas do seu aplicativo para testar as funcionalidades.

Aproveito também para dizer que gostaria de ter conseguido melhorar o challenge, sendo que tem um pequeno erro (irei dizer qual é o erro mais para a frente) , mas de resto está tudo a funcionar corretamente. Queria ter conseguido melhorar o meu código que consigo ver que há aspetos a melhorar, mas como foi o meu primeiro contacto com maior parte das coisas, acabei por perder algum tempo só a corrigir erros e também a minha disponibilidade não foi a 100%.
O erro está no método que cria um filme, em que apenas queria incrementar o id para seguir uma sequência organizada e criava o filme com um id enorme, se depois me conseguirem explixar agradeço.
