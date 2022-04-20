[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-f059dc9a6f8d3a56e377f745f24479a46679e63a5d9fe6f495e02850cd0d8118.svg)](https://classroom.github.com/online_ide?assignment_repo_id=7516043&assignment_repo_type=AssignmentRepo)
# Week 5 Lab

During weeks 5-7, you will be developing a more in-depth multi-page app.  Week 5 will be focused primarily on developing the HTML and CSS for all of the pages for the app.  

You will notice that one of the major differences is that rather than putting the HTML code into separate files, all of the HTML code will be in a single file.  Therefore, for this lab, it is essential that you ensure you are using the required divs and closing them properly.  If any div elements are not properly closed and/or declared, it could prevent access to some of the pages in your app.

*Code adapted from the Chapter 5 Thyroid App:*
- https://replit.com/@JamesSekcienski/Thyroid-App-Chapter-5


## App Ideas:
- Casual Screen Time Tracker (Not work or school related)
  - Collect user's goal number of hours not to exceed for casual screen time per day as part of their profile
  - Collect user's number of hours of casual screen time as part of the add record page
  - Record page will show date and hours of screen time

- Programming Training Time Tracker
  - Collect user's goal number of hours to spend training on programming per day as part of their profile
  - Collect user's number of hours spent training for programming as part of the add record page
  - Record page will show date and hours spent training 

- Fitness Tracker
  - Collect a goal amount per day as part of their profile.
    - You decide the focus of the fitness you want to track with your app (number of steps/day, exercising time/day, calorie count/day)
    - Weight tracker and BMI tracker are not permitted as app topics
  - Collect user's fitness amount for the day on the add record page
  - Record page will show date and input for the fitness amount for that day

- *If you have a different idea that you would like to implement, send me a message by Thursday with the following information:*
  - **Note: App ideas that are the same as the ones provided as projects in the book will not be approved**
  - Brief description of your app idea
  - Describe what information will be collected and tracked over time
  - Describe what advice/suggestions you will be making based on the collected data
    - Needs to incorporate decision making based on the data
    - *If you would like to request to substitute the advice/suggestions page with a different focus that uses a relevant API and decision making that will be considered too.  Be sure to clearly describe what you would like to use and do instead:*
      - API Resources (if needed)
        - 15 Fun API's for Your Next Project: 
          - https://dev.to/biplov/15-fun-apis-for-your-next-project-5053
        - Public APIs: 
          - https://github.com/public-apis/public-apis


## Code requirements

You will need to have the following files:
- index.html (This will contain all of the HTML for your app)
- style.css (This will have the CSS you are applying throughout your app)
- *Other files that are currently included can be left alone as they will be used in Week 6 or Week 7*

Minimum requirements for index.html:
- Must use the jQuery mobile framework and include the necessary page elements (Use template.html as a reference)
- The sample text and areas that say change me should be updated to be relevant to your app
- Required Pages (each page should be in its own page div with a unique id)
  - Login Page (id="page-login")
    - Include an input for the password/passcode (numeric)
    - Include a control group that has links styled as buttons for the following:
      - One that links to the Disclaimer Page for testing purposes since we don't have the JavaScript for the password checking in this lab
      - One that doesn't link to any page that is used to submit the entered password
      - One that is linked to the About Page
    - Create a numeric keypad with buttons for 0-9 and delete.  Refer to the Thyroid app for a reference on how to set this up.

  - About Page (id="page-about")
    - Include at least one paragraph to let the user know about your app.  Be sure to include any important information a user should know about how to use the app

  - Disclaimer Page (id="page-disclaimer")
    - Include a paragraph with a disclaimer message for your app.  You can just find a generic disclaimer message from online.
    - Include a button to confirm agreement

  - User Information/Profile Page (id="page-user-info")
    - Include a form with information to collect about your user:
      - Must include a first name and last name input
      - Must include a password input for changing the password
      - Must include relevant inputs for goals (if applicable) and/or remaining data that wouldn't change regularly
      - Please contact me if you are unsure of what inputs to include
      - Include a submit input

  - Menu Page (id="page-menu")
    - Include a control group with links to the following pages that are styled as buttons:
      - User Information/Profile Page
      - Records Page
      - Record Form Page
      - Advice/Suggestions Page

  - Records Page (id="page-records")
    - Include a div that will display a summary of user information that was entered in the user information/profile page
    - Include a heading for the table
    - Include a table that will show the records entered by the user.  
      - Nothing needs to be in the table yet
      - If you found a different approach for how to start the dynamic table in the Week 4 Lab and want to take that approach here you may
    - Include a button to add a new record that links to the Record Form Page
    - Include a button that will clear all records

  - Record Form Page (id="page-record-form")
    - Include a form with the necessary inputs based on your app topic
      - Must include a date input
      - Depending on your app topic it may be appropriate to include a time input too if multiple inputs per day are expected and you aren't storing as daily summaries
      - Must include a numeric input or slider for the data that is being tracked
      - Other inputs may be included if necessary and involves data that will be used by your app
        - Don't include inputs for things you can calculate from other values and/or that you won't use in other parts of your app

  - Graph Page (id="page-graph")
    - Include a heading to reflect the information you will be graphing over time
    - Include a canvas that will be used for the graph
    - You can set it up like the Thyroid graph page (Bootstrap components are optional)
    
  - Advice/Suggestions Page (id="page-advice")
    - Include a canvas that will be used for the gauge graph and advice based on the most recent record or trend data
    - You can set it up like the Thyroid advice/suggestions page 
    


Minimum requirements for style.css:
- Include style rule to apply a border to the canvas elements
- If you change any colors, ensure the colors are accessible.  You can use the following tool to check accessibility:  
  - https://webaim.org/resources/contrastchecker/
- Feel free to apply other style changes that are appropriate to app to enhance the look and feel (This is optional)
  - If you are interested in changing the color scheme of your app, it is recommended that you use the ThemeRoller to generate your custom theme
    - Once you have made a custom theme, you will be able to download it and upload it to your code repository.  You should add the themes folder to the css folder along with the files within the themes folder
    - Be sure to add the link to the custom theme in the head element before the link for jQuery Mobile CSS
    - https://learn.jquery.com/jquery-mobile/theme-roller/


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
