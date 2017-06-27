$(document).ready(function() {
			$('#project').change(function(event) {
				var projects = $("select#project").val();
				$.get('dropdowndependent', {
					project : projects
				}, function(response) {
					var select = $('#projectGroup');
					select.find('option').remove();
					$.each(response, function(index, value) {
						$('<option>').val(index).text(value).appendTo(select);
					});
				});
			});

			$('#csection').change(function(event) {
				var cables = $("select#csection").val();
				$.get('dropdowndependent', {
					colors : cables
				}, function(response) {
					var select = $('#cable-c');
					select.find('option').remove();
					$.each(response, function(index, value) {
						$('<option>').val(index).text(value).appendTo(select);
					});
				});
			});

			$('input:radio[name="nextoperation"]').change(function() {
				if ($(this).val() == 'splice') {
					$('#rsideterminal').attr('disabled', true);
					$('#rsideseal').attr('disabled', true);
				} else {
					$('#rsideterminal').removeAttr('disabled');
					$('#rsideseal').removeAttr('disabled');
				}
			});

			$('input[type="radio"]').click(
					function() {
						if ($(this).attr('id') == 'splice') {
							$('#strip').show('slow');
						} else if ($(this).attr('id') == 'form'
								|| $(this).attr('id') == 'twisting') {
							$('#strip').hide('slow');
						}
					});
		});