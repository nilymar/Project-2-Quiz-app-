# Project-2-Quiz-app-
I decided to implement it using intents and multiple activities - where each type of question has a specific activity.
I created a random array with 10 questions in toatal - 6 RadioGroup questions, 2 EditView and 2 Multi options questions.
I added the ability to go back and forward in the questions using back and next buttons. your answer only count if you press submit, but using an array of objects that save the changes made by the user in each question (i.e. the answers he chose / wroth, did he submit etc.) you can rotate the screen or move between questions and your changes are saved.
I implemented different layout (xml) files for portrait and landscape and put an explanation layout before starting the quiz. 
I added a system.exit(0) so that when you are exiting the app, either by going back from the first window, or by pressing exit in the last (score) screen, the app will no longer run in the background.
In the score screen - you have an exit button and a start-over button, and you you press the latest you go back to the explanation screen and a new random list of questions is created
