# Week 6 Lab

During Week 5, you created the HTML and CSS for your multi-page app.  Now it is time to begin coding in the functionality of your app.  For Week 6, we are going to focus on the login process, storing and loading the user information, and storing, loading, and editing the records information.  

During this week, you will also be introduced to utilizing localStorage as a way to store small amounts of data of a user that you can use within your app. Keep in mind the following about localStorage:
- Data loss is possible.  A user may accidentally clear data from their localStorage for the app.  Since it isn't stored in a server or backed-up, then it is unlikely it can be recovered once removed.  

You will be developing a lot of functions this week and next, so it is important that you are testing your code as you go.  I highly encourage you to refer to my code adaptation below, if you are unsure how to do something as the code needed for your app will be similar to the code used in the Thyroid App.  I kept the structure close to what the book is using, but I did make some updates to follow our coding standards more closely and to ensure it works with the Live Preview.

*Code adapted from the Chapter 6 Thyroid App:*
- https://replit.com/@JamesSekcienski/Thyroid-App-Chapter-6


## Reminders About Provided App Idea Requirements:
- Casual Screen Time Tracker (Not work or school related)
  - Collect user's goal number of hours not to exceed for casual screen time per day as part of their profile
  - Collect user's number of hours of casual screen time as part of the add record page
  - Record page will show date and hours of screen time

- Programming Training Time Tracker
  - Collect user's goal number of hours to spend training for programming as part of their profile
  - Collect user's number of hours spent training for programming as part of the add record page
  - Record page will show date and hours spent training

- Fitness Tracker
  - Collect user's goal amount per day as part of their profile
  - Collect user's fitness amount for the day on the add record page
  - Record page will show date and fitness amount for that day



## Code requirements for Week 6 Lab

You will need to have the following files:
- index.html (This will contain all of the HTML for your app and should already be complete from the Week 5 lab)
  - **Remove the extra link or button that was added to the login page to get direct access to the disclaimer page**
- style.css (This will have the CSS you are applying throughout your app and should already be complete from the Week 5 Lab)
- _JavaScript files to be added to the scripts folder:_
  - login.js
  - user-form.js
  - records.js
  - page-loader.js
  - **After adding these files, be sure to add script elements to the index.html file at the end of the body before the closing body tag for each of these files**
- Other files that are currently included can be left alone

Minimum requirements for **login.js**:
- addValueToPassword(button) function. 
  - The textbook example shows this as the function that is called onclick for each of the keypad buttons.
    - If the onclick does not appear to be loading for you, be sure to follow the recommendation that I included in my adaptation of the Thyroid app that adds the event listeners after the page loads with an initializeKeypadButtons function
  - It needs to get the value from the passcode element.
  - If the backspace key is pressed, it should remove the last character from the current value of the passcode and set that as the new value.
  - Otherwise, it should add the value of button to the current value of the passcode and set that as the new value

- getPassword function
  - This function will need to check that local storage is available.
    - If it isn't then it needs to provide an alert to the user
    - If it is, then it needs to see if a "user" exists yet in localStorage.  If the user exists, then you need to return the saved password of the user.  Otherwise, we will return a default password of "2345"

- Program the onclick function for the Enter button (Be sure to remove the href on the enter button if you added it for testing purposes) 
  - You can follow the textbook format or set an onclick on the button in HTML and call the function you define
  - The function needs to get the value of the passcode element
  - It will then need to call getPassword and see if the values are equal
    - If they are, then it can check the local storage
      - You need to see if the user agreed yet or not to the disclaimer and handle it appropriately
      - If the user did agree, then you need to check if a user's details are saved.  
        - If there is a user, then the enter button should link to the menu page.  
        - If there isn't a user then it should link to the user information page
    - If the values aren't equal it should provide an alert of an incorrect password and to try again

- Program the onclick function for the disclaimer page to handle setting "agreedToLegal" to true in the local storage

Minimum requirements for **user-form.js**:
- checkUserForm function that ensures valid values have been entered/selected for all required inputs.  
  - It should return true if they are all valid.  It should return false if any of them aren't valid.
    - Required text inputs shouldn't be blank.  You can be more precise if needed
    - Date of birth (if included) should occur before today (Or before a further time in the past if they must be a minimum age)
    - Ensure numeric inputs fall within a logical range.  If they shouldn't be negative then make sure it is 0 or greater
    - For any select menus, ensure a value has been selected

- saveUserForm function should first call checkUserForm to make sure it it valid.
  - If it is valid then it it should create a well formatted JSON object with all of the entered values.  
    - It will then try to write the information to local storage and save it to "user".  
    - If it successfully writes then it should load to the menu page.  Otherwise, it should alert the user it failed to save
  - If it isn't valid, then it needs to alert the user to complete the form properly.  
    - Be sure to provide clear alerts so they know what they need to fix.

