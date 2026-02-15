# frontend/Dockerfile
FROM node:20-alpine
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
EXPOSE 5173
# --host flaget er vigtigt for at kunne tilgå den fra din browser udenfor Docker
CMD ["npm", "run", "dev", "--", "--host"]
