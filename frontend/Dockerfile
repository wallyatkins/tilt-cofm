# Frontend Dockerfile
FROM node:14

WORKDIR /app

# Copy package.json and package-lock.json separately
# This allows Docker to cache the npm install step
COPY package.json package-lock.json ./
RUN npm ci

# Copy the rest of the code
COPY . .

RUN npm run build

EXPOSE 3000

CMD ["npm", "run", "dev"]
