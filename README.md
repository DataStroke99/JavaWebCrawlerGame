# JavaWebCrawlerGame
A simple Java based Web Crawler Game which accepts 2 inputs from the user and checks the number of Links that separate both the topics(from their wikipedia pages). It would parse the links from the initial topic's wikipedia page till it reaches the link for the target topic's wikipedia URL.
This project has a simple GUI made in JavaFX and a Breadth First Tree parsing algorithm which crawls through each one of the links from the first input till it reaches the target topic(topic 2).



# Setting up the GUI
The GUI is simple and uses JavaFX. 3 HBox(Horizontal Box) , 1 VBox(Vertical Box) and 1 BorderPane Layout are combined and used together. The first Input Field takes in the initial starting wikipedia page topic. While the second text field accepts the target topic from the user. The Button invokes the BFS algorithm which crawls the web pages through a simple lambda expression and stores the result in a label to be displayed. Code for this can be seen in GUI.java


# Creating a Wikipedia URL
Once the user inputs both the initial and the target topic, it's important to convert them into a workable Wikipedia URL. 
So a normal Wikipedia URL has the base address  =  "https://en.wikipedia.org/wiki/"
And the topic being searched (for example Star Wars) =  "Star_Wars"
The total URL being = "https://en.wikipedia.org/wiki/Star_Wars" 

As can be observed that the  multi word topics all have the first letter capital and white space is converted to _. So regardless of the users input it was important to convert the text into a passable topic address. 




# The BFS(Breadth first algorithm)

To get the contents of a page, the library JSoup is used as it makes it easy to parse the HTML of each page. The algorithm can be seen in Crawl2.java .






