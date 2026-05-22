docker build -t spring-test:latest .
docker run --rm -p 8080:8080 -v "$(pwd)/data:/app/data" spring-test:latest
