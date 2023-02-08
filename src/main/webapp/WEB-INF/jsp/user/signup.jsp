<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<link rel="stylesheet" href="/static/css/style.css" type="text/css">
</head>
<body>
	<div id="wrap">
		<c:import url="/WEB-INF/jsp/include/header.jsp"/>
		<section class="contents d-flex justify-content-center">
			<div class="join-box rounded mt-5">
				<h2 class="text-center text-white">SignUp</h2>
				<div class="col-11">
					<input type="text" placeholder="UserId" class="form-control ml-4 mt-3" id="idInput">
					<input type="password" placeholder="Password" class="form-control ml-4 mt-3"id="passwordInput">
					<input type="password" placeholder="PasswordCheck" class="form-control ml-4 mt-3" id="passwordChkInput">
					<input type="text" placeholder="Username" class="form-control ml-4 mt-3" id="nameInput">
					<input type="text" placeholder="Email" class="form-control ml-4 mt-3" id="emailInput">
					<button type="button" class="btn btn-block bg-primary ml-4 mt-3 text-white" id="joinBtn">회원가입</button>
				</div>
			</div>
		</section>
		<c:import url="/WEB-INF/jsp/include/footer.jsp"/>
	</div>
	<script>
		$(document).ready(function(){
			$("#joinBtn").on("click",function(){
				let id = $("#idInput").val();
				let password = $("#passwordInput").val();
				let passwordChk = $("#passwordChkInput").val();
				let name = $("#nameInput").val();
				let email = $("#emailInput").val();
				let urlAddress = [".co.kr",".com",".net",".or.kr","go.kr"];
				let check1 = false;
				let check2 = false;
				
				if(id == ""){
					alert("아이디를 입력해주세요");
					return;
				}
				if(password == ""){
					alert("비밀번호를 입력해주세요");
					return;
				}
				if(name == ""){
					alert("이름을 입력해주세요");
					return;
				}
				if(email == ""){
					alert("이메일을 입력해주세요");
					return;
				}
				
				if(email.indexOf("@") > 0){
					check1 = true;
				}
				for(var i=0; i < urlAddress.length; i++){
					if(email.indexOf(urlAddress[i]) > 0){
						check2 = true;
					}
				}
				if(!(check1 && check2)){
					alert("이메일 형식을 확인해주세요");
					return;
				}
				if(password != passwordChk){
					alert("비밀번호가 일치하지 않습니다.");
					return;
				}
			});
		});
	</script>
</body>
</html>