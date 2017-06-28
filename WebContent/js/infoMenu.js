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
												+ "</td> <td>" + value.terminalLeft
												+ "</td> <td>" + value.sealLeft
												+ "</td> <td>" + value.terminalRigth
												+ "</td> <td>" + value.sealRight
												+ "</td> <td>" + value.nextOperation
												+ "</td> <td>" + value.productionLocation
												+ "</td> <td>" + value.destiationLocation
												+ "</td> </tr>");
							});
						});
					});

		});