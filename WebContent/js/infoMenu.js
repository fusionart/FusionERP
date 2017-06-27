$(document).ready(
		function() {

			$('#getCables').submit(
					function(e) {
						e.preventDefault();
						var projects = $("select#project").val();
						$('#cableTable > tr').remove();
						$.get('populateinfomenu', {
							project : projects
						}, function(response) {
							$.each(response, function(index, value) {
								$('#cableTable').append(
										"<tr> <td>" + value.number
												+ "</td><td>"
												+ value.projectLongName
												+ "</td> <td>" + value.group
												+ "</td> <td>" + value.section
												+ "</td> <td>" + value.color
												+ "</td> <td>" + value.length
												+ "</td> </tr>");
							});
						});
					});

		});