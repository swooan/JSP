<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	window.onload = function() {
		var form = document.forms[0];
		form.onsubmit = function() {
			event.preventDefault();
			
			if(this.title.value=="") {
				alert("제목은 필수 입력입니다.");
				this.title.focus();
				return;
			}
			if(this.author.value=="") {
				alert("작성자 필수 입력입니다.");
				this.author.focus();
				return;
			}
			
			this.submit();
		}
	}
</script>
</head>
<body>

<form method="post" action="<%=request.getContextPath()%>/board?action=write.do">
	<table>
      <tr>
         <th width="100" align="right">*작성자 :&nbsp;</th>
         <td><input type="text" size="20" maxlength="100" name="author" value="이순신"/></td>
      </tr>
      <tr>
         <th width="100" align="right">이메일 :&nbsp;</th>
         <td><input type="text" size="30" maxlength="200" name="email" value="lee@lee.com"/></td>
      </tr>
      <tr>
         <th width="100" align="right">*제목 :&nbsp;</th>
         <td><input type="text" size="70" maxlength="500" name="title" value="난중일기"/></td>
      </tr>
      <tr>
         <th width="100" align="right">내용 :&nbsp;</th>
         <td><textarea rows="10" cols="65" maxlength="4000" name="content">한산도대첩</textarea></td>
      </tr>
      <tr>
         <th width="100" align="right">비밀번호 :&nbsp;</th>
         <td><input type="password" size="10" maxlength="12" name="passwd" value="1111" /></td>
         <td>&nbsp;(글 수정/삭제 시 필요합니다.)</td>
      </tr>
      <tr>
         <td width="100" align="right"></td>
         <td>
            <input type="submit" value="작성" /> <!-- <a href="javascript:FormSubmit(BoardWriteForm);"> Write </a> -->
            <a href="/webapp/board?action=list">List</a>
         </td>
      </tr>
   </table>
</form>

</body>
</html>