sudo docker build -t caio/banco ./Postgres
sudo docker run -p 5433:5432  --name banco  -d caio/banco 
mvn clean package
sudo docker build -t caio/app .
sudo docker run -p 8082:8080 --name app --link banco:host-banco -d caio/app 