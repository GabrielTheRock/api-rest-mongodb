# API Rest
API Rest made using Spring Boot with MongoDB.

This API stores data about users, their posts and the comments of their posts.

# Endpoints

/users --> return all users

/posts --> return all posts

/posts/titlesearch?text=XXXX --> request a query method that return all posts that contains the text XXXX on title

/posts/fullsearch?text=XXXX --> request a query method that return all posts that contains the text XXXX on title, body or comments

/posts/fullsearch?text=XXXX?minDate=yyyy-MM-dd --> return all posts whose date are greater than yyyy--MM--dd

/posts/fullsearch?text=XXXX?minDate=yyyy-MM-dd?maxDate=yyyy-MM-dd --> return all posts whose date are greater than minDate and less than maxDate 
