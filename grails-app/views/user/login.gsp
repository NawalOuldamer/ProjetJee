<html>
  <head>
    <meta name="layout" content="main" />
    <title>mail</title>         
  </head>
  <body>
    <div class="body">
      <h1>mail</h1>
      <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
      </g:if>
      <g:form action="authenticate" method="post" >
        <div class="dialog">
          <table>
            <tbody>            
              <tr class="prop">
                <td class="name">
                  <label for="mail">mail:</label>
                </td>
                <td>
                  <input type="text" id="mail" name="mail"/>
                </td>
              </tr> 
          
              <tr class="prop">
                <td class="name">
                  <label for="pwd">pwd:</label>
                </td>
                <td>
                  <input type="pwd" id="pwd" name="pwd"/>
                </td>
              </tr> 
            </tbody>
          </table>
        </div>
        <div class="buttons">
          <span class="button">
            <input class="save" type="submit" value="mail" />
          </span>
        </div>
      </g:form>
    </div>
  </body>
</html>