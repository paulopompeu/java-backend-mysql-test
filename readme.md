
## About The Project
simple Java Spring Boot test project with MySQL

- [x] MySQL (docker compose)
- [x] Create
- [x] Read
- [ ] Update
- [ ] Delete
- Tests
  - [x] Basic
  - [x] Mocked
  - [ ] Integrated

## Getting Started
- Run docker compose detached with `docker compose up -d`
- Run the application

Create Client
```
curl --request POST \
  --url http://localhost:8080/client/save \
  --header 'Content-Type: application/json' \
  --header 'User-Agent: insomnia/9.2.0' \
  --data '{
	"firstName": "John",
	"lastName": "Doe",
	"participation": 200
}

```

Fetch Clients
```
curl --request GET \
  --url http://localhost:8080/client/listAll \
  --header 'Content-Type: application/json' \
  --header 'User-Agent: insomnia/9.2.0'
```
