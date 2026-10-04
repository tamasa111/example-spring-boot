# Build stage: compile to a native binary
FROM ghcr.io/graalvm/native-image-community:17 AS builder
WORKDIR /app
COPY . .
RUN ./mvnw -Pnative native:compile -DskipTests

# Run stage: no JVM needed, just a small glibc base
FROM debian:bookworm-slim
WORKDIR /app
COPY --from=builder /app/target/example-spring-boot app
EXPOSE 8080
ENTRYPOINT ["./app"]
