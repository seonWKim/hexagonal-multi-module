# Structure 
![https://medium.com/ssense-tech/hexagonal-architecture-there-are-always-two-sides-to-every-story-bc0780ed7d9c](architecture.png)
- example-api: module to define REST APIs, you can think of this as a module for REST API adapters 
- example-batch: module to define batch jobs   
- example-core: module to define the core business logic and ports (and some commonly used adapters such as repositories)  
  - application: define ports e.g. facade interfaces
  - domain: define classes for business logic logic e.g. entities, repositories, value objects, services
    - note that service classes can bypass application package and be referenced directly from other modules
  - infrastructure:
    - config: where the configuration of the application is defined  
    - persistence: where the implementation of the ports for persistence are defined e.g. JPA repositories, etc. 

# Keep In Mind 
- example-core should not depend on example-api or example-batch 
- core business logic should be located in example-core
  - example-api and example-batch should use business logic defined in the example-core 
