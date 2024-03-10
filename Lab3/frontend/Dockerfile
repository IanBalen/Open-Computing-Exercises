# Izaberite Node kao osnovnu sliku
FROM node:alpine as build-stage

# Postavite direktorij za rad
WORKDIR /app

# Kopirajte package.json i package-lock.json (ako postoji)
COPY package*.json ./

# Instalirajte ovisnosti
RUN npm install

# Kopirajte izvorni kod projekta
COPY . .

# Izgradite aplikaciju
RUN npm run build

# Izaberite nginx za posluživanje statičkih datoteka
FROM nginx:stable-alpine as production-stage

# Kopirajte izgrađenu aplikaciju iz build-stage
COPY --from=build-stage /app/build /usr/share/nginx/html

# Izložite port 80
EXPOSE 80

# Pokrenite nginx
CMD ["nginx", "-g", "daemon off;"]