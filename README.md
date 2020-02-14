# kobby-ims-project

One Paragraph of project description goes here

Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

Prerequisites
Eclipse: https://www3.ntu.edu.sg/home/ehchua/programming/howto/EclipseJava_HowTo.html
MySQL: https://dev.mysql.com/doc/mysql-installation-excerpt/8.0/en/windows-install-archive.html
Google Cloud Platform: https://cloud.google.com/sql/docs/mysql/quickstart
GitBash: https://git-scm.com/book/en/v2/Getting-Started-Installing-Git
Java: https://www3.ntu.edu.sg/home/ehchua/programming/howto/EclipseJava_HowTo.html
Maven: https://howtodoinjava.com/maven/how-to-install-maven-on-windows/

Installing
Set up a google cloud instance
Pull the repository from GitHub using the following commands using GitBash: git init git pull https://github.com/nick-overd/project1.2
Open repository into your IDE (Eclipse recommended)
Change all databases connections ip within the code to there own databases ip. This are located within there classes ims and all daoMysql
Run the application by pressing ctrl and f11 simultaneously. This will then prompt you to input your username and password to your own MySql database. The list of table names will then be presented and once a table is selected a series of commands will be displayed which allow for the table to be modified. The create function allows for a new item to be saved into the database. The read function shows all the items present in the database. For example read will pull all the information from the database table and input it into the console. The update function allows a item already in the database to be changed and the delete function removes a item from the database
Running the tests
Right click the test class in Java and run it in Junit. This will return wether the code works or not by showing pass or not pass.
Say what the step will be



## Built With


* [Maven](https://maven.apache.org/) - Dependency Management



## Versioning


We use [SemVer](http://semver.org/) for versioning.



## Authors


* **Kobby Mensah** - *Initial work* - [KobbyM](https://https://github.com/KobbyM)



## License


This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 



*For help in [Choosing a license](https://choosealicense.com/)

*

## Acknowledgments


* Nathan Rees

