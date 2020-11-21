docker run --name pg-docker -e POSTGRES_PASSWORD=A@a12345 -e POSTGRES_DB=Moversly_DB -e PGDATA=/tmp -d -p 5432:5432 -v ${PWD}:/var/lib/postgresql/data postgres:11
