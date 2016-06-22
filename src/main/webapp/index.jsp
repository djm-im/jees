<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <%@ include file="/WEB-INF/jspf/header.jspf" %>

    <body id='body-login'>

        <!--login modal-->
        <div id="loginModal" class="modal show" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="text-center">Login</h1>
                    </div>
                    <div class="modal-body">
                        <%@ include file="/WEB-INF/jspf/messages.jspf" %>

                        <form class="form col-md-12 center-block" role='form' action='login' method='POST'>
                            <div class="form-group">
                                <input type="text" name='username'
                                       class="form-control input-lg" placeholder="Email">
                            </div>
                            <div class="form-group">
                                <input type="password" name='password'
                                       class="form-control input-lg" placeholder="Password">
                            </div>
                            <div class="form-group">
                                <button type='submit' class="btn btn-primary btn-lg btn-block">
                                    Sign In
                                </button>
                                <span class="pull-left">
                                    <a href="#">Forgot password</a>
                                </span>
                                <span class="pull-right">
                                    <a href="#">Register</a>
                                </span>
                            </div>
                        </form>
                    </div>

                    <div class="modal-footer"></div>
                </div>
            </div>
        </div>
    </body>
</html>
