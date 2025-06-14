# Spring AI Tutorial with OpenAI and Ollama

This repository contains a Spring Boot application that demonstrates the integration of multiple Large Language Models (LLMs) including OpenAI and Ollama, using the Spring AI library. The project also includes a React-based UI for comparing responses from different models.

## Project Structure

```
SpringAIDemo/
├── src/
│   ├── main/
│   │   ├── java/             # backend code
│   │   ├── resources/        # Application properties and static resources
│   │   └── llm-comparison-ui/ # React frontend application
└── ...
```

## Features

- Integration with multiple LLM providers:
    - OpenAI (GPT models)
    - Ollama (Local models)
- REST API endpoints for interacting with each LLM
- React-based user interface for comparing model responses side-by-side
- Configurable prompts and model parameters

## Prerequisites

- Java 21 or higher
- Maven 3.6 or higher
- Node.js and npm (for the React UI)
- API keys for OpenAI
- Ollama installed locally


### Backend Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/shishal/SpringAIModels.git
  
   ```

2. Configure your API keys in `application.yml` or via environment variables:
   ```yml
    spring:
      ai:
        openai:
        api-key: ${OPEN_API_KEY}
   ```

3. Build the Spring Boot application:
   ```bash
   mvn clean package -DskipTests
   ```

### Frontend Setup

1. Navigate to the React UI directory:
   ```bash
   cd src/main/llm-comparison-ui
   ```

2. Install dependencies:
   ```bash
   npm install
   ```

3. Build the UI:
   ```bash
   npm run dev
   ```




## License

[MIT](https://choosealicense.com/licenses/mit/)

## Acknowledgements

- [Spring AI](https://docs.spring.io/spring-ai/reference/index.html)
- [OpenAI API](https://openai.com/blog/openai-api)
- [Ollama](https://ollama.ai/)

## Contact

For any questions or feedback, please check out:
- GitHub: [shishal/SpringAIModels](https://github.com/shishal/SpringAIModels.git)