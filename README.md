# ALMA Design Study Prototype Microservices
The ALMA Observing Tool (OT) is an application for the used for the preparation and submission of ALMA Phase 1 (observing proposal) and Phase 2 (telescope runfiles for accepted proposals) materials. The present ALMA-OT is a desktop Java application, running (almost) wholly on the users own machine.The exceptions are when submitting/retrieving proposals and when querying external databases and archives (such as name resolvers and image servers).

This prototype backend uses a microservice architecture to supply clients with required data and perform heavy 
processing tasks. This architecture has 
been used to apply modularity, improving stability, scalability, and ease of development. The services are made using
 Spring Boot, managed with Eureka discovery and Zuul gateway, and messaging is using Spring's implementation of 
 RabbitMQ.
## Architecture
![Architecture Diagram](./architecture-structure.png)
## Routes
Route                              | Destination
:----------------------------------|:-----------------------------------------------
http://localhost:8761              | Eureka dashboard
http://localhost:15672             | RabbitMQ dashboard (username: guest, password: guest)
http://localhost:8080/routes       | List of available routes and their destinations
http://localhost:8080/spectral     | Accesses the spectral service API
http://localhost:8080/project      | Accesses the project service API
http://localhost:8080/generation   | Access the generation service API

## API
### Project Service
Route         | Method | Body          | Params                 | Result
:-------------|:-------|:--------------|:-----------------------|:----------------------------------------------------
/ping         | GET    |               |                        | Basic text result from service
/list         | GET    |               |                        | `List<ProjectListItem>` of all available projects
/new          | POST   |               |                        | A new `ObsProject`
/project      | GET    |               | **String** entityRef   | `ObsProject` matching the supplied entity reference in JSON
/project      | PUT    | `ObsProject`  |                        | `ObsProject` matching the supplied entity reference in JSON
/proposal     | GET    |               | **String** entityRef   | `ObsProposal` matching the supplied entity reference in JSON
/proposal     | PUT    | `ObsProposal` |                        | `ObsProposal` matching the supplied entity reference in JSON
/science-goal | PUT    |               | **String** entityRef   | `ObsProposal` matching the supplied reference with a new science goal added in JSON

### Spectral Service
 Route             | Method | Params                                     | Result
:------------------|:-------|:-------------------------------------------|:---------------------------------------------
/ping              | GET    | None                                       | Basic text result from service
/splatalogue       | GET    | None                                       |`List<SpectralLine>` of the stored splatalogue
/spectrum/{octile} | GET    | **int** The desired octile of the spectrum | `int[][][]` of Spectral data

### Generation Service
Route | Method | Params | Result
:-----|:-------|:-------|:------------------------------
/ping | GET    | None   | Basic text result from service

## Usage
### Prerequisites
To run the microservices the following are required:

- [Docker](https://www.docker.com/)
- [Docker-Compose](https://docs.docker.com/compose/)

### Process
**1.** Clone the repository

**2.** CD into the repository
```
cd observation-tool-microservices
```
**3.** Depending on which compose file you want to run, the filepath on line 51 must be changed to suit your environment
```docker
volumes:
  - 'your/path/here:/data/projects'
```
**4a.** To run just the back end run the below command. The services can be tested with an application like Postman 
or a web 
browser
```docker
docker-compose up -d --build
```
**4b.** Alternatively to include the web client (http://localhost:4200)
```docker
docker-compose -f docker-compose.prod.yml up -d --build
```
The services should be accessible after a short while

**5.** To stop the services if they're in the background
```docker
docker-compose down --rmi all
```

