@SocialNet
Feature:
#
#  I want to be able to use the service - JSONPlaceholder - Free Fake REST API
#  so that I can  make posts
#  Scenario Outline: Get a specific Post
#    Given service is up and running
#    When I send GET request to get a specific post with "<id>"
#    Then "<id>", "<title>" and "<body>" request are returned with status code of 200
#    Examples:
#      | id | title              | body                                                                                                                                                   |
#      | 5  | nesciunt quas odio | repudiandae veniam quaerat sunt sed\nalias aut fugiat sit autem sed est\nvoluptatem omnis possimus esse voluptatibus quis\nest aut tenetur dolor neque |
#      | 6  | dolorem eum magni eos aperiam quia | ut aspernatur corporis harum nihil quis provident sequi\nmollitia nobis aliquid molestiae\nperspiciatis et ea nemo ab reprehenderit accusantium quas\nvoluptate dolores velit et doloremque molestiae |
#
#
#  Scenario Outline: Get a specific comment
#    Given JsonPlaceHolder service is up and running
#    When Get request is sent to get specific comment with "<id>"
#    Then specific comment details "<id>", "<name>", "<email>" is returned with status code of 200
#    Examples:
#      | id | name                                       | email                    |
#      | 3  | odio adipisci rerum aut animi              | Nikita@garfield.biz      |
#      | 4  | alias odio sit                             | Lew@alysha.tv            |
#      | 20 | molestias expedita iste aliquid voluptates | Mariana_Orn@preston.org  |
#      | 17 | eos est animi quis                         | Preston_Hudson@blaise.tv |
#
#
#  Scenario Outline: Get Specific User
#    Given JsonPlaceHolder service is up and running
#    When Get request is sent to get specific User with "<id>"
#    Then specific user details "<id>", "<name>", "<username>", "<email>", "<street>" ,"<city>" ,"<zipcode>","<lat>" ,"<phone>" is returned with status code of 200
#    Examples:
#      | id | name            | username     | email                   | street      | city           | zipcode    | lat      | phone                 |
#      | 9  | Glenna Reichert | Delphine     | Chaim_McDermott@dana.io | Dayna Park  | Bartholomebury | 76495-3109 | 24.6463  | (775)976-6794 x41206  |
#      | 7  | Kurtis Weissnat | Elwyn.Skiles | Telly.Hoeger@billy.biz  | Rex Trail   | Howemouth      | 58804-1099 | 24.8918  | 210.067.6132          |
#      | 1  | Leanne Graham   | Bret         | Sincere@april.biz       | Kulas Light | Gwenborough    | 92998-3874 | -37.3159 | 1-770-736-8031 x56442 |

#
#  Scenario Outline: Create a new specific social networking Post
#    Given service is up and running
#    When I create a new  post with the folowing details "<userid>", "<title>" and "<body>"
#    Then I should get response of "<userid>", "<title>" and "<body>" returned status code of 201
#    Examples:
#      | userid | title   | body           |
#      | 1      | my love | she is my wife |


  Scenario Outline: Create a new social networking User
    Given service is up and running
    When I create a new  post with the following details "<postId>", "<name>", "<username>", "<email>", "<street>", "<suite>", "<city>" and  "<zipcode>"
    Then I should get response of "<name>", "<username>",  "<email>", "<street>", "<suite>", "<city>", "<zipcode>", "<lat>" and "<lng>" returned status code of 201
    Examples:
      |postId | name       | username | email                  | street     | suite     | city           | zipcode    | lat  | lng     |
      | 9| Sheyi Solo | Odeleye  | odexsollo777@gmail.com | Dayna Park | Suite 449 | Bartholomebury | 76495-3109 | 24.6463 | -168.8889 |


