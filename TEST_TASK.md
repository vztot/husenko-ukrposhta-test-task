# TEST TASK

## Task

Make a simple REST service with Spring.

Essence of the service: buying products using service API.

We have three main entities: client (`user`), `product` and `discounts`. Let's create tables for 
these entities and use in-memory db (like H2).
 
Number of fields in entities, relations between tables, and their count - it's all up to you. 
And I emphasize that I only describe the basis itself, which should be implemented. Complete
freedom of action in the implementation and in the addition of new details. For example, you can
divide a list of all products into categories, etc...

## Endpoints
The following endpoints should be implemented:
* transfer and response requests (I suggest the Json format. You can implement another)
* `/create_user`
* `/add_money` - add money to the account (in this request you should indicate id and name of a
 user)
* `/list` - product list (add a category if implemented)
* `/pay` - buy products (there must be a parameter indicating the id of the product that we want to
 buy and id of the one who is buying to check if he has enough money; withdraw money in case of
  successful completion of the purchase operation). Also, you need to calculate the sum of all the
   products, taking into account discounts on them.
* in the table of discounts there will be discounts on individual products.

## Advanced
* If you have experience in Front-end, you can make an additional interface (again, I repeat, a
 tool 
of your choice. It’s like an additional task, a request-response in Json will suit
 you up.)

* Additionally, make such a mechanism - when buying goods, if there are more than 3 unique
 discounted
 products, then use only the 3 discounts that are most beneficial to the buyer.
In calculating user benefit, take into account the number of identical goods.

* If you have an understanding of what JPA is, implement project with it.

You can build project with Maven / Gradle, choose by yourself.

Good luck!