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
<script type="text/javascript">
	$(function() {
		$("#id1").blur(function() {
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

<style>
	label {
		float: left;
	}
</style>
<body>
<section>
	<h1 style="text-align: center;">회원가입</h1>
		<div class="container">
			<form class="form-horizontal" id="frm" name="frm" action="memberJoin" method="post" style="text-align: center;">
				<div class="form-group">
					<label class="control-label " for="pw">아이디</label>
						<div class="">
							<input type="text" class="form-control" id="id1" name="id" placeholder="아이디" >
							<p id="idCheck"></p>	
						</div>
					</div>
					
			</form>
			<button id="btn" value="memberList">Go</button>
			<div id="result"></div>
		</div>
	</section>
</body>
</html>