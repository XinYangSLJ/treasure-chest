# 基础镜像
from sapmachine/jdk11:latest

# 作者
MAINTAINER asyf
#中文字体显示为方框，导入中文字体解决（路径根据容器的字体路径调整）
COPY simsun.ttf /usr/share/fonts/truetype/dejavu

#解决中文乱码的问题
ENV LANG C.UTF-8

# 把可执行jar包复制到基础镜像的根目录下
ADD demo.jar /demo.jar

# 镜像要暴露的端口，如要使用端口，在执行docker run命令时使用-p生效
EXPOSE 8080

# 在镜像运行为容器后执行的命令,运行jar包
ENTRYPOINT ["java","-jar","/demo.jar","&"]