# Start your image with a node base image
FROM node:18-alpine

# The /app directory should act as the main application directory
WORKDIR /app

# Copy the app package and package-lock.json file
# COPY package*.json ./

# Copy local directories to the current local directory of our docker image (/app)
COPY . /app
# COPY ./build ./build
# COPY ./config ./config
# # COPY ./node_modules ./node_modules
# COPY ./src ./src
# COPY ./static ./static
# COPY ./test ./test

# Install node packages, install serve, build the app, and remove dependencies at the end
RUN npm install 

RUN npm run build

EXPOSE 8080

# Start the app using serve command
CMD [ "npm", "run", "dev" ]