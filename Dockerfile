FROM nginx:1.12.2

WORKDIR /usr/share/nginx/html
RUN rm index.html
ADD site /usr/share/nginx/html/