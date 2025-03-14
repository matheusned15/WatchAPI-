# 📊 Plataforma de Monitoramento de APIs com Observabilidade Completa

Este projeto é uma plataforma de monitoramento de APIs com foco em **observabilidade completa**, utilizando ferramentas como **Elasticsearch, Logstash, Kibana (ELK Stack), Prometheus, Grafana, Jaeger e Kafka**. O objetivo é fornecer **monitoramento, rastreamento e análise de logs** em tempo real para serviços distribuídos.

---

## 🚀 **Tecnologias Utilizadas**

- **Docker & Docker Compose** → Gerenciamento de contêineres e orquestração.
- **Elasticsearch** → Armazenamento e busca de logs.
- **Logstash** → Processamento e envio de logs para o Elasticsearch.
- **Kibana** → Visualização e análise dos logs.
- **Prometheus** → Coleta de métricas para monitoramento.
- **Grafana** → Painéis interativos para visualização dos dados.
- **Jaeger** → Rastreio de requisições para observabilidade distribuída.
- **Kafka** → Mensageria para transporte de logs e eventos.

---

## 📌 **Pré-requisitos**

Antes de começar, você precisa ter instalado em sua máquina:

- **[Docker](https://www.docker.com/)**
- **[Docker Compose](https://docs.docker.com/compose/install/)**

---

## ⚙️ **Configuração e Instalação**

Clone o repositório:
```bash
 git clone https://github.com/seu-usuario/seu-repositorio.git
 cd seu-repositorio
```

Suba os serviços com Docker Compose:
```bash
 docker-compose up -d
```

Aguarde até que todos os contêineres estejam rodando. Você pode verificar o status com:
```bash
 docker ps
```

---

## 📊 **Acessando as Ferramentas**

| Serviço       | URL de Acesso                |
|--------------|------------------------------|
| **Kibana**   | [http://localhost:5601](http://localhost:5601) |
| **Grafana**  | [http://localhost:3000](http://localhost:3000) |
| **Prometheus** | [http://localhost:9090](http://localhost:9090) |
| **Jaeger**   | [http://localhost:16686](http://localhost:16686) |

---

## 🔎 **Testando a Plataforma**

### **1️⃣ Verificando se o Elasticsearch está rodando**
```bash
curl -X GET "http://localhost:9200"
```
Se estiver funcionando, a resposta será um JSON com informações do Elasticsearch.

### **2️⃣ Enviando um log de teste para o Logstash**

Caso tenha o `nc` instalado:
```bash
echo '{"message": "Teste de log", "level": "INFO"}' | nc localhost 5000
```
Caso esteja no Windows, pode usar o `PowerShell` para enviar logs via **Invoke-WebRequest**:
```powershell
Invoke-WebRequest -Uri "http://localhost:5000" -Method Post -Body '{"message": "Teste de log", "level": "INFO"}' -ContentType "application/json"
```

Depois, acesse o **Kibana** e veja se o log foi indexado.

### **3️⃣ Testando o Prometheus**
Abra o Prometheus em [http://localhost:9090](http://localhost:9090) e tente buscar métricas como:
```bash
up
```
Se tudo estiver funcionando corretamente, o resultado será `1`.

### **4️⃣ Visualizando Logs e Métricas no Grafana**
Após acessar o Grafana ([http://localhost:3000](http://localhost:3000)), faça login com:
- Usuário: `admin`
- Senha: `admin`

Crie um **Data Source** e adicione o Prometheus como fonte de dados (`http://prometheus:9090`).

---

## 🔥 **Parando e Removendo os Serviços**

Para parar os contêineres:
```bash
 docker-compose down
```
Para remover todos os volumes e redes associadas:
```bash
 docker-compose down -v
```

---

## 📌 **Melhorias Futuras**

- 📌 Integração com OpenTelemetry para métricas mais detalhadas.
- 📌 Implementação de alertas em tempo real com Grafana e Prometheus.
- 📌 Dashboards mais avançados para análise de logs e métricas.

---

## 📜 **Licença**

Este projeto é open-source e está licenciado sob a licença MIT.

---

💡 **Dúvidas ou sugestões?** Sinta-se à vontade para contribuir! 🚀

