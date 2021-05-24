FROM openjdk:8-jre-alpine
RUN wget -O activemq.tar.gz http://archive.apache.org/dist/activemq/5.16.2/apache-activemq-5.16.2-bin.tar.gz
RUN tar -xzf activemq.tar.gz
RUN  sed -i "s|127.0.0.1|0.0.0.0|g" apache-activemq-5.16.2/conf/jetty.xml
CMD ["apache-activemq-5.16.2/bin/activemq", "console"]