/*  
    Assignment: Week 7 Lab
    Author: Todd Mills
    Date: 5/1/22
    Purpose: Build and display the records-based graphs on graph-page
*/

function showGraph() {
	//check if records exist and boot the user to the menu if they dont
	if (localStorage.getItem("bRecords") == null) {
		alert("You don't exist, according to these records.");
		$.mobile.changePage("#menu-page");
	} else {
		//grab the elements
		let foodGraph = document.getElementById("canvas-food");
		let tempGraph = document.getElementById("canvas-temp");
		let humidityGraph = document.getElementById("canvas-humidity");

		//setup the canvas
		setupCanvas(foodGraph, tempGraph, humidityGraph);

		//array objects for records
		let dateArr = new Array();
		let foodArr = new Array();
		let tempArr = new Array();
		let humArr = new Array();

		//get the history and draw on the graph
		getHistory(dateArr, foodArr, tempArr, humArr);

		labelAxes();
	}
}

//fills in a solid rect for the graphs on the graph page
function setupCanvas(foodGraph, tempGraph, humidityGraph) {
	//food graph
	let foodGraphCtx = foodGraph.getContext("2d");
	foodGraphCtx.fillStyle = "#FFFFFF";
	foodGraphCtx.fillRect(0, 0, 500, 500);

	//temp graph
	let tempGraphCtx = tempGraph.getContext("2d");
	tempGraphCtx.fillStyle = "#FFFFFF";
	tempGraphCtx.fillRect(0, 0, 500, 500);

	//humidity graph
	let humidityGraphCtx = humidityGraph.getContext("2d");
	humidityGraphCtx.fillStyle = "#FFFFFF";
	humidityGraphCtx.fillRect(0, 0, 500, 500);
}

//grabs the user history
function getHistory(dateArr, foodArr, tempArr, humArr) {
	let bRecords = JSON.parse(localStorage.getItem("bRecords"));

	bRecords.sort(compareDates);

	//populate array objects with info from bRecords
	for (let i = 0; i < bRecords.length - 1; i++) {
		let date = new Date(bRecords[i].Date);

		//dates are 0-based, increment
		let m = date.getMonth() + 1;
		let d = date.getDate() + 1;

		//x axis label
		dateArr[i] = m + "/" + d;

		//the point to plot
		if (bRecords[i].Food == "Yes") {
			foodArr[i] = 1;
		} else {
			foodArr[i] = 0;
		}
		tempArr[i] = parseFloat(bRecords[i].Temp);
		humArr[i] = parseFloat(bRecords[i].Humidity);
	}

	drawLines(dateArr, foodArr, tempArr, humArr);
}

//takes arrays and draws lines on the graphs
function drawLines(dateArr, foodArr, tempArr, humArr) {
	//food chart
	foodLine = new RGraph.Line({
		id: "canvas-food",
		data: foodArr,
		options: {
			backgroundGridVLines: false,
			backgroundGridBorder: false,
			colors: ["red", "blue", "green"],
			lineWidth: 1,
			spline: false,
			tickmarksStyle: "dot",
			tickmarksSize: 4,
			xaxisLabels: dateArr,
			xaxis: true,
			yaxis: true,
			yaxisLabelsSpecific: ["Fed", "Not\nFed\n\n\n"],
			shadow: true,
		},
	}).trace();
	//temp chart
	tempLine = new RGraph.Line({
		id: "canvas-temp",
		data: tempArr,
		options: {
			backgroundGridVLines: false,
			backgroundGridBorder: false,
			colors: ["red"],
			lineWidth: 1,
			spline: false,
			tickmarksStyle: "dot",
			tickmarksSize: 4,
			xaxisLabels: dateArr,
			xaxis: true,
			yaxis: true,
			yaxisScaleMax: 100,
			yaxisScaleMin: 0,
			shadow: true,
		},
	}).trace();
	//humidity chart
	humLine = new RGraph.Line({
		id: "canvas-humidity",
		data: humArr,
		options: {
			backgroundGridVLines: false,
			backgroundGridBorder: false,
			colors: ["blue"],
			lineWidth: 1,
			spline: false,
			tickmarksStyle: "dot",
			tickmarksSize: 4,
			xaxisLabels: dateArr,
			xaxis: true,
			yaxis: true,
			yaxisScaleMax: 100,
			yaxisScaleMin: 0,
			shadow: true,
		},
	}).trace();
}

//adds labels to the axis
//could just use the axis title function of the RGraph line graph object but
//needed for grading
function labelAxes() {
	//food y axis
	new RGraph.Drawing.Text({
		id: "canvas-food",
		x: 17,
		y: 12,
		text: "Food",
		options: {
			valign: "top",
			halign: "center",
			marker: false,
			size: 12,
			textBold: true,
			bounding: false,
			colors: ["Grey"],
		},
	});

	//food x axis
	new RGraph.Drawing.Text({
		id: "canvas-food",
		x: 5,
		y: 143,
		text: "Date (MM/DD)",
		options: {
			marker: false,
			size: 12,
			textBold: true,
			bounding: false,
			colors: ["Grey"],
		},
	});

	//temp y axis
	new RGraph.Drawing.Text({
		id: "canvas-temp",
		x: 25,
		y: 12,
		text: "Temp (F)",
		options: {
			valign: "top",
			halign: "center",
			marker: false,
			size: 12,
			textBold: true,
			bounding: false,
			colors: ["Grey"],
		},
	});

	//temp x axis
	new RGraph.Drawing.Text({
		id: "canvas-temp",
		x: 5,
		y: 143,
		text: "Date (MM/DD)",
		options: {
			marker: false,
			size: 12,
			textBold: true,
			bounding: false,
			colors: ["Grey"],
		},
	});

	//humidity y axis
	new RGraph.Drawing.Text({
		id: "canvas-humidity",
		x: 40,
		y: 12,
		text: "Humidity (%)",
		options: {
			valign: "top",
			halign: "center",
			marker: false,
			size: 12,
			textBold: true,
			bounding: false,
			colors: ["Grey"],
		},
	});

	//humidity x axis
	new RGraph.Drawing.Text({
		id: "canvas-humidity",
		x: 5,
		y: 143,
		text: "Date (MM/DD)",
		options: {
			marker: false,
			size: 12,
			textBold: true,
			bounding: false,
			colors: ["Grey"],
		},
	});
}