- showUserForm function should try to get the user from local storage
  - If the user exists, then it should take the saved data and set each of the inputs to the saved data

- You need to define an onclick function for the submit button
  - Call the saveUserForm function


Minimum requirements for **records.js**:
- Define an onclick function for the clear button so that it does the following:
  - Removes the tbRecords from the localStorage
  - Calls the listRecords function
  - Alerts the user that all records have been deleted

- Define an onclick function for the add record button on the Records page, to do the following:
  - Set the value of the button to "Add" on the Record Form page
  - Refresh the button so the proper value shows

- Define a submit function for the Record Form page that does the following:
  - Gets the value of the submit button on the Record Form page
  - If the value is "Add", then it will do the following:
    - Call addRecord
    - Change the page to the Records page
  - If the value is "Edit", then it will do the following:
    - Call editRecord with the value of the indexToEdit attribute
    - Change the page to Records page
    - Remove the indexToEdit attribute
  - Finally it should return false so the form doesn't reload

- Define an on page show function for the Record Form page
  - Get the value of the submit button on the Record Form page
    - If it is "Add", then it will do the following:
      - Call clearRecordForm
    - If it is "Edit", then it will do the following:
      - Call showRecordForm with the value of the indexToEdit attribute

- loadUserInformation function
  - This will try to get the "user" from localStorage
  - If the user exists, then it will do the following:
    - Load a summary of the user information based into the user information div
    - Add a button to the user information div that links to the user information page.  This is to allow the user quick access to go and update their information if needed

- clearRecordForm function
  - This should clear the value of all the inputs on the Record Form page and return true

- compareDates(date1, date2) function 
  - This function will help us with sorting
  - This will first convert each variable to a Date to ensure it is formatted as a Date and not a string
  - If date1 is greater than date2 then it returns 1, otherwise it returns -1

- listRecords function
  - It will try to get the "tbRecords" from localStorage and JSON parse the data
    - Give an alert if it fails to load the data
  - If there are records, then it will do the following:
    - Sort the "tbRecords" using the compareDates function we defined
    - Initialize the HTML for the tblRecords element with the column headings (if not already done so)
    - Loop through all the records and add them to the table
      - Each record will be its own row
      - Each row will also have an edit button that has an onclick to callEdit with its index and a delete button with an onclick to callDelete with its index
  - If there aren't records, then it will do the following:
    - Initialize tbRecords to an empty array []
    - Set the HTML for the tblRecords element to ""

- showRecordForm(index) function
  - This function will try to get the tbRecords from local storage and JSON parse them.  
  - It will then try to retrieve the record at that index and set each value in the Record Form page's form to those values
  - It will give an alert if it fails

- checkRecordForm function
  - This will ensure all entered data in the Record Form page's form is valid.  
  - If it is then it returns true.  
  - If not then it returns false. 

- callEdit(index) function
  - This sets the attribute indexToEdit of the submit record button on the Record Form page to the given index
  - It then sets the value of the button to "Edit" and refreshes the button

- callDelete(index) function
  - This calls the deleteRecord function with the given index
  - It then calls listRecords to update the table

- addRecord function
  - If checkRecordForm is true, then it will create a JSON object based on the form information.  
    - Be sure to generate any data you need to store that isn't directly collected from the user.  Example, BMI percentage.
    - Then try to get the current tbRecords and JSON parse it
    - If it is currently null then it will make it equal to an empty array []
    - It will add the the JSON object you made to the array
    - Then it will sort the array
    - Next, it will save tbRecords back to local storage
    - It will alert the user so they know the information saved
    - Next it will call clearRecordForm and listRecords
  - Otherwise, it alerts the user to know the form isn't completed properly (Build in specific alerts so they know what they need to fix)

- deleteRecord(index) function
  - It will try to get tbRecords from local storage and JSON parse it
  - splice tbRecords at the index
  - If the length of tbRecords is now 0, tbRecords can be removed from local storage
  - Otherwise, the updated tbRecords is saved to local storage

- editRecord(index) function
  - This will be similar to addRecord with some slight differences. 
  - If checkRecordForm is true
    - First it will try to get tbRecords and JSON parse it
    - Then it will set the record at the given index to the current values of the form
    - It will then sort tbRecords
    - Next it will save tbRecords to local storage
    - It will alert the user so they know the information saved
    - Next it will call clearRecordForm and listRecords
  - Otherwise, it alerts the user to know the form isn't completed properly (Build in specific alerts so they know what they need to fix)


Minimum requirements for **page-loader.js**:
- You will need to handle the document on pageshow events to call a function where:
  - If the user information page is the active page that it calls the showUserForm function
  - If the records page is the active page that it calls the loadUserInformation and listRecords function
  - _Handling the graph and advice pages will be taken care of in Week 7, so you don't need to include these in the function yet._


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