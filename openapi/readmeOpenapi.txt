open api

#default url
http://localhost:8081/v3/api-docs

8081 - port by default or application port need add if you changed

v3 - version 3
api-doc - need to add else you can change in application.properties

springdoc.api-docs.path=/userinfo-docs 

add .yaml do download the documentation

http://localhost:8081/userinfo-docs.yaml

then

http://localhost:8081/userinfo-docs 

v3/api-docs -(is replaced by) -> userinfo-docs 

To get swagger-ui

http://localhost:8081/swagger-ui.html

for more info refer
https://www.youtube.com/watch?v=2bt11jYIp6E&t=264s
