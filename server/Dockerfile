###
# Needs a sonarqube daemon running
# FROM newtmitch/sonar-scanner as sonar
# WORKDIR /src
# ADD . /src
# RUN sonar-scanner
#
FROM golang:1.13 as build
RUN go get -d -v github.com/gorilla/mux
RUN go get go.mongodb.org/mongo-driver/mongo
WORKDIR /src
ADD . /src
RUN CGO_ENABLED=0 GOOS=linux go build -a -installsuffix cgo -o gotodo .
#RUN GOOS=linux go build -a -o gotodo .

FROM alpine:latest
RUN apk --no-cache add ca-certificates
WORKDIR /app
COPY --from=build /src/gotodo /app
ENTRYPOINT ./gotodo

