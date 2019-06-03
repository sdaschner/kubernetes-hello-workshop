FROM open-liberty:javaee8

COPY target/hello-world.war /config/dropins/
