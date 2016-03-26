<html>
<head>
  <title>${title}</title>
</head>
<body>
  <div style="width:300px;margin-left:auto;margin-right:auto;"><h1>${title}</h1></div>
  <ul>
    <#list songs as song>
      <li style="line-height:30px;font-size:18px; font-family:cursive"> ${song}</li>
    </#list>
  </ul>

</body>
</html> 
