# check files

````bash
tree -a -L 3
````

# build and run backend and front end

````bash
#term backend
./start_java_backend.sh

#tern frontend
./start_java_frontend.sh

# curl tern

# tilføj ny bruger

curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{"name": "Mads", "email": "mads@example.com"}'
````
