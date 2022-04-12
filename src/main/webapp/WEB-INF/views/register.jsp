<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="fragments/header-register.jsp" %>
<!DOCTYPE html>
<%--import header--%>


<section class="login-page">
    <h2>Załóż konto</h2>
    <form:form method="post" modelAttribute="user">
        <form:hidden path="id"/>
        <div class="form-group">
            <form:input type="text" name="firstname" placeholder="Imię" path="firstname"/>
        </div>
        <div class="form-group">
            <form:input type="text" name="lastname" placeholder="Nazwisko" path="lastname"/>
        </div>
        <div class="form-group">
            <form:input type="email" name="username" placeholder="Email" path="username"/>
        </div>
        <div class="form-group">
            <input type="password" name="password" placeholder="Hasło" />
        </div>
        <div class="form-group">
            <input type="password" name="password2" placeholder="Powtórz hasło"/>
        </div>

        <div class="form-group form-group--buttons">
            <a href="/login" class="btn btn--without-border">Zaloguj się</a>
            <button class="btn" type="submit">Załóż konto</button>
        </div>
    </form:form>
</section>


<%@ include file="fragments/footer.jsp" %>
