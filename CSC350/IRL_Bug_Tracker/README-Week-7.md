# Week 7 Lab

During Week 5 and Week 6, you created the HTML for your multi-page app and programmed the functionality for the login, dislcaimer, user information, records, and record form pages.  For Week 7, you are going to finish programming the remaining required functionality for the graph and advice pages.

This week you will be learning about making graphs.  The graph page will be a line graph showing the trend of your data over time.  The advice page will be a gauge graph that shows a rating for the data on the most recent day and provides advice based on if it is good (green), ok (yellow), or bad (red).  The textbook and examples provided are using the RGraph library to create the graphs.

Remember to test your code as you go.  I highly encourage you to refer to my code adaptation below, if you are unsure how to do something as the code needed for your app will be similar to the code used in the Thyroid App.  I kept the structure close to what the book is using, but I did make some updates to follow our coding standards more closely.

*Code adapted from the Chapter 7 Thyroid App:*
- https://replit.com/@JamesSekcienski/Thyroid-App-Chapter-7


## Graph Requirements for Provided App Ideass:
- Casual Screen Time Tracker (Not work or school related)
  - Graph page
    - Line graph
    - x-axis: Date
    - y-axis: Hours of screen time
  - Advice page
    - Gauge graph
    - Value used is total screen time for the most recent day
    - Green range will be less than or equal to the goal
    - Yellow range will be up to 25% (or other percentage you think is appropriate) above the goal
    - Red range will be more than the upper limit of the yellow range

- Programming Training Time Tracker
  - Graph page
    - Line graph
    - x-axis: Date
    - y-axis: Hours of programming training
  - Advice page
    - Gauge graph
    - Value used is total programming training time for the most recent day
    - Green range will be equal to the goal or more
    - Yellow range will be up to 25% (or other percentage you think is appropriate) below the goal
    - Red range will be any time less than that

- Fitness Tracker
  - Graph page
    - Line graph
    - x-axis: Date
    - y-axis: Fitness Value Being Tracked (example: steps)
  - Advice page
    - Gauge graph
    - Value used is the fitness value entered by the user for most recent day
    - Green range will be up to or equal to the goal
    - Yellow range will be up to 25% (or other percentage you think is appropriate) below the goal
    - Red range will be any time less than that


## Code requirements for Week 7 Lab

You will need to have the following files:
- index.html (This will contain all of the HTML for your app and should already be complete from the Week 5 lab)
- style.css (This will have the CSS you are applying throughout your app and should already be complete from the Week 5 Lab)
- _JavaScript files in the scripts folder:_
  - login.js (Should be there from Week 6)
  - user-form.js (Should be there from Week 6)
  - records.js (Should be there from Week 6)
  - page-loader.js (Should be there from Week 6)
  - graph.js
  - advice.js
  - **Be sure to add script elements to the index.html file at the end of the body before the closing body tag for each of the new JavaScript files**
- Other files that are currently included can be left alone
  - **Be sure to add script elements to the index.html file at the end of the body for each of the RGraph files**

Minimum requirements for **page-loader.js**:
- page show event handler function:
  - Update this function to do the following:
    - Add an else if statement for the graph page that will call showGraph and resizeGraph
    - Add an else if statement for the advice page that will call showAdvice and resizeGraph

- resizeGraph function:
  - This will change the width of the canvas elements to fit in the window width on smaller screens/mobile devices


Minimum requirements for **graph.js**:
- showGraph function:
  - If there are no records in localStorage, it will alert the user and redirect back to the menu page
  - Otherwise, it will do the following:
    - Call setupCanvas
    - Call getHistory to fill the arrays that will be used for graphing
    - Call drawLines
    - Call labelAxes

- setupCanvas function:
  - Fills in a rectangle on the context of the canvas of the Graph page to serve as the background

- getHistory function:
  - Get the dates from the records in localStorage and fill them into an array.  Be sure to format them in the way you want them to show
  - Get the other data from the records in localStorage that you need for the y-axis.  Fill an array with the values that will be used for graphing
  - The function will either need parameters for the arrays that are being filled or it needs to return a multi-dimensional array with both arrays

- drawLines function:
  - This will take in the arrays that are needed for graphing
    - Array for the dates
    - Array for the values on the y-axis
  - It will use the arrays to create a line graph using RGraph and add it to the canvas on the Graph page
  - Optional: Include lines to show the lower/upper limit of the green range of values

- labelAxes function:
  - This will add labels to the axes on the canvas of the Graph page

Minimum requirements for **advice.js**:
- showAdvice function:
  - If there are no records in localStorage, it will alert the user and redirect back to the menu page
  - Otherwise, it will do the following:
    - It will retrieve the data for the most recent day
    - It will add a rectangle for the initial background (set to an appropriate color of your choice)
    - It will then call drawAdviceCanvas

