<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://bootswatch.com/4/yeti/bootstrap.min.css">
<!-- 
<script type="text/javascript">

	$(function() {
		$("#id").blur(function() {
			var id = $(this).val();
			$("#btn").on("click", function() {
				/* $.ajax({
					url: "../ajax/memberList",
					type: "get",
					success: function(data) {
						$("#result").html(data);
					}
				}); */
				
				$.get("../ajax/memberList", function(data) {
					$(data).each(function() {
						alert(this.id);
					});
					
					/* $("#result").html(data); */
				}); 
				
			})
			
			$.get("../ajax/checkId", function(data) {
				alert(data.id);
				alert(data.name);
			});
		});
	});
</script>
 -->
<style>
	label {
		float: left;
	}
</style>
<body style="margin:0 auto; width: 50%; height: 700px;">
	<section>
		<form class="form-horizontal" id="frm" name="frm" action="memberJoin" method="post" style="text-align: center;">
			<div class="form-group">
				<label class="control-label" for="">아이디</label>
				<input type="text" class="form-control" id="id" name="id" placeholder="아이디" >
				<p id="idCheck"></p>	
			</div>
			
			<div class="form-group">
				<label class="control-label" for="">비밀번호</label>
				<input type="password" class="form-control" id="pw" name="pw" placeholder="비밀번호" >
			</div>
			
			<div class="form-group">
				<label class="control-label" for="">비밀번호 확인</label>
				<input type="password" class="form-control" id="pw2" name="pw2" placeholder="비밀번호 확인" >
			</div>
			
			<div class="form-group">
				<label class="control-label" for="">이름</label>
				<input type="text" class="form-control" id="name" name="name" placeholder="이름" >
			</div>
			
			<div class="form-group">
				<label class="control-label" for="">연락처</label>
				<input type="text" class="form-control" id="phone" name="phone" placeholder="연락처" >
			</div>
			
			<div class="form-group">
				<label class="control-label" for="">나이</label>
				<input type="text" class="form-control" id="age" name="age" placeholder="나이" >
			</div>
			
			<div class="form-group">
				<div>
					<input type="radio" name="job" value="teacher">Teacher
					<input type="radio" name="job" value="student">Student
				</div>
			</div>
			
			<!-- Student -->
			<div id="student-form">
				<div class="form-group">
					<label class="control-label" for="">TID</label>
					<input type="text" class="form-control" id="tid" name="tid" placeholder="TID" >
				</div>
				
				<div class="form-group">
					<label class="control-label" for="">생년월일</label>
					<input type="date" class="form-control" id="birth" name="birth">
				</div>
				
				<div class="form-group">
					<label class="control-label" for="">학년</label>
					<input type="text" class="form-control" id="grade" name="grade" placeholder="학년" >
				</div>
			</div>
			<!-- Teacher -->
			<div id="teacher-form">
				<div class="form-group">
					<label class="control-label" for="">Hiredate</label>
					<input type="date" class="form-control" id="hiredate" name="hiredate" placeholder="Hiredate" >
				</div>
				
				<div class="form-group">
					<label class="control-label" for="">과목</label>
					<input type="text" class="form-control" id="subject" name="subject" placeholder="과목" >
				</div>
				
				<div class="form-group">
					<label class="control-label" for="">연봉</label>
					<input type="text" class="form-control" id="sal" name="sal" placeholder="연봉" >
				</div>
			</div>
		</form>
		
		<button id="btn" value="memberList">Submit</button>
		<div id="result"></div>
	</section>
</body>
</html>