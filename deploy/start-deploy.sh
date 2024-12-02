cd ..
echo "Fazendo o build da aplicação"
mvn clean package -DskipTests

echo "Subindo a aplicação"
docker-compose up