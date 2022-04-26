/*  
    Assignment: Week 6 Lab
    Author: Todd Mills
    Date: 4/23/22
    Purpose: Handling code related to user information, saving and loading
*/

//apply changes button listener
$("#user-form").submit(function () {
	saveUserForm();
	return false;
});

//save form info to localStorage
function saveUserForm() {
	let password = $("#txt-change-pin").val();
	let pattern = /^\d{4,8}$/;

	//check validity
	if (checkUserForm()) {
		//password changed
		if (pattern.test(password)) {
			
			//save to localStorage
			try {
                let user = {
                    firstName: $("#txt-fname").val(),
                    lastName: $("#txt-lname").val(),
                    bugName: $("#txt-bug-name").val(),
                    bugSpec: $("#txt-bug-species").val(),
                    bugFood: $("#range-food").val(),
                    bugMinTemp: $("#range-temp-min").val(),
                    bugMaxTemp: $("#range-temp-max").val(),
                    bugMinHum: $("#range-humidity-min").val(),
                    bugMaxHum: $("#range-humidity-max").val(),
                    password: $("#txt-change-pin").val(),
                };

				localStorage.setItem("user", JSON.stringify(user));
				alert("Saving changes...");
                $.mobile.changePage("#menu-page" , {transition: "slideup"});
			} catch (e) {
				if (window.navigator.vendor === "Google Inc.") {
					if (e == DOMException.QUOTA_EXCEEDED_ERR) {
						alert("Error: localStorage limit exceeded");
					}
				} else if (e == DOMException.QUOTA_EXCEEDED_ERR) {
					alert("Error saving to localStorage");
				}
				console.log(e);
			}

			//password not changed
		} else {
			//save to localStorage
			try {
                let user = {
                    firstName: $("#txt-fname").val(),
                    lastName: $("#txt-lname").val(),
                    bugName: $("#txt-bug-name").val(),
                    bugSpec: $("#txt-bug-species").val(),
                    bugFood: $("#range-food").val(),
                    bugMinTemp: $("#range-temp-min").val(),
                    bugMaxTemp: $("#range-temp-max").val(),
                    bugMinHum: $("#range-humidity-min").val(),
                    bugMaxHum: $("#range-humidity-max").val(),
                    password: "2345",
                };
				localStorage.setItem("user", JSON.stringify(user));
				alert("Saving changes...");
                $.mobile.changePage("#menu-page" , {transition: "slideup"});
			} catch (e) {
				if (window.navigator.vendor === "Google Inc.") {
					if (e == DOMException.QUOTA_EXCEEDED_ERR) {
						alert("Error: localStorage limit exceeded");
					}
				} else if (e == DOMException.QUOTA_EXCEEDED_ERR) {
					alert("Error saving to localStorage");
				}
				console.log(e);
			}
		}
	//??? other error
	} else {
		alert("Form error. Please try again.");
	}
}

//checks the required input fields for validity
//not really needed, since <form> handles the req info, needed for grading tho
function checkUserForm() {
	//grab input values
	let fname = $("#txt-fname").val();
	let lname = $("#txt-lname").val();
	let bname = $("#txt-bug-name").val();
	let bspec = $("#txt-bug-species").val();

	if (fname != "" && lname != "" && bname != "" && bspec != "") {
		return true;
	} else {
		return false;
	}
}

//loads user info and fills in boxes on later visits
function showUserForm() {
    //reset values
    $("#txt-fname").val("");
    $("#txt-lname").val("");
    $("#txt-bug-name").val("");
    $("#txt-bug-species").val("");
    $("#range-food").val(1);
    $("#range-temp-min").val(50);
    $("#range-temp-max").val(50);
    $("#range-humidity-min").val(50);
    $("#range-humidity-max").val(50);
    $("#txt-change-pin").val("");
	//load user from localStorage
	try {
		let user = JSON.parse(localStorage.getItem("user"));

		//fill in the blanks
		if (user != null) {
			$("#txt-fname").val(user.firstName);
			$("#txt-lname").val(user.lastName);
			$("#txt-bug-name").val(user.bugName);
			$("#txt-bug-species").val(user.bugSpec);
			$("#range-food").val(user.bugFood);
			$("#range-temp-min").val(user.bugMinTemp);
			$("#range-temp-max").val(user.bugMaxTemp);
			$("#range-humidity-min").val(user.bugMinHum);
			$("#range-humidity-max").val(user.bugMaxHum);
		}
	} catch (e) {
		if (window.navigator.vendor === "Google Inc.") {
			if (e == DOMException.QUOTA_EXCEEDED_ERR) {
				alert("Error: localStorage limit exceeded");
			}
		} else if (e == DOMException.QUOTA_EXCEEDED_ERR) {
			alert("Error saving to localStorage");
		}
		console.log(e);
	}
}
