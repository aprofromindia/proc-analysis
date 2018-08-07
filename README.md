# RealTime Process Analysis API

This Process Analysis displays the use of Spring Boot and Java Collections API to deliver a realtime Process Analytics experience.
___

### The API has the following endpoints: -

* `GET /` -> provides a Welcome message.
 
* `GET /activities/top10` -> returns the top 10 frequent cases and their count.

___

The API supports *HATEOAS* for seamless API discoverability.

- To run the project cd into the project directory and type `./gradlew clean bootRun` and then browse to `http://localhost:8080` for more information.


Thought-Process :-

- Since we are tasked to identify cases with the same set of steps, we can accumulate the step names as keys and use it to group the cases in a map (with the value being the count).

- Since we have to display a descending list of cases, we can structure the repository using a BST, which can help us give access to the cases in an ascending/descending order.

- Hence our repository is a mix of a map (for random access while feeding data) and a BST (for later ordered access).

 
