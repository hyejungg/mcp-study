# MCP Study

요즘 주목받고 있는 Model Context Protocol(MCP)을 실습하며 학습하는 공간

## 📁 레포지토리 구조

현재 레포지토리는 다음과 같은 예제들을 포함하고 있습니다:

- `kotlin-tutorial-anthropic/weather`: Kotlin을 사용한 Anthropics 기반의 날씨 예제 ([실습 링크](https://modelcontextprotocol.io/quickstart/server#python))
- `python-aws-bedrock/mcp-client`: Python과 AWS Bedrock을 활용한 MCP 클라이언트 ([실습 링크](https://modelcontextprotocol.io/quickstart/server#kotlin))
- `python-tutorial-anthropic/weather`: Python을 사용한 Anthropics 기반의 날씨 예제 ([실습 링크](https://community.aws/content/2uFvyCPQt7KcMxD9ldsJyjZM1Wp/model-context-protocol-mcp-and-amazon-bedrock))
- `spring-ai-kotlin-mcp-client-and-server`: Spring AI와 Kotlin을 활용한 MCP 클라이언트 및 서버

## 📌 MCP 구성 요소 및 통신 방식 정리

### 🧩 MCP 구성 요소

| 구성 요소      | 설명                                               | 역할                                                    |
| -------------- | -------------------------------------------------- | ------------------------------------------------------- |
| **MCP Client** | LLM을 호출하기 위한 래퍼                           | 사용자 입력을 받아 프롬프트 구성 후 MCP Host에 전달     |
| **MCP Host**   | LLM 실행 환경 또는 그 인터페이스                   | LLM의 응답 흐름 제어 및 MCP Server와의 통신 담당        |
| **MCP Server** | LLM이 사용할 외부 도구를 API 서버 형태로 구성한 것 | 툴 실행 결과를 Host에 반환 (예: DB 조회, 계산, 검색 등) |

```
사용자 → MCP Client → MCP Host ↔ MCP Server
                        ↕
                      LLM 실행
```

### 🔌 MCP Host ↔ MCP Server 간 통신 방식

1. Stdio 방식

- MCP Host가 MCP Server를 서브프로세스로 실행
- 통신은 표준 입력(stdin)과 표준 출력(stdout)을 통해 이루어짐
- 장점
  - 구현이 단순하고 빠름
  - 별도의 서버 배포 없이 단일 머신 내에서 실행 가능
- 단점
  - MCP Host와 MCP Server가 동일 머신 내에서 실행되어야 함
  - 분산 환경에서 확장이 어려움

2. SSE (Server-Sent Events) 방식

- MCP Host와 MCP Server가 HTTP를 통해 통신
- MCP Server는 Host에게 스트리밍 방식(SSE)으로 응답을 전송
- 장점
  - Host와 Server를 서로 다른 머신/환경에서 독립적으로 실행 가능
  - 확장성과 유연한 아키텍처 구성에 유리함
- 단점
  - 별도의 서버 구현 필요
  - sse 통신을 위한 엔드포인트 노출 필요
  - 인증 및 보안 설정 등 추가 작업 필요
  - 구현 복잡도 증가
