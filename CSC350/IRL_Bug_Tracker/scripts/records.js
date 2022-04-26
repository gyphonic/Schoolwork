/*  
    Assignment: Week 6 Lab
    Author: Todd Mills
    Date: 4/23/22
    Purpose: To contain functions related to storing and displaying records
*/

//loads user info and fills in boxes on later visits
function loadUserInformation() {
    //load user from localStorage
    try {
        let user = JSON.parse(localStorage.getItem("user"));

        if(user != null) {
          //load user info to top of record page
          $("#div-user-section").append("User's Name: " + user.firstName + " " + user.lastName + "<br>Bug's Name: " + user.bugName + "<br>Species: " + user.bugSpec + "<br>Preferred Temp: " + user.bugMinTemp + " - " + user.bugMaxTemp + "<br>Preferred Humidity: " + user.bugMinHum + " - " +user.bugMaxHum); 
          //add button to edit user profile
          $("#div-user-section").append("<br><a href='#user-page' id='btn-record-user' data-role='button' data-icon='edit' data-inline='true'>Edit Profile</a>");
          //refresh button
          $("#btn-record-user").button();
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
//check value of submit button on page load to determine operation
//not a fan of this method to determine form editing, but whatevs
$("#form-page").on("pageshow", function() {
  let formOperation = $("#btn-record-submit").val();
  //if adding a new record, clear the page
  if (formOperation == "Add") {
    clearRecordForm();
  //if editing a record, load the index of the record
  } else if (formOperation == "Edit") {
    showRecordForm($("#btn-record-submit").attr("indexToEdit"));
  }
});

//clear record form
function clearRecordForm() {
  $("#date-new-record").val("");
  $("#check-food").val("");
  $("#range-record-temp").val(50);
  $("#range-record-humidity").val(50);
  return true;
}

//add record button changes the text on the form submit button
$("btn-add-record").click(function() {
  $("#btn-record-submit").val("Add").button();
  if ($("#btn-record-submit").hasClass("btn-ui-hidden")) {
    $("#btn-record-submit").button("refresh");
  }
});

//form operations upon submit
$("#form-new-record").submit(function () {
  let formOperation = $("#btn-record-submit").val();

  //if adding a new record, call addRecord()
  if (formOperation == "Add") {
    addRecord();
    $.mobile.changePage("#record-page");
  //if editing, call editRecord()
  } else if (formOperation == "Edit") {
    editRecord($("#btn-record-submit").attr("indexToEdit"));
    $.mobile.changePage("#record-page");
    editRecord($("#btn-record-submit").removeAttr("indexToEdit"));
  }
  return false;
});

//add a new record
function addRecord() {
  if(checkRecordForm()) {
    let record = {
      "Date" : $("#date-new-record").val(),
      "Food" : $("#check-food").val(),
      "Temp" : $("#range-record-temp").val(),
      "Humidity" : $("#range-record-humidity").val()
    };
    try {
      let bRecords = JSON.parse(localStorage.getItem("bRecords"));
      if (bRecords == null) {
        bRecords = [];
      }
      bRecords.push(record);
      localStorage.setItem("bRecords", JSON.stringify("bRecords"));
      alert("Saving record...");
      clearRecordForm();
      listRecords();

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
  } else {
    alert("Form completed incorrectly or something.")
  }
  return true;
}

//check the record form format
function checkRecordForm() {
  //something goes here
}

//show all the available records in a very nice, neat table
function listRecords() {
  try {
    let bRecords = JSON.parse(localStorage.getItem("bRecords"));

    if (bRecords != null) {
      //order by date
      bRecords.sort(compareDates);

      //initalize table
      $("#tbl-records").html (
        "<thead>" +
        "   <tr>" +
        "     <th>Date</th>" +
        "     <th>Food?</th>" +
        "     <th>Temp</th>" +
        "     <th>Humidity</th>" + 
        "     <th>Edit  /  Delete" +
        "   </tr>" +
        "</thead>" +
        "<tbody>" +
        "</tbody>"
      );

      //loop to insert all the records in the table
      for (let i = 0; i < bRecords.length; i++) {
        let record = bRecords[i];
        $("#tbl-records tbody").append(
          "</tr>" +
          "<td>" + record.Date + "</td>" +
          "<td>" + record.Food + "</td>" +
          "<td>" + record.Temp + "</td>" +
          "<td>" + record.Humidity + "</td>" +
          "<td><a data-inline='true' data-mini='false' data-role='button' href='#form-page' onclick='callEdit("+i+")' data-icon='edit' data-iconpos='notext'></a>" +
          "<td><a data-inline='true' data-mini='false' data-role='button' href='#' onclick='callDelete("+i+")' data-icon='delete' data-iconpos='notext'></a></td>" +
          "</tr>"
        );
      }

      //refresh the buttons, the delete/edit buttons need it to appear ig
      $("#tbl-records [data-role='button']").button();
    } else {
      $("#tbl-records").html = ("");
    }
    return true;
  }  catch (e) {
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

//function to compare dates to aid in sorting
function compareDates(a, b) {
  let x = new Date(a.Date);
  let y = new Date(b.Date);

  if (x > y) {
    return 1;
  } else {
    return -1;
  }
}

//changes value of the submit button to "edit"
function callEdit(index) {
  $("#btn.record.submit").attr("indexToEdit", "index");

  //refresh the button
  $("#btn-record-submit").val("Edit");
  if ($("#btn-record-submit").hasClass("btn-ui-hidden")) {
    $("#btn-record-submit").button("refresh");
  }
}

//edit an existing record
function editRecord(index) {
  if(checkRecordForm()) {
    try {
      let bRecords = JSON.parse(localStorage.getItem("bRecords"));
      bRecords(index) = {
        "Date" : $("#date-new-record").val(),
        "Food" : $("#check-food").val(),
        "Temp" : $("#range-record-temp").val(),
        "Humidity" : $("#range-record-humidity").val()
      };
      
      localStorage.setItem("bRecords", JSON.stringify("bRecords"));
      alert("Saving record...");
      clearRecordForm();
      listRecords();

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
  } else {
    alert("Form completed incorrectly or something.")
  }
  return true;
}

//loads records from index to edit
function showRecordForm(index) {
  try {
    let bRecords = JSON.parse(localStorage.getItem("bRecords"));
    let record = bRecords[index];
    $("#date-new-record").val(record.Date);
    $("#check-food").val(record.Food);
    $("#range-record-temp").val(record.Temp);
    $("#range-record-humidity").val(record.Humidity);
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

//delete an individual record
function deleteRecord(index) {
  try {
    let bRecords = JSON.parse(localStorage.getItem("bRecords"));

    //chop that bad boi out
    bRecords.splice(index, 1);
    //no records, remove the whole thing from localstorage
    if (bRecords.length == 0) {
      localStorage.removeItem("bRecords");
    //else just set the new array in place
    } else {
      localStorage.setItem("bRecords", JSON.stringify("bRecords"));
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

//calls the function to delete a record
function callDelete(index) {
  deleteRecord(index);
  listRecords();
}

//WARINGIN!!! deltes all records from localstorage
$("#btn-clear-record").click(function() {
  localStorage.removeItem("bRecords");
  listRecords();
  alert("All records have been deleted.")
})
