

## Basketball Players DB - JPA SPRING MVC CRUD Project

### Overview
<!-- We are going to have you create a CRUD application, completely from scratch, to get a handle on what you've been doing this week. We aren't going to have to create a persisted backend for it (that will come later), the goal here is to get comfortable with building a web application with SpringMVC. We can use the DAO pattern we have seen over the past two weeks to mimic the functionality of a database. -->
This project is a CRUD application built from scratch.

On the homepage, the user can choose between finding a player by id, finding all players, and adding a player.
In all of the pages, a navigation bar is displayed which has the options of returning to the homepage, looking up the list of all players in the database and adding a new player entry.

#### Finding a player by ID
This form is formatted only to take numbers. Until the user enters a whole number, the user will remain on the homepage.

If the user enters a non-existent ID, they will be forwarded to a page which displays an error message.

If the user enters an id that is existent, they will be forwarded to a page with information about the player, including the player's name, team, age, position, and nationality. In addition to the nav-bar options, the user can choose between editing a player and deleting a player they searched for.


#### Finding all Players

The user can view all players currently in the database either through a button on the homepage or by pressing on the "Player List" option in the navigation bar.

The user is forwarded to a page with a list of every player's first and last name in the database. Each player's name is a hyperlink which a user can press to get to the same page as if they searched for the player by id. Also, under each player's name the user can press a button to edit or to delete a player.

#### Adding a new players

The user can add a new player by choosing "Add a player" option on the front page, or by pressing on the "Create a player" button in the nav-bar. Once this option is chosen, the user is forwarded to a page which enables the user to input all information about the player, except for the id which is auto-generated. Since position and team can have a null value in the database, the user can leave these fields empty, however, the other fields (first and last name, age, and nationality) are required as they have no default value.

Once a player has been successfully added, the user is shown the same info about the player as if he had searched for the player by id. If adding fails, an error message is displayed.

#### Editing a players

The user can choose to edit any player that he or she searched for by id, that is in the list of all players in the database, or that the user just created. To do so, the user has to press the "edit player button." Initially, all fields are auto-populated with the current values from the database, but the user has the option of editing any of the fields. The only field which is not displayed and which the user cannot edit is the "id," which is the primary key in the database.

Once the user is satisfied with the changes, they can press the edit player button which will display the new information.

#### Removing a player
On the same pages that give user the option to update the player, the user can also choose to remove a player which will delete the entry from the database. A confirmation or an error is displayed once delete button is pressed.


### Building Blocks
The database holds a number of NBA players in a "Player" table. The table has the following fields:
 * id: primary key, non-null, auto-incremented
 * first-name:  non-null
 * last-name: non-null
 * position
 * age: non-null
 * team
 * nationality: non-null

"Player" class, which is annotated as an entity, keeps corresponding getters and setters, hashCode and equals, as well as a toString method.
The repository "BasketballDAOImpl" has methods which can remove a Player from a database, create, and update a Player. These methods are called from the Controller class, "BasketballMVCController", whose methods set the view and the model in response to user's actions.
The front-end is made out of simple JSP files.




### Technologies used
* Java
* Spring MVC
* Gradle
* Tomcat server v8.5
* JPA
* MySQL
* JPQL
* JUnit tests
* AWS


### Lessons learned
* Got comfortable with building a web application with SpringMVC.
* Improved understanding of how DB, mid-layer, and front-end work together.
* Improved SQL and JPQL language proficiency

### Stretch Goals
* Add more JUnit tests
* Add teams table
