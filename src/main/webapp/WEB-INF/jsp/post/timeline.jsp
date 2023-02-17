<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Financialgram</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  	
  	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
  	
  	<link rel="stylesheet" href="/static/css/style.css" type="text/css">
</head>
<body>

	<div class="container">
		<c:import url="/WEB-INF/jsp/include/header.jsp" />
		<section class="d-flex justify-content-center">
			<!--  timeline -->
			<div class="col-5">
				<!-- 입력 상자 -->
				<div class="border rounded">
					<textarea class="form-control border-0" rows="4" id="contentInput"></textarea>
				
					<div class="d-flex justify-content-between mt-2">
						<a href="#" id="imageIcon" class="ml-3"> <i class="bi bi-image image-icon"></i> </a>
						<input type="file" id="fileInput" class="d-none">
						<button type="button" class="btn btn-primary" id="uploadBtn">업로드</button>
					
					</div>
				</div>
				<!-- /입력 상자 -->
				<!-- 피드 -->
				<div class="mt-3">
					<!-- 카드 -->
					<div class="border rounded mt-2">
						<div class="d-flex justify-content-between p-2">
							<div>username</div>
							
							<%--해당 게시글이 로그인한 사용자의 게시글인 경우 more 버튼 노출 --%>
							<a href="#" class="more-btn" ><i class="bi bi-three-dots"></i></a>
						</div>
						
						<div>
							<img class="w-100" src="https://cdn.pixabay.com/photo/2023/01/27/06/17/pheasant-7747830_960_720.jpg">
						</div>
						
						<div class="p-2">
							<%-- 로그인한 사용자가 좋아요한 게시물 --%>
							<a href="#" class="unlike-btn"><i class="bi bi-heart-fill text-danger"></i></a>
							<%-- 로그인한 사용자가 좋아요를 하지 않은 게시물 --%>
							<a href="#" class="like-btn"><span class=""><i class="bi bi-heart"></i></span></a>
							좋아요 3개
						</div>
						
						<div class="p-2" >
							<b>username</b>content
						</div>
						<!--  댓글들! -->
						<div class="p-2">
							<div class="small">댓글</div>
							<hr>
							<div class="small"><b>userName</b>content</div>
	
	
							<!--  댓글 입력 -->
							<div class="d-flex mt-1">
								<input type="text" class="form-control">
								<button type="button" class="btn btn-primary comment-btn">게시</button>
							</div>
							<!--  /댓글 입력 -->
						
						</div>
						<!--  /댓글들! -->
					</div>
				</div>
			</div>
			<!--  /timeline -->
		</section>
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
	
	</div>
	<!-- Modal -->
	<div class="modal fade" id="moreModal" tabindex="-1" role="dialog">
	  <div class="modal-dialog modal-dialog-centered" role="document">
	    <div class="modal-content">
	      
	      <div class="modal-body text-center">
	        <a href="#" id="deleteBtn"> 삭제하기 </a>
	      </div>
	      
	    </div>
	  </div>
	</div>
	<script>
		$(document).ready(function() {
		}
	
	</script>
	
	
	
	
	
	

</body>
</html>