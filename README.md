## Pluq Exercise

#### Here I will describe what was done and what was left behind.

The project uses H2 as it's database, using JPA with Hibernate. This decision was made because it's only an exercise, an in-memory database sounded easier to set up.
The choice for JPA with Hibernate was because that was the way I used to work before, so I'm a little more used to it. And I do like to work with ORMs.

I decided to create a model layer, a controller layer, a service layer and a repository layer. This guarantees a more loosely coupled system in general. But at the same time, I tried to keep it simple.


#### Some points:
* The api for the energy prices and the locations are working, they have 4 operations: list, get by id, save a single location and save all locations in the json file.
* In the controllers, I could have used a ResponseEntity, but I opted out for now, for simplicity. 
On a real application I would probably use it.
* I struggled in the parsing of the meterValues.json, therefore this part of the api is not working properly.
* Test coverage could have been better, but I was losing time trying to figure out good ways to test all the layers.
* What I did to save all information from the json file into the DB is a bit hacky, I did that way to be fast and not lose much time. (It's commented in the service files)
* I would start to model a Report model, to get the answer from the report call in the Locations API, but I didn't have time to finish it.