# Project 3: Quiz app
I decided to implement it using intents and multiple activities - where each type of question has a specific activity.
I created a random array with 10 questions in toatal - 6 RadioGroup questions, 2 EditView and 2 Multi options questions.
I added the ability to go back and forward in the questions using back and next buttons. your answer only count if you press submit, but using an array of objects that save the changes made by the user in each question (i.e. the answers he chose / wroth, did he submit etc.) you can rotate the screen or move between questions and your changes are saved.
I implemented different layout (xml) files for portrait and landscape and put an explanation layout before starting the quiz. 
I added a system.exit(0) so that when you are exiting the app, either by going back from the first window, or by pressing exit in the last (score) screen, the app will no longer run in the background.
In the score screen - you have an exit button and a start-over button, and you you press the latest you go back to the explanation screen and a new random list of questions is created

![screenshot_20180731-135923](https://user-images.githubusercontent.com/33417968/43476499-6a6273d0-9501-11e8-80a9-e8c4264b96f7.png)  
![screenshot_20180731-135928](https://user-images.githubusercontent.com/33417968/43476504-6c49cf36-9501-11e8-9306-6798a1cfc0bf.png)

![screenshot_20180731-135938](https://user-images.githubusercontent.com/33417968/43476508-6e8a142c-9501-11e8-9cb0-3ffe3294de65.png)  
![screenshot_20180731-135943](https://user-images.githubusercontent.com/33417968/43476511-7080769a-9501-11e8-8e19-7e7d85fa012a.png)

![screenshot_20180731-135953](https://user-images.githubusercontent.com/33417968/43476517-724c373e-9501-11e8-9f07-7ec7fd1a4566.png)  
![screenshot_20180731-140004](https://user-images.githubusercontent.com/33417968/43476523-74be3e7c-9501-11e8-87c3-8e8f672108e9.png)

![screenshot_20180731-140042](https://user-images.githubusercontent.com/33417968/43476526-76bc44d0-9501-11e8-9c06-2691cfc05319.png)

