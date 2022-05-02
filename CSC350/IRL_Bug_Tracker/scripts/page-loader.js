/*  
    Assignment: Week 7 Lab
    Author: Todd Mills
    Date: 5/1/22
    Purpose: Holds functions related to page/site loading
*/

//checks user information related to active div page on loading
$(document).on("pageshow", function () {
    //user page == load user info
    if ($(".ui-page-active").attr("id") == "user-page") {
        showUserForm();
    //records page = load user records and list them
    } else if ($(".ui-page-active").attr("id") == ("records-page")) {
        loadUserInformation();
        listRecords();
    //suggestions page = load records and resize advice graph
    } else if ($(".ui-page-active").attr("id") == ("suggestions-page")) {
        showAdvice();
        //resizeGraph();
    //graph page = load user records and draw record graphs
    } else if ($(".ui-page-active").attr("id") == ("graph-page")) {
        showGraph();
       //resizeGraph();
    }
});

//care sheet "back to top" button
$("#btn-care-scroll").on("click", function() {
    document.body.scrollTop = 0;
    document.documentElement.scrollTop = 0;
})

//disclaimer page "back to top" button 
$("#btn-disclaimer-scroll").on("click", function() {
    document.body.scrollTop = 0;
    document.documentElement.scrollTop = 0;
})
//function to resize the graphs to fit nicely based on window size
//not used due to size limitation on ui-content in this app
/*
function resizeGraph() {
    if ($(window).width() < 700) {
        $("#canvas-advice").css({"width":$(window).width() - 50});
        $("#canvas-food").css({"width":$(window).width() - 50});
        $("#canvas-temp").css({"width":$(window).width() - 50});
        $("#canvas-humidity").css({"width":$(window).width() - 50});
    }
}
*/