# POC - Utilização de VAULT para descriptografia

## Endpoint

### Descriptografar Texto

Este endpoint permite descriptografar um texto criptografado utilizando o serviço de Vault.

**Método**: `POST`  
**URL**: `http://localhost:8080/api/decrypt`

### Exemplo de Requisição

Você pode usar o `curl` para enviar uma requisição ao endpoint:

```bash
curl --location --request POST 'http://localhost:8080/api/decrypt' \
--header 'Content-Type: text/plain' \
--data-raw 'text-to-decrypt'

Parâmetros
Content-Type: text/plain
O cabeçalho deve ser definido como text/plain ao enviar a string criptografada.

Body:

text-to-decrypt: A string que você deseja descriptografar.
Configuração das Variáveis de Ambiente
Antes de rodar o projeto, você precisa configurar as seguintes variáveis de ambiente para o Vault:

```plaintext
# # ================ VAULT ==================== #
VAULT_BASE_URL=https://seu-vault-url:8200
VAULT_NAME_SPACE=admin/qa/health-platform
VAULT_APPROLE_ROLE=agentes-de-saude-health-prontuario
VAULT_APPROLE_ROLE_ID=role_id
VAULT_APPROLE_SECRET_ID=secret_id
VAULT_APPROLE_ENCRYPTKEY_NAME=prontuario
VAULT_KEY_PATH=transit
```

### Descrição das Variáveis
VAULT_BASE_URL: URL do seu servidor Vault.
VAULT_NAME_SPACE: Namespace usado para autenticação e operações no Vault.
VAULT_APPROLE_ROLE: O nome do AppRole que você está usando para autenticação.
VAULT_APPROLE_ROLE_ID: ID do AppRole.
VAULT_APPROLE_SECRET_ID: Secret ID do AppRole.
VAULT_APPROLE_ENCRYPTKEY_NAME: Nome da chave usada para criptografia/descriptografia.
VAULT_KEY_PATH: O caminho do Transit Secrets Engine.

### Rodando o Projeto com Spring Boot
Para rodar o projeto, siga os passos abaixo:

Clone o repositório (se ainda não o fez):

```bash
git clone https://seu-repositorio.git
cd seu-repositorio
```

Certifique-se de que o Maven está instalado. Você pode verificar isso executando:
```bash
mvn -v
```

Instale as dependências e construa o projeto:
```bash
mvn clean install
```

Execute o aplicativo Spring Boot:

```
bash
mvn spring-boot:run
```

Verifique se o aplicativo está rodando: Acesse http://localhost:8080 no seu navegador ou use curl para verificar se o servidor está ativo.

### Observações
Certifique-se de que o Vault esteja em execução e acessível antes de tentar descriptografar textos.
Você pode precisar de permissões apropriadas no Vault para que a operação de descriptografia funcione corretamente.
