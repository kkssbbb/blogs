<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>  <!--layout폴더의 header 머스테치 파일을 포함한다.라는 뜻-->

<div class = "container">
<form action="/auth/loginProc" method="post">
    <div class="form-group">
        <label for="username">UserName:</label>
        <input type="text" name="username" class="form-control" placeholder="Enter username" id="username">
    </div>

    <div class="form-group">
        <label for="password">Password:</label>
        <input type="password" name="password" class="form-control" placeholder="Enter password" id="password">
    </div>

    <div class="form-group form-check">
        <label class="form-check-label">
            <input name="remember" class="form-check-input" type="checkbox"> 아이디 기억하기
        </label>
    </div>
    <button id="btn-login" class="btn btn-primary">로그인</button>
</form>
</div>

<script src="/js/user/user.js"></script>

<%@ include file="../layout/footer.jsp"%>