> [Home](Home.md)

# PawarV

## Initial Setup

### Links

1. https://redis.io/
2. [Redis Streams Explained YouTube](https://www.youtube.com/watch?v=Z8qcpXyMAiA)
3. [Seven Databases in Seven Weeks, 2nd Edition](https://learning.oreilly.com/library/view/seven-databases-in/9781680505962/)

### Running the redis stack with Docker

```sh
## Go to the project home directory
cd ~/git/ru102j
## start the docker containers
docker compose up -d
## stop the container (later)
docker compose down
## connect to redis
docker exec -it redis_ru102j redis-cli
## quit redis
quit
```

### Starting the application

```sh
cd ~/git/ru102j
### package
mvn package
### package skipping tests
mvn package -DskipTests
## Load the sample data
java -jar target/redisolar-1.0.jar load
## Erase the sample data (Later)
java -jar target/redisolar-1.0.jar load --flush true
## Start the application
java -jar target/redisolar-1.0.jar server config.yml
## Run all tests
mvn test
## Run a single test
mvn test -Dtest=JedisSolarBasicsTest

```

Go to the site at http://localhost:8081

Check redis here http://localhost:8001

### Create a basic project

```sh
cd ~/git/redisuni/code
## Maven command to create a new project
mvn archetype:generate -DarchetypeGroupId=io.dropwizard.archetypes -DarchetypeArtifactId=java-simple -DarchetypeVersion=2.0.25

```

### Tests

```sh
curl http://localhost:8081
curl http://localhost:8081/api/meterReadings
curl -X POST http://localhost:8081/api/meterReadings -d '{
"siteId": 1,
"dateTime": "2020-01-01T00:00Z[UTC]",
"whUsed": 2.5,
"whGenerated": 3.0,
"tempC": 22.0
}'

```

### Redis client

````sh
## ping
ping
## set
set key1 value1
## get
get key1

```sh
# Run a single test
mvn -q -Dtest=JedisBasicsTest test
# Run a single method
mvn -q test -Dtest=JedisBasicsTest#testRedisList
````

```sh
# start the docker containers
docker exec -it redis_ru102j redis-cli

```

```sh
# create a sorted set
zadd pvm:wHg:2020-02-01:1  0 18:1 1 18.5:1 2 19:3  3 18:3
# get the sorted set
zrange pvm:wHg:2020-02-01:1 0 -1
# get the sorted set with scores
zrange pvm:wHg:2020-02-01:1 0 -1 withscores
# get the sorted set with scores in reverse order
zrevrange pvm:wHg:2020-02-01:1 0 -1 withscores
# get the rank of an item
zrank pvm:wHg:2020-02-01:1 Bob
zrank pvm:wHg:2020-02-01:1 Ana
zrank pvm:wHg:2020-02-01:1 Charlie
# get the score of an item
zscore pvm:wHg:2020-02-01:1 Bob
zscore pvm:wHg:2020-02-01:1 Charlie
# get the number of items in the sorted set
zcard pvm:wHg:2020-02-01:1
# get the number of items in the sorted set with a score between 2 and 3
zcount pvm:wHg:2020-02-01:1 2 3
# increment the score of an item
zincrby pvm:wHg:2020-02-01:1 50 Ana
# delete all items with a score between 2 and 3
zremrangebyscore pvm:wHg:2020-02-01:1 0 100
```

# Challenge 2

```
metric:[unit-name]:[year-month-day]:[siteId]

metric:wHg:2020-02-01:1 0 18:1 1 18.5:1 2 19:3  3 18:3

mvn test -Dtest=MetricDaoRedisZsetImplTest
mvn package
java -jar target/redisolar-1.0.jar load
java -jar target/redisolar-1.0.jar server config.yml
```

## challenge 3

```sh
mvn test -Dtest=SiteStatsDaoRedisImplTest
```



## Miscelleneous

```sh
# show what's listening on port 8081
sudo lsof -i :8081
# another way to show what's listening on port 8081
sudo netstat -tulpn | grep :8081
# install netstat
sudo apt install net-tools
```
> [Home](HOME.md)
