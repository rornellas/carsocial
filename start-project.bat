echo "########## START CAR-SOCIAL APP" ##########"

echo "********************************************************"
echo "Generate binary files for service api and running service"
echo "********************************************************"

gradlew bootJar && docker-compose up -d --build