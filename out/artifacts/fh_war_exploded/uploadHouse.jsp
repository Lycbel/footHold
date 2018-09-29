<%--
  Created by IntelliJ IDEA.
  User: lycbel
  Date: 11/5/2017
  Time: 5:56 AM
  To change this template use File | Settings | File Templates.
--%>
<html class="supernova">


<head>

    <link rel="shortcut icon" href="https://cdn.jotfor.ms/favicon.ico">

    <title>JotForm</title>
    <link href="/css/form_cs1.css" rel="stylesheet" type="text/css" />
    <link type="text/css" rel="stylesheet" href="/css/form_cs2.css" />
    <link type="text/css"  rel="stylesheet" href="/css/form_cs3.css" />
    <link type="text/css" rel="stylesheet" href="/css/form_cs4.css"/>



    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>



<body>
<h1>upload house</h1>
<form   action="/picture/UploadServlet" enctype="multipart/form-data" class="jotform-form"  method="post" name="form_73095449184162" id="73095449184162" accept-charset="utf-8">

    <%@include file="/houseForm.jsp" %>

    <div id="upload_form">
        choose a summary picture:<input type="file" name="uploadFile" />
        <br>
        <label>Choose detailed pictures</label>
    </div>

    </br>
    <input type = "button" onclick="addMore()" value="click to add a new file"/>
    <br/><br/>
        <li class="form-line" data-type="control_button" id="id_2">
            <div id="cid_2" class="form-input-wide">
                <div style="margin-left:156px;" class="form-buttons-wrapper">
                    <button id="input_2" type="submit" class="form-submit-button form-submit-button-wood_3d" data-component="button">
                        Submit Form
                    </button>
                </div>
            </div>
        </li>

        </ul>
        </div>
</form>
<script>
    function addMore() {
        var divm = document.createElement('div');
        divm.innerHTML = '</br>';
        var textnode = document.createTextNode('choose a file:');
        var newInput = document.createElement("input");
        newInput.type = 'file';
        newInput.name = "upload";
        divm.appendChild(textnode);
        divm.appendChild(newInput);
        document.getElementById("upload_form").appendChild(divm);
    }
</script>
</body>
</html>