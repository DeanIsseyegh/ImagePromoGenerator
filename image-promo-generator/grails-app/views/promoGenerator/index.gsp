<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<title>Image Promo Generator</title>
</head>
<body>


<g:form action="create">
	<g:hiddenField name="isIconAnImage" value="true"/>
	<g:hiddenField id="icon" name="icon"/>
	Hex: <input type="text" name="hexColor" value="#ff8c00"> (e.g. oran hex is #ff8c00)
	<br/><br/>
	Text: <input type="text" name="text" value="BUY THIS">
	<br/><br/>
	Sale Image URL: <input type="text" name="saleImageUrl" value="https://d1x3cbuht6sy0f.cloudfront.net/sales/37539/3285fcc2_e669_4301_8e1f_6da832002386.jpg"> (e.g. https://d1x3cbuht6sy0f.cloudfront.net/sales/37539/3285fcc2_e669_4301_8e1f_6da832002386.jpg)
	<br/><br/>

	Icon: <select id="iconDropdown">
	<g:each in="${new File("web-app/images/icons").listFiles().sort()}" var="iconImg">
		<option value="${g.img(dir: "images/icons", file: iconImg.toString().replace("web-app/images/icons", ""))}">
			${iconImg.toString().replace("web-app/images/icons/", "")}
		</option>
	</g:each>
	</select>

	<script>
		$('#iconDropdown').change(function(e){
			var imageURL = e.currentTarget.value;
			$('#iconImagePreview').html(imageURL);
			$('#icon').val(imageURL)
		});
	</script>
	<br/><br/>
	<label for="iconImagePreview">Icon Preview:</label>
	<div id="iconImagePreview" style="background-color: black;"></div>
	<br/><br/>
	<g:submitButton name="submit" value="Create"/>
</g:form>
<br/><br/>

<br/><br/>
<g:if test="${promoImage}">
	<img src="data:image/png;base64,${promoImage}"/>
</g:if>
</body>
</html>