FROM openjdk:11
COPY ./target/spe.miniproject-0.0.1-SNAPSHOT-jar-with-dependencies.jar ./
WORKDIR ./
CMD ["java","-cp","spe.miniproject-0.0.1-SNAPSHOT-jar-with-dependencies.jar","Calculator"]