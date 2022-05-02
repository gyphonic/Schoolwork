/*  
    Assignment: Week 7 Lab
    Author: Todd Mills
    Date: 5/1/22
    Purpose: Handles code related to login functions
*/

//login numpad listener
$(".numpad").on("click", function () {
	addValueToPassword(this.textContent);
});

/*
    checks for existing password and user data. Navigates to the disclaimer page by default. If already agreed to, navigates to the user info page to fill out user information. If both user info exists and disclaimer agreed to, navigates to the menu page.
*/
$("#btn-enter").on("click", function () {
	let password = getPassword();
	if (document.getElementById("passcode").value == password) {
		//clear password field
		$("#passcode").val("");
		//hasnt agreed to legal
		if (localStorage.getItem("agreedToLegal") == null) {
			$("#btn-enter").attr("href", "#disclaimer-page");
		} else if (localStorage.getItem("agreedToLegal") == "true") {
			$("#noticeYes").hide();
			//hasnt set user info
			if (localStorage.getItem("user") == null) {
				$("#btn-enter").attr("href", "#user-page");
				//correct login
			} else {
				$("#btn-enter").attr("href", "#menu-page");
			}
		}
		//incorrect login
	} else {
		$("#passcode").val("");
		$("#btn-enter").removeAttr("href");
		alert("Incorrect PIN. New User? Enter '2345'  " + password);
	}
});

//records the user agreeing to the disclaimer
$("#noticeYes").on("click", function() {
	try {
		localStorage.setItem("agreedToLegal", "true");
		$("#noticeYes").hide();
	} catch (e) {
		alert("Error saving to localStorage.");
		console.log(e);
	}
});

//adds the entered button press to the password value box
function addValueToPassword(num) {
	let currVal = $("#passcode").val();

	if (num == "Del") {
		//remove the last character from password
		$("#passcode").val(currVal.substring(0, currVal.length - 1));
	} else if (currVal.length < 8) {
		//add password value
		$("#passcode").val(currVal.concat(num));
	}
}

//check localstorage for password value
function getPassword() {
	try {
		if (typeof Storage == "undefined") {
			alert(
				"Your browser does not support HTML5 localstorage. Please switch to a browser that does."
			);
		} else if (localStorage.getItem("user") != null) {
			//extremely finnicky, doesn't want to be one line
			//pull user's password
			let user = JSON.parse(localStorage.getItem("user"));
			return user.password;
		} else {
			//default password
			return "2345";
		}
	} catch (e) {
		console.log(e);
	}
}
