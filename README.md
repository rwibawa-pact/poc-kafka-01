# poc-kafka-01
This PoC demonstrates a simple producer and a multi-method consumer; the producer sends objects of types `Foo1` and `Bar1` and the consumer receives objects of type `Foo2` and `Bar2` (the objects have the same field, `foo`).

The producer uses a `JsonSerializer`; the consumer uses the `StringDeserializer` that is automatically configured by Spring Boot, together with a `StringJsonMessageConverter` which converts to the required type of the listener method argument.
We can't infer the type in this case (because the type is used to choose the method to call).
We therefore configure type mapping on the producer and consumer side.
See the `application.yml` for the producer side and the `converter` bean on the consumer side.

The `MultiMethods` `@KafkaListener` has 3 methods; one for each of the known objects and a fallback default method for others.

Run the application and use curl to send some data:

``` sh
$ curl -X POST http://localhost:8080/send/clinical/pleasanton
$ curl -X POST http://localhost:8080/send/lab/1-011
$ curl -X POST http://localhost:8080/send/unknown/xxx
```

Console output:

``` sh
Received: Clinical2 [source=pleasanton]
Received: Lab2 [id=1-011]
Received unknown: xxx
```

Find the [API documentation](docs/pact-pharma.postman_collection.json) in postman collection.