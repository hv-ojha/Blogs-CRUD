# Cubereum Assignment

Create RESTful API for Basic CRUD operation on Users and Blogs of user.

### Technologies used

- Maven
- MongoDB
- Spring Boot
- Lombok
- JWT

## APIs created

### User
| URL | Method | Output | Remarks | Fields |
|-----| ------ | ------ | ------- | ------ |
| http://localhost:8080/user/register | POST | User Object | Registered User | `name` , `email` , `password` |
| http://localhost:8080/user/login | POST | User Object with API Token | LogIn user and Send authentication token to request APIs | `email` , `password` |
| http://localhost:8080/user/{email} | GET | Requested User Object of given Email | Sends details of requested user of given Email | `email` |
| http://localhost:8080/user/update | PUT | Updated User Object | Update the loggedin user and check whether the details updated are of same user or not (__Requires Authentication with Bearer Token__) | `name`, `email` , `password` |
| http://localhost:8080/user/ | GET | List of all registered User | Returns all the registered user |  |

### Blogs
| URL | Method | Output | Remarks | Fields |
|-----| ------ | ------ | ------- | ------ |
| http://localhost:8080/blog/add | POST | Blog Object | Adds Blog (__Requires Authentication with Bearer Token__) | `title` , `blogDetails` |
| http://localhost:8080/blog/delete/{id} | DELETE | Returns Boolean if blog is deleted or not | Delete the blog and check whether it is from same user or not (__Requires Authentication with Bearer Token__) | `id` |
| http://localhost:8080/blog/{id} | GET | Requested Blog Object of given ID | Sends details of requested blog of given Id | `id` |
| http://localhost:8080/blog/update | PUT | Updated Blog Object | Update the blog and check whether the details updated are of same user or not (__Requires Authentication with Bearer Token__) | `title` , `blogDetails` |
| http://localhost:8080/blog/ | GET | List of all Blogs | Returns all the blogs with particular user |  |