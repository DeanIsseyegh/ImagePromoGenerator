<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<title>


	</title>
</head>

<body>
<g:form action="create">
	<g:hiddenField name="isIconAnImage" value="false"/>
	Icon: <input type="text" name="icon" value="test">
	<br/><br/>
	Hex: <input type="text" name="hexColor" value="#ff8c00"> (e.g. oran hex is #ff8c00)
	<br/><br/>
	Text: <input type="text" name="text" value="BUY THIS">
	<br/><br/>
	Sale Image URL: <input type="text" name="saleImageUrl" value="https://d1x3cbuht6sy0f.cloudfront.net/sales/37539/3285fcc2_e669_4301_8e1f_6da832002386.jpg"> (e.g. https://d1x3cbuht6sy0f.cloudfront.net/sales/37539/3285fcc2_e669_4301_8e1f_6da832002386.jpg)
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