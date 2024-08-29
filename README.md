# Spring AI Application

This is a Spring Boot application that integrates with OpenAI models using the `spring-ai-openai-spring-boot-starter`. The project demonstrates how to interact with OpenAI's API in a Spring Boot environment.

## Table of Contents

- [Features](#features)
- [Requirements](#requirements)
- [Setup](#setup)
- [Usage](#usage)
- [Endpoints](#endpoints)
- [Dependencies](#dependencies)
- [Contributing](#contributing)
- [License](#license)

## Features

- REST API with Spring Boot
- Integration with OpenAI using `spring-ai-openai-spring-boot-starter`
- Model classes to handle input and output
- Example controllers for handling AI requests

## Requirements

- Java 21
- Maven 3.6+
- An OpenAI API key (You can obtain an API key from [OpenAI's platform](https://platform.openai.com/account/api-keys)).

## Setup

1. **Clone the repository**:
   ```bash
   git clone <repository-url>
   cd spring-ai-application
   export OPENAI_API_KEY=YOUR_API_KEY
   mvn clean install
   mvn spring-boot:run
