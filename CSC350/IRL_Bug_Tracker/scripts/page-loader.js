/*  
    Assignment: Week 6 Lab
    Author: Todd Mills
    Date: 4/23/22
    Purpose: Holds functions related to page/site loading
*/

//checks user information related to active div page on loading
$(document).on("pageshow", function () {
    if ($("ui-page-active").attr("id") == "user-page") {
        showUserForm();
    } else if ($("ui-page-active").attr("id") == ("records-page")) {
        loadUserInformation();
        listRecords();
    } 
});

//care sheet "back to top" button
$("#btn-care-scroll").on("click", function() {
    document.body.scrollTop = 0;
    document.documentElement.scrollTop = 0;
})

//used for testing
$(document).ready(function() {
   //localStorage.clear();
});