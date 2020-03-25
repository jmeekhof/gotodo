FROM node:12.2.0-alpine

WORKDIR /app

ENV PATH /app/node_modules/.bin:$PATH

COPY package.json /app/package.json

ARG npm_config_registry=""
RUN npm install yarn -g
RUN yarn install --silent
RUN npm install react-scripts@3.0.1 -g --silent

CMD ["yarn", "start"]
