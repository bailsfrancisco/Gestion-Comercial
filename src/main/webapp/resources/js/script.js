
var EMAIL_REGEX = /^\w+(-*?\w+)*@\w+(-*?\w+)*(\.\w{2,3})*$/;
var PASSWD_LENGTH = 4;

var validar_login = function(){
    var emailInput = document.getElementById("user-email").value;
    var passwordInput = document.getElementById("user-password").value;
    if (emailInput && passwordInput){
        // chequear si es una email valido y la logitud de la contraseña es mayor o igual a 8
        var isValidEmail = EMAIL_REGEX.test(emailInput);
        var isValidPassword = passwordInput.length >= PASSWD_LENGTH;

        if (isValidEmail && isValidPassword){
            return true;
        }
    }
    var validationError = document.getElementById("validation_error");
    validationError.innerText = "email invalido o contraseña menor a 8 caracteres alfanumericos";
    return false;
};