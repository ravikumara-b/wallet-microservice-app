# wallet-microservice-app
Spring boot, microservices with kafka

Each services are different Spring boot application.

User-service has /user, using this E-wallet account for the user created.
Transaction-Service contains /transact, for performing the trasaction(sending amount to other users of the application).

All these different services uses Kafka to communicate the events between each other.
User_create
Txn_create
Txn_complete
Wallet_update
these the topics created in kafka to make communication among services.
