>[Home](Home.md)

# PawarV

```sh
# Run a single test
mvn -q -Dtest=JedisBasicsTest test
# Run a single method
mvn -q test -Dtest=JedisBasicsTest#testRedisList
```

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

```
metric:[unit-name]:[year-month-day]:[siteId]

```
>[Home](HOME.md)
