# 设置基础镜像
FROM openjdk:8-jre-alpine

# 设置工作目录
WORKDIR /opt/

# 复制jar程序包
ADD target/*.jar app.jar

# 设置时区
RUN echo "Asia/Shanghai" > /etc/timezone

# 设置语言
ENV LANG=zh_CN.UTF-8 LANGUAGE=zh_CN:zh LC_ALL=zh_CN.UTF-8

# 运行jar程序
ENTRYPOINT java -jar $JAVA_OPTS app.jar