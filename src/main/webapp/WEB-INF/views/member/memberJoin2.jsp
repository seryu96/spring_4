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
<style>
	label {
		float: left;
	}
	#student-form {
		display: none;
	}
	#teacher-form {
		display: none;
	}
</style>
<script type="text/javascript">
	$(function() {
		var job = "student-form";
		$("#btn").click(function() {
			if(job == "student-form") {
				$("#frm").attr("action", "./student/memberJoin");			
			} else {
				$("#frm").attr("action", "./teacher/memberJoin");	
			}
			$("#frm").submit();
		});
		
		$(".job").click(function() {
			var job = $(this).val();
			if(job == "teacher") {
				$("#teacher-form").css("display", "inline");
				$("#student-form").css("display", "none");
			} else {
				$("#teacher-form").css("display", "none");
				$("#student-form").css("display", "inline");
			}
		});
	});

</script>
<body style="margin:0 auto; width: 50%; height: 700px;">
	<section>
		<form class="form-horizontal" id="frm" name="frm" action="./memberJoin" method="post" style="text-align: center;">
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
					<input type="radio" class="job" name="job" value="teacher">Teacher
					<input type="radio" class="job" name="job" value="student">Student
				</div>
			</div>
			
			<!-- Student -->
			<div id="student-form">
				<div class="form-group">
					<label class="control-label" for="">TID</label>
					<input type="text" class="form-control" id="tid" name="studentDTO.tid" placeholder="TID" >
				</div>
				
				<div class="form-group">
					<label class="control-label" for="">생년월일</label>
					<input type="date" class="form-control" id="birth" name="studentDTO.birth">
				</div>
				
				<div class="form-group">
					<label class="control-label" for="">학년</label>
					<input type="number" class="form-control" id="grade" name="studentDTO.grade" value="1" placeholder="학년" >
				</div>
			</div>
			
			<!-- Teacher -->
			<div id="teacher-form">
				<div class="form-group">
					<label class="control-label" for="">Hiredate</label>
					<input type="date" class="form-control" id="hiredate" name="teacherDTO.hiredate" placeholder="Hiredate" >
				</div>
				
				<div class="form-group">
					<label class="control-label" for="">과목</label>
					<input type="text" class="form-control" id="subject" name="teacherDTO.subject" placeholder="과목" >
				</div>
				
				<div class="form-group">
					<label class="control-label" for="">연봉</label>
					<input type="number" class="form-control" id="sal" name="teacherDTO.sal" value="0" placeholder="연봉" >
				</div>
			</div>
		</form>
		<button id="btn">Submit</button>
	</section>
</body>
</html>