- drawAdviceCanvas function:
  - This function will take in the context of the canvas for the Advice page and values necessary for determining advice
  - It will add text to the canvas stating the value you are basing your recommendations on (For the Thyroid app it was the most recent TSH value)
  - It will then add text for the target range the user should be aiming for (This only requires an if-else statement like the Thyroid app if the target range is dependent on an additional value.  The recommended ideas above don't require an extra if-else statement).
  - It should then call writeAdvice and drawMeter

- writeAdvice function:
  - This function will take in the context and value(s) for determining advice
  - This will determine the appropriate advice statement to write to the context of the canvas.
    - There should be a minimum of 3 possibilities
    - One is for the good target range (green), one for an ok/warning range (yellow), and one for a bad/emergency range (red)
  - It will finally write that advice to the context

- drawMeter function:
  - This function will take in the context and values necessary for determining advice
  - You will use an if-else statement to create a corner gauge graph with the appropriate color ranges
    - If the value is less than an expected maximum that you want to use for your gauge, you will make the gauge with ranges using your desired maximum.
    - If the value is greater than the expected maximum that you wanted for the gauge, then you will make the gauge ranges using the given value.
  - After the if-else statement it will set the additional values for the guage to get it to display appropriately


## Important Reminders

*Be sure to validate your code as well and fix any errors*
- HTML Validator: https://validator.w3.org/#validate_by_input 
- CSS Validator: https://jigsaw.w3.org/css-validator/#validate_by_input
- JS Hint: https://jshint.com/ 
  - This will help check for potential problems with your code.  
  - This is not a substitute for testing your code to ensure it is working as expected.

*Use Prettier to format your code*
- If you use the Prettier extension in Visual Studio Code, you can use it to format your code
- You can also access Prettier online, but make sure you select the proper language when formatting:  https://prettier.io/playground/

Follow the Style Guidelines
- View HTML/CSS style guidelines here: https://google.github.io/styleguide/htmlcssguide.html
  - Prettier will fix many of the general formatting style guidelines
  - Use the elements (and attributes if applicable) that make the most sense for the content
    - Example: If you want to make a numbered list, use ol and li elements rather than p elements with numbers
  - id and class naming conventions
    - Names need to be lower-case.
      - When your id/class name is multiple words, use kebab-case where you put a hyphen between each word
        - As a reminder, if you use a space within a class name, it will be treated as multiple classes.
    - Names should be meaningful, but brief
      - Avoid making id/class names that are presentational (like button-green) as it makes it harder to maintain when changes to the style are desired
      - Names should be descriptive of what they represent, but avoid being too long
        - Example 1: Rather than navigation, you could use nav since it is still clear what it represents.
        - Example 2: Rather than atr, you should use author to make it more clear since it is difficult to know that atr was an abbreviation for author.
  - Use shorthand properties when possible


- View JavaScript style guidelines here: https://google.github.io/styleguide/jsguide.html
  - File names should be lowercase and use kebab-case or snake_case
  - Prettier will help fix most of the general formatting style guidelines
  - Variable declarations:
    - Use const or let.  
      - Google Style Guidelines say to use const unless it needs to be re-assigned
      - Never use var 
    - Wait to declare a variable until it is needed
    - Assign a value to a variable as soon as possible once it is declared (commonly within the same line as the declaration)
  - Naming conventions:
    - Function names should be lowerCamelCase and begin with a verb
    - Global constant names (defined outside of a function with const) should use CONSTANT_CASE and be a noun or noun phrase
    - Local variable names (defined within a function with const or let) should use lowerCamelCase and should be a noun or noun phrase
    - Names should be clear and descriptive of what they represent
  - *I am not requiring you to follow the guidelines for JSDoc, but you are welcome to if you would like to get experience with it.*


- Leave a blank line in between long sections of code to improve readability
  - For HTML, a good general guideline is to leave a blank line before headings and between elements used for grouping (divs, sections, etc)
  - For CSS, you should have a blank line between CSS rules to separate them
  - For JavaScript, you should have a blank line between functions.   
    - For longer functions, use blank lines to separate sub-tasks within the function.  
    - *Consider making a new helper function for the sub-tasks, especially if your function is long*
  

Documentation
- For HTML, ensure you have updated the purpose to describe what the web page is about (not the assignment)
  - For long HTML files, you might include comments to label sections of code, but you don't need detailed descriptions


- For CSS, commonly you will only see comments added to label groups of style rules when there are a lot.
  - You don't need a comment for each rule
  - You won't lose points if you don't add comments for your style rules


- For JavaScript, ensure you have a comment before each function that provides a brief description of what it does.  
  - If it returns something, be sure to mention what it returns.
  - You should also describe the parameters if they aren't completely clear based on the name
  - If there are any important things to know about using the function such as limitations or assumptions about the parameters, it is good to note