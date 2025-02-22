
let url = "http://localhost:8080";

//document.addEventListener("DOMContentLoaded", autofill());
//document.addEventListener("submit", captureLoginInfo());


function autofill() {
    const fields = getFields();

    const emailField = fields.emailField;
    const usernameField = fields.usernameField;
    const passwordField = fields.passwordField;


    var currentEmail;
    var currentUsername;
    var currentPassword;


    const getLoginInfo = async () => {
        const response = await fetch(url);
        const loginInfo = await response.json(); //extract JSON from the http response

        currentEmail = loginInfo.currentEmail;
        currentUsername = loginInfo.currentUsername;
        currentPassword = loginInfo.currentPassword;
    }


    getLoginInfo();
    // currentEmail = "asldf@sldfa.sdf";
    // currentUsername = "testusername";
    // currentPassword = "testpassword123";


    if (emailField && currentEmail) {
        emailField.value = currentEmail;
    }
    if (usernameField && currentUsername) {
        usernameField.value = currentUsername;
    }
    if (passwordField && currentPassword) {
        passwordField.value = currentPassword;
    }
}

const getLoginInfo = async () => {
    const response = await fetch(url);
    const loginInfo = await response.json(); //extract JSON from the http response

    currentEmail = loginInfo.currentEmail;
    currentUsername = loginInfo.currentUsername;
    currentPassword = loginInfo.currentPassword;
}


// function captureLoginInfo() {
//     console.log("submit happened")
//     const fields = getFields();

//     var capturedEmail;
//     var capturedUsername;
//     var capturedPassword;

//     if (fields.emailField) {
//         capturedEmail = fields.emailField.value;
//         console.log(capturedEmail);
//     }
// }


function getFields() {
    const emailField = document.querySelector("input[type=email]");
    const usernameField = document.querySelector("input[type=username]");
    const passwordField = document.querySelector("input[type=password]");

    return {
        emailField: emailField,
        usernameField: usernameField,
        passwordField: passwordField
    };
}