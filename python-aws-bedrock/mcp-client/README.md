### MCP Client 구축

- mcp server : anthropic mcp server tutorial 로 구축한 script 파일
- mcp client : ./client.py 파일
- mcp host (llm) : aws bedrock nova pro 모델 사용
  - tool calling model 이면 다 가능!

### 코드 동작 흐름

![Image](https://github.com/user-attachments/assets/28219a09-ed39-4cdb-9569-6b6d39f6f164)

### 코드 실행

- python 3.12

```
# uv 가 없다면
curl -LsSf https://astral.sh/uv/install.sh | sh

# client 코드 실행
uv client.py ../python-tutorial-anthropic/weather/weather.py
```
