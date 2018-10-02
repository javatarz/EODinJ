# eOdin(j)

[![Build status](https://travis-ci.org/javatarz/EODinJ.svg?branch=master)](https://travis-ci.org/javatarz/EODinJ)

eOdin(j) (read: **ee-oh-din**) makes is easy to share daily updates with remote or distributed team members. It is optimized for multi-site teams that have two co-located groups at separate locations, such as a team split between USA and India.

Each team member uses the EOD Machine web app on their own time to input information that they wish to share with the rest of the team. At pre-configured delivery times for each location, the EOD Machine will collate all entries and make them available on the webpage.

Other options include [Status Hero](https://statushero.com/) or [Standuply](https://standuply.com/), but they are costly and proprietary. The EOD Machine will always be open source and free. :joy:

Want emails? Use [Ryan Oglesby](https://github.com/ryanoglesby08)'s [EOD machine](https://github.com/ryanoglesby08/the-eod-machine).

Want something simpler that's web based? Use [eOdin(j)](https://github.com/javatarz/eodinj).

Does this description look familiar? It's meant to :smile:

## Background
We've used [Ryan Oglesby](https://github.com/ryanoglesby08)'s [EOD machine](https://github.com/ryanoglesby08/the-eod-machine) for years now. It's a piece of beauty except for the fact that the stack is hard to consume in most enterprises. He's added a docker image as well to make it easier to use. But what happens when it's hard to get SMTP settings in the client space you're in?

Welcome to the offline EOD machine.

## Running this application

`java -jar eodinj.jar`

### Pre-Requisites

* JRE 10 (for running)
* JDK 10 (for development)

## Using this application

Open [http://localhost:8080](http://localhost:8080) to access the UI.

Open [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) to access Swagger documentation for this project.

