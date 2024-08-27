# Usar a imagem oficial do Flink como base
FROM apache/flink:latest

# Diretório de trabalho dentro do contêiner
WORKDIR /opt/flink/usj_jobs



# Se você tiver outros arquivos de configuração, copie-os também
COPY src/main/java/com/example/milw0rm-dictionary.txt /opt/flink/usj_jobs/milw0rm-dictionary.txt 
COPY src/main/java/com/example/output.txt /opt/flink/usj_jobs/output.txt


# Ajustar permissões para os arquivos e diretórios
RUN chmod 755 /opt/flink/usj_jobs && \
    chmod 644 /opt/flink/usj_jobs/milw0rm-dictionary.txt && \
    chmod 644 /opt/flink/usj_jobs/output.txt