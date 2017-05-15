<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

<spring:url value="/resources/css/style.css" var="styleCss" />
<link href="${styleCss}" rel="stylesheet" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<body>
	</div>
	<table class = "outer" id = "empsAndReqs" style="height: 200px; max-height: 200px; width: 100%;">
			<tr>
				<td colspan = "3">Attendance History</td>
			</tr>
			<tr>
			<td colspan = "3">
				<table id ="table" class = "inner" style="height: 200px; max-height: 200px; width: 100%; overflow-y: scroll;">
				
				</table>
				
			</td>
		</tr>	
	</table>
</body>

<script>
$(document).ready(function(){
	
	$("#dialog").hide();
	$("#approvedDeclined").hide();
	
	var histID = "${attendHistID}";
	histID = histID.replace('[','');
	histID = histID.replace(']','');
	var attendClockIn = "${attendClockIn}";
	attendClockIn = attendClockIn.replace('[','');
	attendClockIn = attendClockIn.replace(']','');
	var  attendColockout = "${attendColockout}";
	attendColockout = attendColockout.replace('[', '');
	attendColockout = attendColockout.replace(']', '');
	var attendDate = "${attendDate}";
	attendDate = attendDate.replace('[', '');
	attendDate = attendDate.replace(']', '');
	var attendDiff = "${attendDiff}";
	attendDiff =attendDiff.replace('[', '');
	attendDiff = attendDiff.replace(']', '');
	var attendTardy = "${attendTardy}";
	attendTardy = attendTardy.replace('[', '');
	attendTardy = attendTardy.replace(']', '');
	var attendUserID = "${attendUserID}";
	attendUserID =attendUserID.replace('[', '');
	attendUserID = attendUserID.replace(']', '');
	
	var parser = "";
	
	var id = histID.split(",");
	var clockIn = attendClockIn.split(",");
	var clockOut = attendClockIn.split(",");
	var dif = attendDiff.split(",");
	var late = attendTardy.split(",");
	var uID = attendUserID.split(",");
	
	var index = 0;
	
	$("#table").html("<tr>" + "<th>" + "History ID" + "<th>" + "Clock In" + "</th>" + "<th>" + "Clock Out" + "</th>" + "<th>" + "Difference" + "</th>"+ "<th>" + "Late" + "</th>" + "<th>" + "Employee" + "</th>" + "</tr>");
	for (var i = 0; i < uID.length; i++){
		
		var parser = "<td class="+"format"+">"+id[i]+"</td>"
		+"<td class="+"format"+">"+clockIn[i]+"</td>"
		+"<td class="+"format"+">"+clockOut[i]+"</td>"
		+"<td class="+"format"+">"+dif[i]+"</td>"
		+"<td class="+"format"+">"+late[i]+"</td>"
		+"<td class="+"format"+">"+uID[i]+"</td>";
		
		$("#table").html($("#table").html() + "<tr id ="+"reqRow" +index+" class="+"format"+">"+parser+"</tr>");
		
		index++;
	}
	$("td").css("text-align", "center");
});
</script>
</html>