## Spring AI + Kotlin 을 이용한 MCP client/server 구성

> Spring AI와 kotlin 공부를 위해 간단하게 구성해봄

### 구성 요소

- spring-ai-mcp-server: 알라딘 api를 호출하는 외부 도구 구현
- spring-ai-mcp-client: aws bedrock 에 있는 nova pro 모델에게 응답 생성 요청을 날리는 api 테스트용 api 구현

### 실행 방법

- git clone 후 spring-ai-mcp-server 에서 application.yaml에 알라딘 API KEY 발급 후 넣어줘야 함
- saml 방식으로 aws bedrock 통신을 하고 있기 때문에 saml 로그인 필요

### 코드 동작 흐름

![Image](https://github.com/user-attachments/assets/926f6bff-e114-4028-926f-1cc67f633e40)

### 참고사항

- Spring ai 최신 버전은 5/8 기준으로 `1.0.0-M8`이지만 현재는 해당 버전으로 실행할 경우, mcp client 에서 도구 바인딩이 안되는 문제가 존재하여 `1.0.0-M7`로 진행함
