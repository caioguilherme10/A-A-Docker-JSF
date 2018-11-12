FROM payara/micro
COPY /target/docker-jsf.war ${DEPLOY_DIR}
