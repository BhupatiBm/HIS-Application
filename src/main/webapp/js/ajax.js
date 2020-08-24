
$(document).ready(function(e) {
	
$("#role").change(function() {
	var role = $("#role").val();
	$.ajax({
		type : "GET",
		url : "viewEmployeebyRole?role=" +role,
		success : function(response) {
			if(response != 'null'){
				
				var len = response.length;
		 for(var i=0; i<len; i++){
		 var employeeId = response[i].employeeId;
		 
		var firstName = response[i].firstName;
		var lastName = response[i].lastName;
		var emailId = response[i].emailId;
		var gender = response[i].gender;
		var role = response[i].role;
		var isDeleted = response[i].isDeleted;
		var accountStatus = response[i].accountStatus;

		var tr_str = "<tr>" +
		    "<td align='center'>" + (i+1) + "</td>" +
		    "<td align='center'>" + employeeId + "</td>" +
		    "<td align='center'>" + firstName + "</td>" +
		    "<td align='center'>" + lastName + "</td>" +
		    "<td align='center'>" + emailId + "</td>" +
		    "<td align='center'>" + gender + "</td>" +
		    "<td align='center'>" +  role + "</td>" +
		    "<td align='center'>" + isDeleted + "</td>" +
		    "<td align='center'>" + accountStatus + "</td>" +
		    "<td><a href='./editEmployeeAccount?eid=+"+employeeId+"'>Edit</a>||"
						+"<c:if test='isDeleted eq 'N'.charAt(0)}'> <a href='./softDeleteAccount?eid="+employeeId+"'>Delete</a></c:if>"
						+" <c:if test='isDeleted eq 'Y'.charAt(0)}'><a href='./activeDeletedAccount?eid="+employeeId+"'>Active</a></c:if></td>"+
		    "</tr>";
		      $("#userTable tbody").append(tr_str);
			
			}
			}
		}
	});
});
});
